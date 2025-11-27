package com.consubanco.sap.interfaces.cxn.references;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P001_CREATE_BPRELACS_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_P001_CREATE_BPRELACS_ProxyImpl.class );
	
	public ZCRMORI_P001_CREATE_BPRELACS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ZTT_REFERENCIAS_OutputData> referenceList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P001_CREATE_BPRELACS" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P001_CREATE_BPRELACS not found in SAP.");
			
			function = ft.getFunction();

						
			JCoTable data = function.getImportParameterList().getTable("IT_RELACS");
			
			
			Iterator<ZTT_REFERENCIAS_OutputData> iter = referenceList.iterator();
			while( iter.hasNext() ) {
				ZTT_REFERENCIAS_OutputData referenceData = iter.next();
				
				data.appendRow();
				data.setValue("CLIENTE", referenceData.getClientId());
				data.setValue("REFEREN", referenceData.getReferenceId() );
				data.setValue("TIPREL", referenceData.getRelationshipType() );
				data.setValue("PARENT", referenceData.getRelationshipCategory() );
				data.setValue("DESCRI", referenceData.getDescription() );
				
			}
			
			function.getImportParameterList().setValue("IT_RELACS", data);
			
			log.info( "Input Parameters List :: " +  function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			ZCRMORI_P001_CREATE_BPRELACS_OutputData returnData = new ZCRMORI_P001_CREATE_BPRELACS_OutputData();
			
			returnData.setErrorMessage(function.getExportParameterList().getString("E_MESSAGE"));
			returnData.setSuccessfullIndicator( function.getExportParameterList().getString("E_OK") );
			returnList.add( returnData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P001_CREATE_BPRELACS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
