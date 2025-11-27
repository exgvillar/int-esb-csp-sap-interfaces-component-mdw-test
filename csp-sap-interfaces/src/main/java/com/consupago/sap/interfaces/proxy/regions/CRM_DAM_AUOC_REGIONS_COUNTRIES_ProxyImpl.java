package com.consupago.sap.interfaces.proxy.regions;

import java.util.ArrayList;
import java.util.Iterator;

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

public class CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl.class );
	
	private final String RFC_NAME = "CRM_DAM_AUOC_REGIONS_COUNTRIES";
	
	public CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("ET_T005U");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				CRM_DAM_AUOC_REGIONS_COUNTRIES_OutputData output = new CRM_DAM_AUOC_REGIONS_COUNTRIES_OutputData();
				output.setClaveIdioma( data.getString("SPRAS") );
				output.setClavePais( data.getString("LAND1") );
				output.setMandante( data.getString("MANDT") );
				output.setDenominacion( data.getString("BEZEI") );
				output.setRegion( data.getString("BLAND") );
				
				returnList.add( output );
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
