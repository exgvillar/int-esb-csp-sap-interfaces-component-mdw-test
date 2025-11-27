package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_APPLICATION_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl.class );
	
	public ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E008_NOTIFICATIONS" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E008_NOTIFICATIONS not found in SAP.");
			
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
			
//			log.info( function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E008_NOTIFICATIONS_OutputData tableData = new ZCRMWKQUE_E008_NOTIFICATIONS_OutputData();
				tableData.setRole( data.getString("ZROL") );
				tableData.setAttentionTimeMinsMin( data.getInt("ZTIME_ATEN_MIN") );
				tableData.setAttentionTimeMinsMax( data.getInt("ZTIME_ATEN_MAX") );
				tableData.setEmail( data.getString("ZCORREO") );
				tableData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
				JCoTable dataApp = data.getTable("ZSOLICITUDES");
				log.info( "" +  dataApp.toString() );
				tableData.setApplications( new ArrayList<ZM_APPLICATION_Model>() );
				for (int j = 0; j < dataApp.getNumRows(); j++, dataApp.nextRow() ) {
					ZM_APPLICATION_Model dataApplication = new ZM_APPLICATION_Model();
					dataApplication.setFolioApplication( dataApp.getString("ZSOLICITUD") );
					dataApplication.setCreateDate( dataApp.getDate("ZFECHA_CREADA") );
					dataApplication.setLastUpdateDate( dataApp.getDate("ZFECHA_ULT_ACT") );
					dataApplication.setExecutorRole( dataApp.getString("ZROL") );
					dataApplication.setWaitingTimeMins( dataApp.getInt("ZTIEMPO_TRANSC") );
					dataApplication.setName1( dataApp.getString("ZNOMBRE_CTE") );
					dataApplication.setName2( dataApp.getString("ZNOMBRE_CTE2") );
					dataApplication.setLastName1( dataApp.getString("ZAPE_PAT_CTE") );
					dataApplication.setLastName2( dataApp.getString("ZAPE_MAT_CTE") );
					dataApplication.setConvenioKey( dataApp.getString("ZCVE_CONVENIO") );
					dataApplication.setConvenioDesc( dataApp.getString("ZDESC_CONVENIO") );
					dataApplication.setProductKey( dataApp.getString("ZCVE_PRODUCTO") );
					dataApplication.setProductDesc( dataApp.getString("ZNOM_PRODUCTO") );
					dataApplication.setRequestAmount( dataApp.getDouble("ZMONTO_SOL") );
					dataApplication.setFrecuency( dataApp.getString("ZFRECUENCIA") );
					dataApplication.setPlazo( dataApp.getInt("ZNO_PLAZOS") );
					dataApplication.setAssigned( dataApp.getString("ZSOL_ASIGNADA").equals("X") ? true : false );
					dataApplication.setRequestStatusKey( dataApp.getString("ZCLV_ESTATUS") );
					dataApplication.setRequestStatusDesc( dataApp.getString("ZDESC_ESTATUS") );
					dataApplication.setUserAssigned( dataApp.getString("ZUSER_ASIG") );
					
					tableData.getApplications().add( dataApplication );
				}
				
				returnList.add( tableData );	
			}	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E008_NOTIFICATIONS :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
