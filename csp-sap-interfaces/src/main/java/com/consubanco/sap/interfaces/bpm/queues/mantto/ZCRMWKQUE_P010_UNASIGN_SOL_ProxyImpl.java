/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZWRKQUEUE_UNASIGN_SOLS_Model;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl{

	private static Log log = LogFactory.getLog(ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl.class);

	public ArrayList<IProxyOutputData> executeRemoteFunction(
			JCoDestination destination,
			ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model> dataList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P010_UNASIGN_SOL" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P010_UNASIGN_SOL not found in SAP.");
			
			function = ft.getFunction();
	
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_DATA");
			if( dataList != null ){
				Iterator<ZWRKQUEUE_UNASIGN_SOLS_Model> iterRecord = dataList.iterator();
				while( iterRecord.hasNext() ){
					tableInput.appendRow();
					ZWRKQUEUE_UNASIGN_SOLS_Model  record = iterRecord.next();
					
					tableInput.setValue("ZBP", Formatter.fillStringWithZerosOnLeft( record.getBpId(), 10 ) );
					tableInput.setValue("ZNSOL", record.getNumSol());
					
				}
			}
			
			log.info("RFC CRM Input :: " + function.getImportParameterList().getTable("I_DATA").toString() );
			
			function.execute(destination);
			
			ZCRMWKQUE_P010_UNASIGN_SOL_OutputData resultData = new ZCRMWKQUE_P010_UNASIGN_SOL_OutputData();
	
			resultData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );

			returnList.add( resultData );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P010_UNASIGN_SOL" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

}
