package com.consupago.sap.interfaces.proxy.cdb.catalogs.lcom;

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

public class ZRFC_LIST_COMPETIDOR_COINCIDE2_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_LIST_COMPETIDOR_COINCIDE2_ProxyImpl.class );
	
	public ZRFC_LIST_COMPETIDOR_COINCIDE2_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_LIST_COMPETIDOR_COINCIDE2");
			if(ft == null)
	            throw new RuntimeException("ZRFC_LIST_COMPETIDOR_COINCIDE2 not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("IT_BUT000");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_LIST_COMPETIDOR_COINCIDE2_OutputData output = new ZRFC_LIST_COMPETIDOR_COINCIDE2_OutputData();
				output.setBusinessPartnerId( data.getString("PARTNER") );
				output.setNameOrg1( data.getString("NAME_ORG1") );
				output.setNameOrg2( data.getString("NAME_ORG2") );
				output.setNameOrg3( data.getString("NAME_ORG3") );
				output.setNameOrg4( data.getString("NAME_ORG4") );
				output.setPago( data.getString("PAGO") );
				output.setFrecuencia( data.getString("FRECUENCIA") );
				output.setShortname( data.getString("TITLE_LET") );
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_LIST_COMPETIDOR_COINCIDE2" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
