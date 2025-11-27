package com.consubanco.sap.interfaces.bpm.queues.mantto;

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


public class ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl{

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl.class );
	
	
	public ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData inputParamters ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P004_SAVE_TIMEATNCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P004_SAVE_TIMEATNCOX not found in SAP.");
			
			function = ft.getFunction();
			
			function.getImportParameterList().setValue( "I_PARTNER", inputParamters.getBusinessPartner() );
			function.getImportParameterList().setValue( "I_CAT_PRODUCTO", inputParamters.getProductCategoryId() );
			function.getImportParameterList().setValue( "I_TIEMPO_ATENCION", inputParamters.getAttentionTime() > 0 ? ""+inputParamters.getAttentionTime() : "" );
			function.getImportParameterList().setValue( "I_USUARIO", inputParamters.getUser() );
			function.getImportParameterList().setValue( "I_CANAL_ORIGEN", inputParamters.getSourceChannelId() );
			function.getImportParameterList().setValue( "I_DELETE", inputParamters.isDelete() ? "X" : "" );
			
			//convenios
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_CONVENIO");
			Iterator<String> iterRecord = inputParamters.getConvenioIdList().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				String convenioId = iterRecord.next();
				tableInput.setValue( "ID_CONVENIO", convenioId );
			}
			
			function.execute(destination);
			
			ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData resultData = new ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData();
			resultData.setResult( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			resultData.setMessage( function.getExportParameterList().getString("E_MENSAJE") );

			returnList.add( resultData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P004_SAVE_TIMEATNCOX :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
