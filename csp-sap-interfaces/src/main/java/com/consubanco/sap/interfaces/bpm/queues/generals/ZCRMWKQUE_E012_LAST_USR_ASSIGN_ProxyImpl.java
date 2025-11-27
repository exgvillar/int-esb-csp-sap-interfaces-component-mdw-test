package com.consubanco.sap.interfaces.bpm.queues.generals;

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

public class ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl.class );
	
	public ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E012_LAST_USR_ASSIGN" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E012_LAST_USR_ASSIGN not found in SAP.");
			
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
			
//			log.info( function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E012_LAST_USR_ASSIGN_OutputData tableData = new ZCRMWKQUE_E012_LAST_USR_ASSIGN_OutputData();
				tableData.setFolioApplication( data.getString("ZFOLIO_APPLI") );
				tableData.setUserName( data.getString("ZUSER_NAME") );
				tableData.setExecutorRole( data.getString("ZEXCEC_ROL") );
				tableData.setStatus( data.getString("ZDESC_ESTATUS") ); 
				returnList.add( tableData );	
			}	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E012_LAST_USR_ASSIGN :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
