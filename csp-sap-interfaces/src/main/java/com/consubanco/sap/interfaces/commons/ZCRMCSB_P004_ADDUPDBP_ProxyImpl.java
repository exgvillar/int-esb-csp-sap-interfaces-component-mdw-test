package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.utils.lang.ExceptionUtils;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;

public class ZCRMCSB_P004_ADDUPDBP_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMCSB_P004_ADDUPDBP_ProxyImpl.class );
	
	public ZCRMCSB_P004_ADDUPDBP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, boolean cleanCurp) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		String errorMessage = null;
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCSB_P004_ADDUPDBP" );
			if(ft == null)
				throw new RuntimeException("ZCRMCSB_P004_ADDUPDBP not found in SAP.");
			
			function = ft.getFunction();
			
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					if( inputParam.getKey().equals("CURP") && cleanCurp )
						function.getImportParameterList().getStructure("I_BPDATA").setValue( inputParam.getKey(), "" );
					else
						function.getImportParameterList().getStructure("I_BPDATA").setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().getStructure("I_BPDATA").setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().getStructure("I_BPDATA").setValue( inputParam.getKey(), inputParam.getValue() );	
				}
			}
			
			log.info( "input data :: " +  function.getImportParameterList().getStructure("I_BPDATA").toString() );
			
			function.execute(destination);
			
			JCoParameterList data = function.getExportParameterList();
			
			log.info( "" +  data.toString() );
			
			ZCRMCSB_P004_ADDUPDBP_OutputData tableData = new ZCRMCSB_P004_ADDUPDBP_OutputData();
				
			tableData.setBpId( data.getString("E_BPID") );
			tableData.setClientId( data.getString("E_CLIENTID") );
			errorMessage = data.getString("E_MESSAGE");
			
			if( "X".equalsIgnoreCase( data.getString("E_OK") ) ){
				tableData.setSuccessFlag( Boolean.TRUE );	
			}
			
			tableData.setErrorMessage(errorMessage);
	
			returnList.add( tableData );				
				
	
		} catch (AbapException e) {
			log.error("Executing function  ZCRMCSB_P004_ADDUPDBP ***** ERROR MESSAGE: [ " + errorMessage +" ]", e);
			String s = ExceptionUtils.renderStackTrace( e, 200);
			if( s.contains("ZCURP") ){
				this.executeRemoteFunction(destination, inputParamtersList, true);
			}
			else
				throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
