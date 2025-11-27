package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CATEGORIAS_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_PRODUCTS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl.class );
	
	public ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E004_GTPRI_CONV_CATP" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E004_GTPRI_CONV_CATP not found in SAP.");
			
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
			
			ZCRMWKQUE_E004_GTPRI_CONV_CATP_OutputData tableData = new ZCRMWKQUE_E004_GTPRI_CONV_CATP_OutputData();
			tableData.setConveniosList( new ArrayList<ZM_CONVENIOS_Model>() );
			tableData.setCategoriesList( new ArrayList<ZM_CATEGORIAS_Model>() );
			
			JCoTable convData = function.getExportParameterList().getTable("E_CONVENIOS");
			log.info( "" +  convData.toString() );
			for (int i = 0; i < convData.getNumRows(); i++, convData.nextRow() ) {
				ZM_CONVENIOS_Model convenio = new ZM_CONVENIOS_Model();
				convenio.setConvenioId( convData.getString("ZID_CONVENIO") );
				convenio.setConvenioDesc( convData.getString("ZDESC_CONVENIO") );
				convenio.setRatePriority( convData.getInt("ZCALIFICACION") );
				
				JCoTable prodData = convData.getTable("ZPRODUCTOS");
				convenio.setProductsList( new ArrayList<ZM_PRODUCTS_Model>() );
				log.info( "" +  prodData.toString() );
				for (int j = 0; j < prodData.getNumRows(); j++, prodData.nextRow() ) {
					ZM_PRODUCTS_Model producto = new ZM_PRODUCTS_Model();
					producto.setProductId( prodData.getString("ZID_PRODUCTO") );
					producto.setProductDesc( prodData.getString("ZDESC_PRODUCTO") );
					producto.setRatePriority( prodData.getInt("ZCALIFICACION") );
					convenio.getProductsList().add( producto );
				}
				
				tableData.getConveniosList().add( convenio );
			}
	
			JCoTable categoryData = function.getExportParameterList().getTable("E_CATEGORIAS");
			log.info( "" +  categoryData.toString() );
			for (int i = 0; i < categoryData.getNumRows(); i++, categoryData.nextRow() ) {
				ZM_CATEGORIAS_Model category = new ZM_CATEGORIAS_Model();
				category.setCategoryId( categoryData.getString("ZID_CATEGORIA") );
				category.setCategoryDesc( categoryData.getString("ZDESC_CATEGORIA") );
				category.setRatePriority( categoryData.getInt("ZCALIFICACION") );
				tableData.getCategoriesList().add( category );
			}
			
			returnList.add( tableData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E004_GTPRI_CONV_CATP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
