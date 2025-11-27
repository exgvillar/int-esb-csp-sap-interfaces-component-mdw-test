package com.consupago.sap.interfaces.proxy.calendar;

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

public class Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl.class );
	
	public Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("Z_RFC_BRMS_CRM_CALCULAFECHA");
			if(ft == null)
	            throw new RuntimeException("Z_RFC_BRMS_CRM_CALCULAFECHA not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}			
			}
			
			
			function.execute(destination);
			
			Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData output = new Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData();
			
			output.setFechaCalculada( function.getExportParameterList().getDate("E_FECHA")  );
			
			returnList.add( output );
	
		} catch (AbapException e) {
			log.error(" executing function " + "Z_RFC_BRMS_CRM_CALCULAFECHA" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
