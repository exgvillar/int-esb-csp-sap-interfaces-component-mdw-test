package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl.class );
	
	public ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E006_GET_TIMEATNCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E006_GET_TIMEATNCOX not found in SAP.");
			
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
				ZCRMWKQUE_E006_GET_TIMEATNCOX_OutputData tableData = new ZCRMWKQUE_E006_GET_TIMEATNCOX_OutputData();
				
				tableData.setBusinessPartner( data.getString("ZPARTNER") );
				tableData.setUser( data.getString("ZUSUARIO") );
				tableData.setAreaId( data.getString("ZCVE_AREA") );
				tableData.setAreaDesc( data.getString("ZDESC_CVE_AREA") );
				tableData.setExperienceLevelId( data.getString("ZCVE_NIV_EXP") );
				tableData.setExperienceLevelDesc( data.getString("ZDESC_NIV_EXP") );
				tableData.setProductCategoryId( data.getString("ZCLV_CAT_PRD") );
				tableData.setProductCategoryDesc( data.getString("ZDESC_CLV_CAT_PRD") );
				tableData.setAttentionTime( data.getInt("ZTIEMPO_ATENCION") );
				tableData.setUserLastUpdate( data.getString("ZUSER_ULT_MODIF") );
				tableData.setCreateDate( data.getDate("ZFECHA_CREA") );
				tableData.setLastUpdateDate( data.getDate("ZFECHA_ULT_ACT") );
				tableData.setSourceChannelId( data.getString("ZCANAL_ORIGEN") );
				
				JCoTable convTable = data.getTable("ZCONVENIOS");
				log.info( "" +  convTable.toString() );
				ArrayList<ZM_CONVENIOS_Model> conveniosList = new ArrayList<ZM_CONVENIOS_Model>();
				for (int j = 0; j < convTable.getNumRows(); j++, convTable.nextRow() ) {
					ZM_CONVENIOS_Model convenio = new ZM_CONVENIOS_Model();
					convenio.setConvenioId( convTable.getString("ZCLV_CONVENIO") );
					convenio.setConvenioDesc( convTable.getString("ZDESC_CLV_CONVENIO") );
					conveniosList.add( convenio );
				}
				
				tableData.setConveniosList(conveniosList);
				
				returnList.add( tableData );	
			}	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E006_GET_TIMEATNCOX" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
