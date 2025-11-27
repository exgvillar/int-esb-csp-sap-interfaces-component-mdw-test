package com.consubanco.sap.interfaces.debitsLetter;

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

/**
 * @author hsanchez
 *
 */
public class ZCRMORI_E049_GETACCOUNTSBYAPP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E049_GETACCOUNTSBYAPP_ProxyImpl.class );
	
	public ZCRMORI_E049_GETACCOUNTSBYAPP_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E049_GETACCOUNTSBYAPP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E049_GETACCOUNTSBYAPP not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);			
			log.info("Function.Export: " + function.getExportParameterList().toString() );			
			
			JCoTable creditsTbl = function.getExportParameterList().getTable("E_CREDITOS");
			
			log.info( "" +  creditsTbl.toString() );
			for (int i = 0; i < creditsTbl.getNumRows(); i++, creditsTbl.nextRow() ) {
				ZCRMORI_E049_GETACCOUNTSBYAPP_OutputData tableData = new ZCRMORI_E049_GETACCOUNTSBYAPP_OutputData();
				
				tableData.setAccountId( creditsTbl.getString("ACCOUNTID") );
				tableData.setCnca( creditsTbl.getString("CNCA").equals("X") ? true : false );
				tableData.setIntercompany( creditsTbl.getString("INTERCOMPANIA").equals("X") ? true : false );
				
				returnList.add( tableData );
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E049_GETACCOUNTSBYAPP :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
