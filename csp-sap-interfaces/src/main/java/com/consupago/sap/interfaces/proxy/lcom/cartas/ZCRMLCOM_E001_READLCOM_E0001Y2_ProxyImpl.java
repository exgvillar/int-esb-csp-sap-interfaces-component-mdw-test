package com.consupago.sap.interfaces.proxy.lcom.cartas;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.lcom.cartas.ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData.OrdenesServicio;
import com.consupago.sap.interfaces.proxy.lcom.dispersion.ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData.CompetidorInfo;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_E001_READLCOM_E0001Y2";
	
	public ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData> executeRemoteFunction( JCoDestination destination,  ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData> returnList = new ArrayList<ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();

			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
//				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}

			
			
			log.info("input : " +  inputParamtersList.toString() );
			function.execute(destination);
			JCoTable data = function.getExportParameterList().getTable("ET_DOCTOS");
			log.info(data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData output = new ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData();

				output.setNumdoc(data.getString("NUMDOC") );
				output.setTipdoc(data.getString("TIPDOC") );
				output.setNumcli(data.getString("NUMCLI") );
				output.setNombre1(data.getString("NOMBRE1") );
				output.setNombre2(data.getString("NOMBRE2") );
				output.setApepat(data.getString("APEPAT") );
				output.setApemat(data.getString("APEMAT") );
				output.setStatus(data.getString("STATUS") );
				output.setDestatus(data.getString("DESTATUS") );
				output.setFecNac(data.getDate("FEC_NAC") );
				output.setRfcClte(data.getString("RFC_CLTE") );
				output.setFecSol(data.getDate("FEC_SOL") );
				output.setFrecPago(data.getString("FREC_PAGO") );
				output.setIdConvenio(data.getString("ID_CONVENIO") );
				output.setDescConven(data.getString("DESC_CONVEN") );
				output.setIdEmpresa(data.getString("ID_EMPRESA") );
				output.setDescEmpresa(data.getString("DESC_EMPRESA") );
				output.setMonto(data.getBigDecimal("MONTO") );
				output.setMontoLiqu(data.getBigDecimal("MONTO_LIQU") );
				output.setProducto(data.getString("PRODUCTO") );
				output.setDescProducto(data.getString("DESC_PRODUCTO") );
				output.setPlazo(data.getString("PLAZO") );
				output.setPorcInt(data.getString("PORC_INT") );
				output.setCredsus(data.getString("CREDSUS") );				
				
				//recupero subtabla de competidores.
				JCoTable ztbOrdenesServicio =  data.getTable("ORDENES_SERVICIO");
				ArrayList<OrdenesServicio> arrOrdenesServ = new ArrayList<OrdenesServicio>();
				for (int iOrdenesServ = 0; iOrdenesServ < ztbOrdenesServicio.getNumRows(); iOrdenesServ++, ztbOrdenesServicio.nextRow() ){
					OrdenesServicio ordServInfo = output.getOrdenesServ();
					ordServInfo.setIdOrdservOrdenServ( ztbOrdenesServicio.getString("ID_ORDSERV") );
					ordServInfo.setStatusOsOrdenServ( ztbOrdenesServicio.getString("STATUS_OS") );
					ordServInfo.setDescstatOsOrdenServ( ztbOrdenesServicio.getString("DESCSTAT_OS") );
					ordServInfo.setIdCompetidorOrdenServ( ztbOrdenesServicio.getString("ID_COMPETIDOR") );
					ordServInfo.setNombre1OrdenServ( ztbOrdenesServicio.getString("NOMBRE1") );
					ordServInfo.setNombre2OrdenServ( ztbOrdenesServicio.getString("NOMBRE2") );
					ordServInfo.setApepatOrdenServ( ztbOrdenesServicio.getString("APEPAT") );
					ordServInfo.setApematOrdenServ( ztbOrdenesServicio.getString("APEMAT") );
					ordServInfo.setFechaEmisionOrdenServ( ztbOrdenesServicio.getDate("FECHA_EMISION") );
					ordServInfo.setFechaVencimientoOrdenServ( ztbOrdenesServicio.getDate("FECHA_VENCIMIENTO") );
					ordServInfo.setFechaUltdesctoOrdenServ( ztbOrdenesServicio.getDate("FECHA_ULTDESCTO") );
					ordServInfo.setFrecPagoOrdenServ( ztbOrdenesServicio.getString("FREC_PAGO") );
					ordServInfo.setDescFrecPagoOrdenServ( ztbOrdenesServicio.getString("DESC_FREC_PAGO") );
					ordServInfo.setConceptoOrdenServ( ztbOrdenesServicio.getString("CONCEPTO") );
					ordServInfo.setMontoOrdenServ( ztbOrdenesServicio.getBigDecimal("MONTO") );
					ordServInfo.setIdMetodoPagoOrdenServ( ztbOrdenesServicio.getString("ID_METODO_PAGO") );
					ordServInfo.setDesMetodoPagoOrdenServ( ztbOrdenesServicio.getString("DES_METODO_PAGO") );
					ordServInfo.setPagsTransOrdenServ( ztbOrdenesServicio.getDouble("PAGS_TRANS") );
					ordServInfo.setReferenciaOrdenServ( ztbOrdenesServicio.getString("REFERENCIA") );
					ordServInfo.setBancoCompetOrdenServ( ztbOrdenesServicio.getString("BANCO_COMPET") );
					ordServInfo.setCuentaBancariaOrdenServ( ztbOrdenesServicio.getString("CUENTA_BANCARIA") );
					ordServInfo.setClaveBancoOrdenServ( ztbOrdenesServicio.getString("CLAVE_BANCO") );
					ordServInfo.setReferenciaBancariaOrdenServ( ztbOrdenesServicio.getString("REFERENCIA_BANCARIA") );

					
					arrOrdenesServ.add(ordServInfo);
				}
				output.setOrdenesServicio(arrOrdenesServ);
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
