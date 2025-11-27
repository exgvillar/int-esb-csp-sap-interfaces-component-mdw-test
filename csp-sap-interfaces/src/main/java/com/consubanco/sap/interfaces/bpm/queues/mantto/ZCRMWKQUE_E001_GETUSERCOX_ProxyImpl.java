package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_WORKINGHOURS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl.class );
	
	public ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E001_GETUSERCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E001_GETUSERCOX not found in SAP.");
			
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
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E001_GETUSERCOX_OutputData tableData = new ZCRMWKQUE_E001_GETUSERCOX_OutputData();

				tableData.setBusinessPartner( data.getString("ZPARTNER") );
				tableData.setUserName( data.getString("ZUSUARIO") );
				tableData.setName1( data.getString("ZNOMBRE1") );
				tableData.setName2( data.getString("ZNOMBRE2") );
				tableData.setLastName1( data.getString("ZAPE_PAT") );
				tableData.setLastName2( data.getString("ZAPE_MAT") );
				tableData.setAreaKey( data.getString("ZCVE_AREA") );
				tableData.setAreaDesc( data.getString("ZDESC_CVE_AREA") );
				tableData.setExperienceLevelKey( data.getString("ZCVE_NIV_EXP") );
				tableData.setExperienceLevelDesc( data.getString("ZDESC_NIV_EXP") );
				tableData.setBreakTime( data.getInt("ZTIEMPO_BREAK") );
				tableData.setStatusKey( data.getString("ZCVE_ESTATUS") );
				tableData.setStatusDesc( data.getString("ZDESC_ESTATUS") );
				tableData.setLocationKey( data.getString("ZCVE_UBIC") );
				tableData.setLocationDesc( data.getString("ZDESC_UBIC") );
				tableData.setUserLastUpdate( data.getString("ZUSR_ULT_MOD") );
				tableData.setCreateDate( data.getDate("ZFECHA_CREA") );
				tableData.setLastUpdate( data.getDate("ZFECHA_ULT_MOD") );
				
				JCoTable workingData = data.getTable("LT_TIMES");
				log.info( "" +  workingData.toString() );
				ArrayList<ZM_WORKINGHOURS_Model> workingHoursList = new ArrayList<ZM_WORKINGHOURS_Model>();
				for (int j = 0; j < workingData.getNumRows(); j++, workingData.nextRow() ) {
					ZM_WORKINGHOURS_Model tableWorkingData = new ZM_WORKINGHOURS_Model();
					tableWorkingData.setDayOfWeek( workingData.getString("ZDIA_SEM") );
					String checkin = StringUtils.trimToEmpty( workingData.getString("ZHORA_ENTRADA" )); 
					String checkout = StringUtils.trimToEmpty( workingData.getString("ZHORA_SALIDA" )); 
					tableWorkingData.setCheckIn( checkin.length() > 5 ? checkin.substring(0,5) : checkin );
					tableWorkingData.setCheckOut( checkout.length() > 5 ? checkout.substring(0,5) : checkout );
					
					workingHoursList.add( tableWorkingData );
				}
				tableData.setWorkingHoursList( workingHoursList );
				
				returnList.add( tableData );	
				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E001_GETUSERCOX" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
