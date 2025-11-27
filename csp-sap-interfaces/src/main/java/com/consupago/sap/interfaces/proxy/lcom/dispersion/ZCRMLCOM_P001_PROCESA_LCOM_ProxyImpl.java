package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.lcom.dispersion.ZCRMLCOM_P001_PROCESA_LCOM_OutputData.Competidores;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMLCOM_P001_PROCESA_LCOM_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P001_PROCESA_LCOM_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_P001_PROCESA_LCOM";
	
	public ZCRMLCOM_P001_PROCESA_LCOM_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMLCOM_P001_PROCESA_LCOM_OutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		ArrayList<ZCRMLCOM_P001_PROCESA_LCOM_OutputData> returnList = new ArrayList<ZCRMLCOM_P001_PROCESA_LCOM_OutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUD");
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
				ZCRMLCOM_P001_PROCESA_LCOM_OutputData output = new ZCRMLCOM_P001_PROCESA_LCOM_OutputData();
				output.setZnumerosolicitud(data.getString("ZNUMERO_SOLICITUD") );
				output.setZidconvenio(data.getString("ZID_CONVENIO") );
				output.setZidproducto(data.getString("ZID_PRODUCTO") );
				output.setZidempresa(data.getString("ZID_EMPRESA") );
				output.setZiddependencia(data.getString("ZID_DEPENDENCIA") );
				output.setZidsucursal(data.getString("ZID_SUCURSAL") );
				output.setZdescripcionsucural(data.getString("ZDESCRIPCION_SUCURAL") );
				output.setZdescripcionconvenio(data.getString("ZDESCRIPCION_CONVENIO") );
				output.setZdescripciondep(data.getString("ZDESCRIPCION_DEP") );
				output.setZdescripcionprod(data.getString("ZDESCRIPCION_PROD") );
				output.setZdescripcionempresa(data.getString("ZDESCRIPCION_EMPRESA") );
				output.setZtasaintprod(data.getDouble("ZTASA_INTPROD") );
				output.setZfechanacclie(data.getDate("ZFECHA_NAC_CLIE") );
				output.setZidestatussolicitud(data.getString("ZID_ESTATUS_SOLICITUD") );
				output.setZdescripcionestatsol(data.getString("ZDESCRIPCION_ESTATSOL") );
				output.setZorigensolicitud(data.getString("ZORIGEN_SOLICITUD") );
				output.setZnumeroreprocesosol(data.getInt("ZNUMERO_REPROCESO_SOL") );
				output.setZclaveusuarioiniciador(data.getString("ZCLAVE_USUARIO_INICIADOR") );
				output.setZclaveinterbancaria(data.getString("ZCLAVE_INTERBANCARIA") );
				output.setZclavebanco(data.getString("ZCLAVE_BANCO") );
				output.setZdescripcionbanco(data.getString("ZDESCRIPCION_BANCO") );
				output.setZfrecuencia(data.getString("ZFRECUENCIA") );
				output.setZidcaso(data.getString("ZID_CASO") );
				output.setZfechasolicitud(data.getDate("ZFECHA_SOLICITUD") );
				output.setZgrupopago(data.getString("ZGRUPO_PAGO") );
				output.setZsustitucion(data.getString("ZSUSTITUCION") );
				output.setZgrupoanalista(data.getString("ZGRUPO_ANALISTA") );
				output.setZbpcliente(data.getString("ZBP_CLIENTE") );
				output.setZmontosolicitud(data.getDouble("ZMONTO_SOLICITUD") );
				output.setZbppromotor(data.getString("ZBP_PROMOTOR") );
				output.setZnombrepromotor(data.getString("ZNOMBRE_PROMOTOR") );
				output.setZnombrepromotor2(data.getString("ZNOMBRE_PROMOTOR2") );
				output.setZapepaternoprom(data.getString("ZAPE_PATERNO_PROM") );
				output.setZapematernoprom(data.getString("ZAPE_MATERNO_PROM") );
				output.setZnombreclie(data.getString("ZNOMBRE_CLIE") );
				output.setZnombreclie2(data.getString("ZNOMBRE_CLIE2") );
				output.setZapepaternoclie(data.getString("ZAPE_PATERNO_CLIE") );
				output.setZapematernoclie(data.getString("ZAPE_MATERNO_CLIE") );
				output.setZrfccliente(data.getString("ZRFC_CLIENTE") );
				output.setZtelcleinte(data.getString("ZTEL_CLEINTE") );
				output.setZplazo(data.getInt("ZPLAZO") );
				output.setZfolderecmi(data.getString("ZFOLDER_ECMI") );
				output.setZidcoi(data.getString("ZID_COI") );
				//recupero subtabla de competidores.
				JCoTable catTab =  data.getTable("ZCOMPETIDORES");
				
				ArrayList<Competidores> arrComp = new ArrayList<Competidores>();
				for (int j = 0; j < catTab.getNumRows(); j++, catTab.nextRow() ) {
					Competidores comp = output.getCompetidores();
					comp.setIdordserv(catTab.getString("ID_ORDSERV") );
					comp.setStatusos(catTab.getString("STATUS_OS") );
					comp.setDescstatos(catTab.getString("DESCSTAT_OS") );
					comp.setIdcompetidor(catTab.getString("ID_COMPETIDOR") );
					comp.setNombre1(catTab.getString("NOMBRE1") );
					comp.setNombre2(catTab.getString("NOMBRE2") );
					comp.setApepat(catTab.getString("APEPAT") );
					comp.setApemat(catTab.getString("APEMAT") );
					comp.setFechaemision(catTab.getDate("FECHA_EMISION") );
					comp.setFechavencimiento(catTab.getDate("FECHA_VENCIMIENTO") );
					comp.setFechaultdescto(catTab.getDate("FECHA_ULTDESCTO") );
					comp.setFrecuencia(catTab.getString("FRECUENCIA") );
					comp.setConcepto(catTab.getString("CONCEPTO") );
					comp.setMonto(catTab.getDouble("MONTO") );
					comp.setIdmetodopago(catTab.getString("ID_METODO_PAGO") );
					comp.setDesmetodopago(catTab.getString("DES_METODO_PAGO") );
					comp.setPagstrans(catTab.getInt("PAGS_TRANS") );
					comp.setReferencia(catTab.getString("REFERENCIA") );
					comp.setBancocompet(catTab.getString("BANCO_COMPET") );
					comp.setCuentabancaria(catTab.getString("CUENTA_BANCARIA") );
					comp.setClaveBanco(catTab.getString("CLAVE_BANCO"));
					comp.setReferenciaBancaria(catTab.getString("REFERENCIA_BANCARIA"));
					arrComp.add(comp);
				}
				output.setArrCompetidores(arrComp);
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
