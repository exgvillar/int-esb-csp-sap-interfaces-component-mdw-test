package com.consubanco.sap.interfaces.cxn.references;

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

public class ZCRMORI_E001_GET_BPCLIENT_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E001_GET_BPCLIENT_ProxyImpl.class );
	
	public ZCRMORI_E001_GET_BPCLIENT_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E001_GET_BPCLIENT" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E001_GET_BPCLIENT not found in SAP.");
			
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
			
			log.info( "Input Parameters List :: " +  function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("ET_RELACIONES");
			
			log.info( "Return Table :: " +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E001_GET_BPCLIENT_OutputData tableData = new ZCRMORI_E001_GET_BPCLIENT_OutputData();
				tableData.setClientId( data.getString("CLIENTE") );
				tableData.setDescription( data.getString("DESCRI") );
				tableData.setReferenceId( data.getString("REFEREN") );
				tableData.setRelationshipCategory( data.getString("TIPREL") );
				tableData.setRelationshipType( data.getString("PARENT") );
				
				returnList.add( tableData );
			}
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E001_GET_BPCLIENT" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
