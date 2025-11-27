package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.lcom.dispersion.ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData.CompetidorInfo;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_P002_LCOM_SOLICITUDES";
	
	public ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		ArrayList<ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData> returnList = new ArrayList<ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUDES");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			
			while( iterRecord.hasNext() ) {
				tableInput.appendRow();
				ArrayList<ProxyInputParameter> recordParam = (ArrayList<ProxyInputParameter>) iterRecord.next();
				Iterator<ProxyInputParameter> iterRecorParam = recordParam.iterator();
				while (iterRecorParam.hasNext()) {
					ProxyInputParameter inputParam = (ProxyInputParameter) iterRecorParam.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
						
					} else {
						if( inputParam.getType().equals("java.util.Date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}
				}
			}
			log.info("input : " +  tableInput.toString() );
			function.execute(destination);
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			log.info(data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData output = new ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData();

				output.setZnumeroSolicitud(data.getString("ZNUMERO_SOLICITUD"));
				output.setZidEmpresa(data.getString("ZID_EMPRESA"));
				output.setZbpEmpresa(data.getString("ZBP_EMPRESA"));
				output.setZsigEmpresa(data.getString("ZSIG_EMPRESA"));
				output.setZdescripcionEmpresa(data.getString("ZDESCRIPCION_EMPRESA") );
				output.setZidDistribuidor(data.getString("ZID_DISTRIBUIDOR") );
				output.setZdescDistribuidor(data.getString("ZDESC_DISTRIBUIDOR") );
				output.setZsigDistribuidor(data.getString("ZSIG_DISTIB"));
				output.setZidSucursal(data.getString("ZID_SUCURSAL") );
				output.setZdescSucursal( data.getString("ZDESC_SUCURSAL") );
				output.setZsigSucursal( data.getString("ZSIG_SUCURSAL"));
				output.setZclabe(data.getString("ZCLABE") );
				output.setZtipoDeCuenta(data.getString("ZTIPO_DE_CUENTA") );
				output.setZclaveBanco(data.getString("ZCLAVE_BANCO") );
				output.setZdescripcionBanco(data.getString("ZDESCRIPCION_BANCO") );
				output.setZviaDePago(data.getString("ZVIA_DE_PAGO") );
				output.setZdescripcionViaPago(data.getString("ZDESCRIPCION_VIA_PAGO") );
				output.setZfechaSolicitud(data.getDate("ZFECHA_SOLICITUD") );
				output.setZbpCliente(data.getString("ZBP_CLIENTE") );
				output.setZnombreClie(data.getString("ZNOMBRE_CLIE") );
				output.setZnombreClie2(data.getString("ZNOMBRE_CLIE2") );
				output.setZapePaternoClie(data.getString("ZAPE_PATERNO_CLIE") );
				output.setZapeMaternoClie(data.getString("ZAPE_MATERNO_CLIE") );
				output.setZrfcCliente(data.getString("ZRFC_CLIENTE") );
				output.setZmontoSolicitud(data.getBigDecimal("ZMONTO_SOLICITUD") );
				output.setZmontoDisper(data.getBigDecimal("ZMONTO_DISPER") );
				output.setZmontoTotal(data.getBigDecimal("ZMONTO_TOTAL") );
				output.setZmontoCat(data.getBigDecimal("ZMONTO_CAT") );
				output.setZmontoDisperCompet(data.getBigDecimal("ZMONTO_DISPER_COMPET") );
				output.setZmontoLiqinter(data.getBigDecimal("ZMONTO_LIQINTER") );
				output.setArrCompetidoresInfo(new ArrayList<CompetidorInfo>());
				
				
				//recupero subtabla de competidores.
				JCoTable tzCtaDispersora =  data.getTable("ZCTA_DISPERSORA");
				ArrayList<String> arrDispersora = new ArrayList<String>();
//				for (int iDispersora = 0; iDispersora < tzCtaDispersora.getNumRows(); iDispersora++, tzCtaDispersora.nextRow() ){
//					String valor = tzCtaDispersora.getString("TDLINE");
//					arrDispersora.add(valor);
//				}
				output.setCtaDisp(arrDispersora);

				JCoTable tzReferenciaPago =  data.getTable("ZREFERENCIIA_PAGO");
				ArrayList<String> arrReferenciaPago = new ArrayList<String>();
				for (int iReferenciaPago = 0; iReferenciaPago < tzReferenciaPago.getNumRows(); iReferenciaPago++, tzReferenciaPago.nextRow() ){
					String valor = tzReferenciaPago.getString("TDLINE");
					arrReferenciaPago.add(valor);
				}
				output.setReferencia(arrReferenciaPago);

				JCoTable tzCompetidores =  data.getTable("ZCOMPETIDORES");
				ArrayList<CompetidorInfo> arrCompetidorInfo = new ArrayList<CompetidorInfo>();
				for (int iCompetidores = 0; iCompetidores < tzCompetidores.getNumRows(); iCompetidores++, tzCompetidores.nextRow() ){
					CompetidorInfo competidorInfo = output.getCompetidorInfo();
					competidorInfo.setIdOrdServ( tzCompetidores.getString("ID_ORDSERV") );
					competidorInfo.setIdCompetidor( tzCompetidores.getString("ID_COMPETIDOR") );
					competidorInfo.setNombre1( tzCompetidores.getString("NOMBRE1") );
					competidorInfo.setNombre2( tzCompetidores.getString("NOMBRE2") );
					competidorInfo.setNombre3( tzCompetidores.getString("NOMBRE3") );
					competidorInfo.setNombre4( tzCompetidores.getString("NOMBRE4") );
					competidorInfo.setReferenciaComp( tzCompetidores.getString("REFERENCIA"));
					competidorInfo.setIdMetodoPago( tzCompetidores.getString("ID_METODO_PAGO") );
					competidorInfo.setDesMetodoPago( tzCompetidores.getString("DES_METODO_PAGO") );
					competidorInfo.setCuentaBancaria( tzCompetidores.getString("CUENTA_BANCARIA") );
					competidorInfo.setTipoDeCuenta( tzCompetidores.getString("TIPO_DE_CUENTA") );
					competidorInfo.setClaveBanco( tzCompetidores.getString("CLAVE_BANCO") );
					competidorInfo.setNombreDeBanco( tzCompetidores.getString("NOMBRE_DE_BANCO") );
					competidorInfo.setMontoDisper( tzCompetidores.getBigDecimal("MONTO_DISPER") );
					competidorInfo.setConceptoLcom(tzCompetidores.getString("CONCEPTO"));
					arrCompetidorInfo.add(competidorInfo);
				}
				output.setArrCompetidoresInfo(arrCompetidorInfo);
//				arrCompetidorInfo.clear();
				returnList.add( output );
			}
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		return( returnList );
	}
	
}
