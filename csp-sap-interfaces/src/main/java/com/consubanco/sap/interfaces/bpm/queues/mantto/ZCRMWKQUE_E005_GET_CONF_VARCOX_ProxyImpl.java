package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl.class );
	
	public ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E005_GET_CONF_VARCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E005_GET_CONF_VARCOX not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData tableData = new ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData();

				tableData.setId( data.getString("ZCLAVE") );
				tableData.setFieldName( data.getString("ZNOMBRE") );
				tableData.setType( data.getString("ZTIPO") );
				tableData.setValue( data.getString("ZVALOR") );
				tableData.setRatePriority( data.getInt("ZCALIF_PRIORI") );
				tableData.setRequestedBy( data.getString("ZSOLICITADO_POR") );
				tableData.setAuthorized( data.getString("ZAUTORIZADO").equals("X") ? true : false );
				tableData.setAuthorizedBy( data.getString("ZAUTORIZADO_POR") );
				tableData.setCreateDate( data.getDate("ZFECHA_CREA") );
				tableData.setLastUpdateDate( data.getDate("ZFECHA_ULT_STAT") );
				tableData.setActive( data.getString("ZACTIVO").equals("X") ? true : false );
				
				returnList.add( tableData );	
			}	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E005_GET_CONF_VARCOX" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
