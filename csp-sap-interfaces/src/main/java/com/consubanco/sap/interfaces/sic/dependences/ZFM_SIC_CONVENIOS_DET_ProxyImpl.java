package com.consubanco.sap.interfaces.sic.dependences;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.sic.model.ZFM_SIC_CONVENIOS_MOVS_model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZFM_SIC_CONVENIOS_DET_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZFM_SIC_CONVENIOS_DET_ProxyImpl.class );
	
	public ZFM_SIC_CONVENIOS_DET_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZFM_SIC_CONVENIOS_DET" );
			if(ft == null)
				throw new RuntimeException("ZFM_SIC_CONVENIOS_DET not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("TL_CONV_DET");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZFM_SIC_CONVENIOS_DET_OutputData tableData = new ZFM_SIC_CONVENIOS_DET_OutputData();
				
				tableData.setDependenceId( data.getString("PARTNER") );
				tableData.setDependenceDesc( data.getString("NAME_FIRST") );
				tableData.setFrecuency( data.getString("ZFREC") );
				tableData.setFrecuencyInstallation( data.getString("ZATT_FREPAGCOB") );
				
				//TODO: quitar movementTypes para fase 2 SIC
				ArrayList<String> movementTypes = new ArrayList<String>();
				if( data.getString("ZTLALTA").equals("X") )
					movementTypes.add( "ALTA" );
				if( data.getString("ZTLBAJA").equals("X") )
					movementTypes.add( "BAJA" );
				if( data.getString("ZTLCAMB").equals("X") )
					movementTypes.add( "CAMBIO" );
				
				tableData.setMovementTypes( movementTypes );
				
				ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes = new ArrayList<ZFM_SIC_CONVENIOS_MOVS_model>();
				if( data.getString("ZTLALTA").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "ALTA" );
					attributeModel.setOrderType( data.getString("ZO_ALTA") );
					attributes.add( attributeModel );
				}
					
				if( data.getString("ZTLBAJA").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "BAJA" );
					attributeModel.setOrderType( data.getString("ZO_BAJA") );
					attributes.add( attributeModel );
				}
					
				if( data.getString("ZTLCAMB").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "CAMBIO" );
					attributeModel.setOrderType( data.getString("ZO_CAMB") );
					attributes.add( attributeModel );
				}
				tableData.setAttributes(attributes);
				
				tableData.setConsolidationFileType( data.getString("ZCARCH") );
				returnList.add( tableData );
						
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZFM_SIC_CONVENIOS_DET" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
