package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_COMPETITOR_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E015_DATA_SOL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E015_DATA_SOL_ProxyImpl.class );
	
	public ZCRMWKQUE_E015_DATA_SOL_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E015_DATA_SOL" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E015_DATA_SOL not found in SAP.");
			
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
			
			log.info( function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoStructure structureData = function.getExportParameterList().getStructure("E_DATA");

			ZCRMWKQUE_E015_DATA_SOL_OutputData data = new ZCRMWKQUE_E015_DATA_SOL_OutputData();
			data.setFolioApplication( structureData.getString("ZNUMERO_SOLICITUD") );
			data.setConvenioId( structureData.getString("ZID_CONVENIO") );
			data.setConvenioDesc( structureData.getString("ZDESCRIPCION_CONVENIO") );
			data.setConvenioBrmsId( structureData.getString("ZBRMS") );
			data.setConvenioRate( structureData.getInt("ZPRIORIDAD_EXP") );
			data.setProductId( structureData.getString("ZID_PRODUCTO") );
			data.setProductDesc( structureData.getString("ZDESCRIPCION_PROD") );
			data.setProductRate( structureData.getInt("ZCALIFICACION") );
			data.setProductCategoryId( structureData.getString("ZCATPROD") );
			data.setProductCategoryDesc( structureData.getString("ZDESCRIPCION_CATPROD") );
			data.setProductCategoryRate( structureData.getInt("ZCALIF_CAT") );
			data.setDependenceId( structureData.getString("ZID_DEPENDENCIA") );
			data.setBranchId( structureData.getString("ZID_SUCURSAL") );
			data.setRequestAmount( structureData.getDouble("ZMONTO_SOLICITUD") );
			data.setPromoterBp( structureData.getString("ZBP_PROMOTOR") );
			data.setPromoterName1( structureData.getString("ZNOMBRE_PROMOTOR") );
			data.setSourceChannelId( structureData.getString("ZCANAL_ORIG") );
			data.setSourceChannelDesc( structureData.getString("ZDESC_CANAL") );
			data.setTaskCRMId( structureData.getString("ZTASK_CRM") ); 
			data.setTaskCRMDesc( structureData.getString("ZDESCRIPTION_TASK_CRM") );

			JCoTable dataTableCompetitors = structureData.getTable("ZCOMPETIDORES");
			
			log.info( "" +  dataTableCompetitors.toString() );
			ArrayList<ZM_COMPETITOR_Model> competidoresList = new ArrayList<ZM_COMPETITOR_Model>();
			for (int i = 0; i < dataTableCompetitors.getNumRows(); i++, dataTableCompetitors.nextRow() ) {
				ZM_COMPETITOR_Model dataCompetidor = new ZM_COMPETITOR_Model();
				
				dataCompetidor.setServiceOrderId( dataTableCompetitors.getString("ID_ORDSERV") );
				dataCompetidor.setServiceOrderType( dataTableCompetitors.getString("TIPO_ORD_SERV") );
				dataCompetidor.setStatusSOId( dataTableCompetitors.getString("STATUS_OS") );
				dataCompetidor.setStatusSODesc( dataTableCompetitors.getString("DESCSTAT_OS") );
				dataCompetidor.setCompetitorBp( dataTableCompetitors.getString("ID_COMPETIDOR") );
				dataCompetidor.setCompetitorName( dataTableCompetitors.getString("NOMBRE") );
				dataCompetidor.setEmissionDate( dataTableCompetitors.getDate("FECHA_EMISION") );
				dataCompetidor.setExpirationDate( dataTableCompetitors.getDate("FECHA_VENCIMIENTO") );
				dataCompetidor.setLastDiscountDate( dataTableCompetitors.getDate("FECHA_ULTDESCTO") );
				dataCompetidor.setAmount( dataTableCompetitors.getDouble("MONTO") );
				dataCompetidor.setPaymentMethodId( dataTableCompetitors.getString("ID_METODO_PAGO") );
				dataCompetidor.setPaymentMethodDesc( dataTableCompetitors.getString("DES_METODO_PAGO") );
				dataCompetidor.setApprovedDate( dataTableCompetitors.getDate("FECHA_APROBAC") );
				dataCompetidor.setDiscountAmount( dataTableCompetitors.getDouble("MONTO_DESCTO") );
				
				JCoStructure strTask = dataTableCompetitors.getStructure("TASK_CRM");
				dataCompetidor.setTaskCrmId( strTask.getString("STATUS_OP") );
				dataCompetidor.setTaskCrmDesc( strTask.getString("DESCSTAT_OP") );
				competidoresList.add( dataCompetidor );
				
			}
			data.setCompetitorsList(competidoresList);
			
			JCoStructure cncaStructure = structureData.getStructure("ZCNCA");
			data.setSecondDisposition( cncaStructure.getString("ZSEG_DISP").equals("X") ? true : false );
			data.setLcom( cncaStructure.getString("ZLCOM").equals("X") ? true : false );
			data.setNewCredit( cncaStructure.getString("ZNVO_CRED").equals("X") ? true : false );
			data.setIntercompany( cncaStructure.getString("ZINTERCOMP").equals("X") ? true : false );
			data.setCnca( cncaStructure.getString("ZCNCA").equals("X") ? true : false );
			
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E015_DATA_SOL :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
