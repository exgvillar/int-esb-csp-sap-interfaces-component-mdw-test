package com.consupago.sap.interfaces.proxy.casemgt;

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

public class ZRFC_CASE_ATTACH_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CASE_ATTACH_ProxyImpl.class );
	
	public ZRFC_CASE_ATTACH_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_CASE_ATTACH");
			if(ft == null)
	            throw new RuntimeException("ZRFC_CASE_ATTACH not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_ATTACH_LIST");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_CASE_ATTACH_OutputData output = new ZRFC_CASE_ATTACH_OutputData();
				output.setCaseId( data.getString("ZCASO") );
				output.setGuid( data.getString("ZGUID") );
				output.setCreatedBy( data.getString("ZUCREADO") );			
				output.setCreatedDate( data.getString("ZFCREADO") );
				output.setUpdatedBy( data.getString("ZUMODIFICADO") );
				output.setUpdatedDate( data.getString("ZFMODIFICADO") );
				output.setName( data.getString("ZNOMBRE") );
				output.setDescription( data.getString("ZDESCRIPCION") );
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_CASE_ATTACH" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
