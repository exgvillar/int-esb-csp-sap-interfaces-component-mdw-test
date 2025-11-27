package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CATEGORIAS_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl.class );
	
	public ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E009_AVAILABLE_USERS" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E009_AVAILABLE_USERS not found in SAP.");
			
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
			
//			log.info("RFC Input :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData tableData = new ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData();

				tableData.setBusinessPartner( data.getString("ZPARTNER") );
				tableData.setUserName( data.getString("ZUSUARIO") );
				tableData.setName1( data.getString("ZNOMBRE1") );
				tableData.setName2( data.getString("ZNOMBRE2") );
				tableData.setLastName1( data.getString("ZAPE_PAT") );
				tableData.setLastName2( data.getString("ZAPE_MAT") );
				tableData.setAreaKey( data.getString("ZCVE_AREA") );
				tableData.setAreaDesc( data.getString("ZDESC_CVE_AREA") );
				tableData.setLocationKey( data.getString("ZCVE_UBIC") );
				tableData.setLocationDesc( data.getString("ZDESC_UBIC") );
				tableData.setExperienceLevelKey( data.getString("ZCVE_NIV_EXP") );
				tableData.setExperienceLevelDesc( data.getString("ZDESC_NIV_EXP") );
				tableData.setStatusKey( data.getString("ZCVE_ESTATUS") );
				tableData.setStatusDesc( data.getString("ZDESC_ESTATUS") );
				tableData.setLastAssignationDate( data.getDate("ZFECHA_ULT_ASIG") );
				tableData.setLastAssignationHour( data.getString("ZHORA_ULT_ASIG") );
				tableData.setNumberAssignedRequests( data.getInt("ZNO_SOL_ASIG") );
				tableData.setWaitingTimeMins( data.getLong("ZTIEMPO_ESPERA") );
				
				JCoTable dataConvenio = data.getTable("ZT_CONV_ESP");
				log.info( "" +  dataConvenio.toString() );
				tableData.setSpecializationConvenios( new ArrayList<ZM_CONVENIOS_Model>() );
				for (int j = 0; j < dataConvenio.getNumRows(); j++, dataConvenio.nextRow() ) {
					ZM_CONVENIOS_Model convenio = new ZM_CONVENIOS_Model();
					convenio.setConvenioId( dataConvenio.getString("ZCLAVE") );
					convenio.setConvenioDesc( dataConvenio.getString("ZDESCRIPCION") );
					convenio.setBrmsId( dataConvenio.getString("ZCLV_CONV_BRMS") );
					tableData.getSpecializationConvenios().add( convenio );
				}
				
				JCoTable dataCat = data.getTable("ZT_CATPRD_ESP");
				log.info( "" +  dataCat.toString() );
				tableData.setSpecializationProductCategories( new ArrayList<ZM_CATEGORIAS_Model>() );
				for (int k = 0; k < dataCat.getNumRows(); k++, dataCat.nextRow() ) {
					ZM_CATEGORIAS_Model category = new ZM_CATEGORIAS_Model();
					category.setCategoryId( dataCat.getString("ZCLAVE") );
					category.setCategoryDesc( dataCat.getString("ZDESCRIPCION") );
					tableData.getSpecializationProductCategories().add( category );
				}
				
				JCoTable dataSourceChannel = data.getTable("ZT_CANAL_ORIGEN");
				log.info( "" +  dataSourceChannel.toString() );
				tableData.setSourceChannels( new ArrayList<String>() );
				for (int m = 0; m < dataSourceChannel.getNumRows(); m++, dataSourceChannel.nextRow() ) {
					tableData.getSourceChannels().add( dataSourceChannel.getString("ZCANAL_ORIGEN") );
				}
				
				returnList.add( tableData );					
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E009_AVAILABLE_USERS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
