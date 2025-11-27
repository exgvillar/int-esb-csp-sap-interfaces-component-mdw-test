package com.consubanco.sap.interfaces.bpm.queues.recaptures;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_INC_RECAP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl{

	private static Log log = LogFactory.getLog( ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl.class );
	
	
	public ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData inputParamters ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRWKQUE_P001_UPD_NUM_INCI" );
			if(ft == null)
				throw new RuntimeException("ZCRMRWKQUE_P001_UPD_NUM_INCI not found in SAP.");
			
			function = ft.getFunction();
			
			//incidences
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("IT_INCIDENCIAS");
			Iterator<ZM_INC_RECAP_Model> iterRecord = inputParamters.getIncidences().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ZM_INC_RECAP_Model recordData = (ZM_INC_RECAP_Model)iterRecord.next();
				tableInput.setValue( "NUM_SOLICITUD", recordData.getFolioApplication() );
				tableInput.setValue( "NUM_INCIDENCIA", recordData.getIncidenceNumber() );
				tableInput.setValue( "CAUSA", recordData.getCause() );
				tableInput.setValue( "MOTIVO", recordData.getMotive() );
				tableInput.setValue( "DESC_GENERAL", recordData.getGeneralDescription() );
				tableInput.setValue( "RESUELTO", recordData.isResolve() ? "X" : "" );
			}
			
			function.execute(destination);

			ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData resultData = new ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData();
			resultData.setSuccess( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			resultData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );

			returnList.add( resultData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRWKQUE_P001_UPD_NUM_INCI :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
