/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

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

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl.class);

	/**
	 * 
	 */
	public ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(
			JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMBT_P003_SAVE_DICTAMEN_BRMS" );
			if(ft == null)
				throw new RuntimeException("ZCRMBT_P003_SAVE_DICTAMEN_BRMS not found in SAP.");
			
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
			
			log.info( function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData data = new ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData();
			String success = function.getExportParameterList().getString("E_EXITO");
			
			if( "X".equalsIgnoreCase( success ) ){
				data.setSuccess(Boolean.TRUE);
			}
			data.setMessage( function.getExportParameterList().getString("E_MENSAJE") );
			
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMBT_P003_SAVE_DICTAMEN_BRMS :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

}
