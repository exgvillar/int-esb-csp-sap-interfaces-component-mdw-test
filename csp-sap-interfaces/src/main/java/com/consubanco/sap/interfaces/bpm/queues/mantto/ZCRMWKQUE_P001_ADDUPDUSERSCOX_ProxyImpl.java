package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_WORKINGHOURS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl.class );
	
	
	public ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData data ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P001_ADDUPDUSERSCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P001_ADDUPDUSERSCOX not found in SAP.");
			
			function = ft.getFunction();
			
			function.getImportParameterList().getStructure("I_DATA").setValue("ZPARTNER", data.getBusinessPartner() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZUSUARIO", data.getUserName() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZNOMBRE1", data.getName1() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZNOMBRE2", data.getName2() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZAPE_PAT", data.getLastName1() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZAPE_MAT", data.getLastName2() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZCVE_AREA", data.getAreaKey() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZDESC_CVE_AREA", data.getAreaDesc() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZCVE_NIV_EXP", data.getExperienceLevelKey() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZDESC_NIV_EXP", data.getExperienceLevelDesc() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZTIEMPO_BREAK", data.getBreakTime() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZCVE_ESTATUS", data.getStatusKey() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZDESC_ESTATUS", data.getStatusDesc() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZCVE_UBIC", data.getLocationKey() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZDESC_UBIC", data.getLocationDesc() );
			function.getImportParameterList().getStructure("I_DATA").setValue("ZUSR_ULT_MOD", data.getUserLastUpdate() );
			
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getStructure("I_DATA").getTable("ZDAYS");
			if( data.getWorkingHoursList() != null ){
				Iterator<ZM_WORKINGHOURS_Model> iterRecord = data.getWorkingHoursList().iterator();
				while( iterRecord.hasNext() ){
					tableInput.appendRow();
					ZM_WORKINGHOURS_Model  record = iterRecord.next();
					tableInput.setValue("ZDIA_SEM", record.getDayOfWeek() );
					tableInput.setValue("ZHORA_ENTRADA", record.getCheckIn() );
					tableInput.setValue("ZHORA_SALIDA", record.getCheckOut() );
				}
			}
			function.getImportParameterList().setValue("I_MODO", data.getRfcCrmMode() );
			
			log.info("RFC CRM Input :: " + function.getImportParameterList().getStructure("I_DATA").toString() +" :: "+ function.getImportParameterList().getStructure("I_DATA").getTable("ZDAYS").toString() );
			function.execute(destination);
			
			data.setResult( function.getExportParameterList().getString("E_IND").equals("X") ? true : false );
			data.setMessages( function.getExportParameterList().getString("E_MESSAGE") );

			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P001_ADDUPDUSERSCOX :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
