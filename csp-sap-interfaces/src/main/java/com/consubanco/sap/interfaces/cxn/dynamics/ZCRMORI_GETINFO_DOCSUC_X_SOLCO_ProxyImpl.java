package com.consubanco.sap.interfaces.cxn.dynamics;

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
import com.sap.conn.jco.JCoTable;


public class ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl.class );
	
	public ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_GETINFO_DOCSUC_X_SOLCO" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_GETINFO_DOCSUC_X_SOLCO not found in SAP.");
			
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
			
			log.info( "INPUT DATA :: " + function.getImportParameterList().toString() );
		
			function.execute(destination);

			JCoTable data = function.getExportParameterList().getTable("ET_DOCS_SUCURS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_GETINFO_DOCSUC_X_SOLCO_OutputData tableData = new ZCRMORI_GETINFO_DOCSUC_X_SOLCO_OutputData();
				
				tableData.setRequestId( data.getString("ID_SOLICITUD") );
				tableData.setCrmConvenio( data.getString("ID_CONVENIO_CRM") );
				tableData.setBrmsConvenio( data.getString("ID_CONVENIO_BRMS") );
				tableData.setStatusId( data.getString("ULT_STATUS") );
				tableData.setStatusDesc( data.getString("DESC_STATUS") );
				tableData.setLastStatusDate( data.getDate("FEC_ULTSTATS") );
				tableData.setDocumentId( data.getString("ZID_DOCTO") );
				tableData.setFieldId( data.getString("ZID_CAMPO") );
				tableData.setValue( data.getString("ZVALOR") );
				
				returnList.add( tableData );				
			}
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_GETINFO_DOCSUC_X_SOLCO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
