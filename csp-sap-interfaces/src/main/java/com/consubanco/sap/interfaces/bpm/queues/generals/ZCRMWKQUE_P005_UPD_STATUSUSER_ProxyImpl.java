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

public class ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl.class );
	
	public ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P005_UPD_STATUSUSER" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P005_UPD_STATUSUSER not found in SAP.");
			
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
			
			ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData tableData = new ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData();
			
			tableData.setResult( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			tableData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
				
			returnList.add( tableData );	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P005_UPD_STATUSUSER :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
