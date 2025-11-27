/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

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
 * 
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMRECO_E001_SEARCHREC_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E001_SEARCHREC_ProxyImpl.class );
	
	/* (non-Javadoc)
	 * @see com.consupago.sap.interfaces.proxy.IStandardSAPProxy#executeRemoteFunction(com.sap.conn.jco.JCoDestination, java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E001_SEARCHREC" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E001_SEARCHREC not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_E001_SEARCHREC_OutputData data = null;
			
			JCoTable dataTable = function.getExportParameterList().getTable("ET_RESULT");
			
			log.info( "" +  dataTable.toString() );
			
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {
				data = new ZCRMRECO_E001_SEARCHREC_OutputData();
				
				data.setBp( dataTable.getString("O_BP") );
				data.setClientId( dataTable.getString("O_CLIENT") );
				data.setRfc( dataTable.getString("O_RFC") );
				data.setCurp( dataTable.getString("O_CURP") );
				data.setName1( dataTable.getString("O_NAME1") );
				data.setName2( dataTable.getString("O_NAME2") );
				data.setApePat( dataTable.getString("O_APEPAT") );
				data.setApeMat( dataTable.getString("O_APEMAT") );
				data.setEmail("");
				data.setCompany( dataTable.getString("O_COMPANY") );
				data.setBlocked( "x".equalsIgnoreCase(StringUtils.trimToEmpty( dataTable.getString("O_REC_BLOQUEADO") )) );
				data.setLocked( "x".equalsIgnoreCase(StringUtils.trimToEmpty( dataTable.getString("O_IS_LOCKED") )) );
				data.setUifList( "x".equalsIgnoreCase(StringUtils.trimToEmpty( dataTable.getString("O_IS_UIF_LIST") )) );
				
				returnList.add( data );
			}	
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E001_SEARCHREC :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
		
	}

}
