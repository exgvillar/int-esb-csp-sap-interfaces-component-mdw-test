package com.consubanco.sap.interfaces.common.formatF02;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_QEQ_Model;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl.class );
	
	public ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl() {
		super();		
	}

	public boolean executeRemoteFunction( JCoDestination destination, String customerId, String requestId, ZTL_PEPS_Model pepInputParams ) throws Exception {
		
		boolean result = false;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P015_ADDUPD_QEQDATA" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P015_ADDUPD_QEQDATA not found in SAP.");
			
			function = ft.getFunction();
	
			if( pepInputParams != null ) {
				function.getImportParameterList().setValue("I_BP", customerId );
				function.getImportParameterList().setValue("I_NUMDOC", requestId );
				
				
				// Iterate qeq table
				JCoTable qeqTable = function.getImportParameterList().getTable("IT_QEQ");
				Iterator<ZTL_QEQ_Model> itQEQ = pepInputParams.getQeq().iterator();
				while( itQEQ.hasNext() ) {
					ZTL_QEQ_Model _qeqData = (ZTL_QEQ_Model) itQEQ.next();
					qeqTable.appendRow();
					qeqTable.setValue("ID", _qeqData.getId() );
					qeqTable.setValue("QEQ_ID", _qeqData.getQeqId() );
					qeqTable.setValue("NAMESS", _qeqData.getNombres() );
					qeqTable.setValue("LASTNAME", _qeqData.getApellidoPaterno() );
					qeqTable.setValue("SURNAME", _qeqData.getApellidoMaterno() );
					qeqTable.setValue("CURP", _qeqData.getCurp() );
					qeqTable.setValue("RFC", _qeqData.getRfc() );
					qeqTable.setValue("BIRTHDAY", _qeqData.getFechaNacimiento() );
					qeqTable.setValue("LISTQEQ", _qeqData.getListaQEQ() );
					qeqTable.setValue("STATUS", _qeqData.getEstatusQEQ() );
					qeqTable.setValue("DEPENDENCY", _qeqData.getDependencia() );
					qeqTable.setValue("POSITIONN", _qeqData.getPuesto() );
					qeqTable.setValue("ID_DISPO", _qeqData.getIdDispo() );
					qeqTable.setValue("CURP_OK", _qeqData.getCurpOk() );
					qeqTable.setValue("ID_REL", _qeqData.getIdRel() );
					qeqTable.setValue("RELATIONSHIP", _qeqData.getRelationship() );
					qeqTable.setValue("SOCIALREASON", _qeqData.getRazonSocial() );
					qeqTable.setValue("RFC_MORAL", _qeqData.getRfcMoral() );
					qeqTable.setValue("ISSSTE", _qeqData.getISSSTE() );
					qeqTable.setValue("IMSS", _qeqData.getIMSS() );
					qeqTable.setValue("INCOME", _qeqData.getIncome() );
					
				}
								
			}
			
			
			function.execute(destination);
			
			result = true;
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P015_ADDUPD_QEQDATA" , e);
			throw e;
		} finally {
			
		}
		
		return result;
	}
	
}
