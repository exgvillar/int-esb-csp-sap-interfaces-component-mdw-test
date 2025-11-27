package com.consubanco.sap.interfaces.sic.requests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.sic.ZUT_PERSON_OutputData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZFM_SIC_ORIG_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZFM_SIC_ORIG_ProxyImpl.class );
	
	public ZFM_SIC_ORIG_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZFM_SIC_ORIG" );
			if(ft == null)
				throw new RuntimeException("ZFM_SIC_ORIG not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("TL_ORG");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZFM_SIC_ORIG_OutputData tableData = new ZFM_SIC_ORIG_OutputData();
				ZUT_PERSON_OutputData client = new ZUT_PERSON_OutputData();
				
				tableData.setRequestDate( data.getDate("REQUEST_DATE") );
				tableData.setRequestAmount( data.getDouble("REQUEST_AMOUNT") );
				tableData.setDisburmentAmount( data.getDouble("DISBURSEMENT_AMOUNT") );
				tableData.setPaymentNumber( data.getInt("PAYMENTS_NUMBER") );
				tableData.setNewRequest( data.getString("IS_NEW").equals("X") ? true : false );
				tableData.setCnca( data.getString("IS_CNCA").equals("X") ? true : false );
				tableData.setSecondDisp( data.getString("IS_SECOND_DISPOSITION").equals("X") ? true : false ) ;
				tableData.setNumberDisposition( data.getInt("NUMBER_DISPOSITION") );
				tableData.setLiqCompetitor( data.getString("IS_LIQ_COMPETITOR").equals("X") ? true : false ) ;
				tableData.setPromotionAmount( data.getDouble("PROMOTION_AMOUNT") );
				tableData.setNotarial( data.getDouble("NOTARIAL_SPENDING") );
				tableData.setCommissionOpening( data.getDouble("COMMISSION_OPENING") );
				tableData.setNetCredit( data.getDouble("NET_CREDIT") );
				tableData.setPayAmount( data.getDouble("PAYMENT_AMOUNT") );
				tableData.setFrecuency( data.getString("FRECUENCY") );
				tableData.setFrecuencyInstallation( data.getString("DE_FREPAG") );
				
				client.setBusinessPartnerId( data.getString("BPID") );
				client.setRfc( data.getString("RFC") );
				client.setName1( data.getString("FIRST_NAME") );
				client.setName2( data.getString("MIDDLE_NAME") );
				client.setLastName1( data.getString("PATERNAL_NAME") );
				client.setLastName2( data.getString("MATERNAL_NAME") );
				client.setNss( data.getString("NSS") );
				client.setCurp( data.getString("CURP") );
				tableData.setClient(client);
				
				JCoTable dataLiqs = data.getTable("LIQUIDATIONS");
				log.info( "" +  dataLiqs.toString() );
				ArrayList<ZUT_LIQS_OutputData> liqList = new ArrayList<ZUT_LIQS_OutputData>();
				for (int j = 0; j < dataLiqs.getNumRows(); j++, dataLiqs.nextRow() ) {
					ZUT_LIQS_OutputData liquidacion = new ZUT_LIQS_OutputData();
					liquidacion.setType( dataLiqs.getString("TYPE") );
					liquidacion.setName( dataLiqs.getString("NAME") );
					liquidacion.setAmount( dataLiqs.getDouble("AMOUNT") );
					if( dataLiqs.getString("TYPE").equals("COMPETIDOR") )
						liquidacion.setAccountId("0");
					else
						liquidacion.setAccountId(  dataLiqs.getString("ACCOUNT_ID") );
					
					liqList.add( liquidacion );
				}
				tableData.setLiquidations( liqList );
				
				returnList.add( tableData );
						
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZFM_SIC_ORIG" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
