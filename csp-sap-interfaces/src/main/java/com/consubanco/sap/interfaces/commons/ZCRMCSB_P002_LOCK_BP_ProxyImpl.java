/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_LOCK_BP_ProxyImpl {
	
	private static Log log = LogFactory.getLog(ZCRMCSB_P002_LOCK_BP_ProxyImpl.class);

	/**
	 * 
	 */
	public ZCRMCSB_P002_LOCK_BP_ProxyImpl() {
	}

	
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P002_LOCK_BP");
			if(ft == null)
	            throw new RuntimeException("ZCRMCSB_P002_LOCK_BP not found in SAP.");
			
			function = ft.getFunction();
	
			
			Iterator<ProxyInputParameter> iterator = inputParamtersList.iterator();
			
			while (iterator.hasNext()) {
				ProxyInputParameter inputParameter = iterator.next();
				if( StringUtils.trimToNull( inputParameter.getType() ) == null ){
					function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
				}else{
					if(inputParameter.getType().equals("java.util.date")){
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getDateValue());
					}else{
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
					}
					
				}
			}
			
			function.execute(destination);
			
			log.info(function.toString());
			
    		ZCRMCSB_P002_LOCK_BP_OutputData data = new ZCRMCSB_P002_LOCK_BP_OutputData();
    		
    		data.setMessage("BP is Locked");
    		
    		returnList.add(data);
    		
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P002_LOCK_BP" , e);
			throw e;
		}
		
		return returnList;
	}
}
