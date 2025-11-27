package com.consubanco.sap.interfaces.bpm.queues.recaptures;

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

public class ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl.class );
	
	
	public ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRWKQUE_P003_UPD_CONT_RECAP" );
			if(ft == null)
				throw new RuntimeException("ZCRMRWKQUE_P003_UPD_CONT_RECAP not found in SAP.");
			
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
			
			ZCRMRWKQUE_P003_UPD_CONT_RECAP_OutputData data = new ZCRMRWKQUE_P003_UPD_CONT_RECAP_OutputData();
			
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			data.setSuccess( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );;
			
			returnList.add( data );	
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRWKQUE_P003_UPD_CONT_RECAP :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
