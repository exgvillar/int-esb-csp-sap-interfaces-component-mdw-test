package com.consubanco.sap.interfaces.recommender;

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

public class ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl.class );
	
	public ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E002_ENROLREC_BY_STS" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E002_ENROLREC_BY_STS not found in SAP.");
			
			function = ft.getFunction();
	
			JCoTable inputTable = function.getImportParameterList().getTable("IT_ESTATUS");
			
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				
				inputTable.appendRow();
				inputTable.setValue( inputParam.getKey(), inputParam.getValue() );
			}
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_E002_ENROLREC_BY_STS_OutputData data = null;			
			JCoTable exportTable = function.getExportParameterList().getTable("ET_RESULT");		
			
			log.info( exportTable.toString() );
			
			for (int i = 0; i < exportTable.getNumRows(); i++, exportTable.nextRow() ) {
				data = new ZCRMRECO_E002_ENROLREC_BY_STS_OutputData();
				
				data.setIdTareaEnrol( exportTable.getString("O_ID_TAREA_ENROL") );
				data.setIdOrdenReco( exportTable.getString("O_ID_ORDEN_RECO") );
				data.setBpReco( exportTable.getString("O_BP_RECO") );
				data.setCelular( exportTable.getString("O_CELULAR") );
				data.setCodVerificador( exportTable.getString("O_COD_VERIFICADOR") );
				data.setProcessBpmId( exportTable.getString( "O_PROCESS_ID" ) );
						
				returnList.add( data );
			}		
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E002_ENROLREC_BY_STS :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
