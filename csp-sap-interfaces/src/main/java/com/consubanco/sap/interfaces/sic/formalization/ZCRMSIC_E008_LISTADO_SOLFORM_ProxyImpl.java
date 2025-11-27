package com.consubanco.sap.interfaces.sic.formalization;

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

public class ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl.class );
	
	public ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMSIC_E008_LISTADO_SOLFORM" );
			if(ft == null)
				throw new RuntimeException("ZCRMSIC_E008_LISTADO_SOLFORM not found in SAP.");
			
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
			
			JCoTable data = function.getTableParameterList().getTable("T_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMSIC_E008_LISTADO_SOLFORM_OutputData tableData = new ZCRMSIC_E008_LISTADO_SOLFORM_OutputData();
				
				tableData.setRequestId( data.getString("OBJECT_ID") );
				tableData.setAccountId( data.getString("ACCOUNT_ID") );
				tableData.setCreateDate( data.getDate("UDATE") );
				tableData.setCreateTime( data.getString("UTIME") );
				
				returnList.add( tableData );
						
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMSIC_E008_LISTADO_SOLFORM" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
