package com.consupago.sap.interfaces.proxy.dispersionnostro.lcom;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author
 * Llamada al JCO que ejecuta la formalizacion de GEM.
 * de las solicitudes.
 * 
 */
public class ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_E002_READLCOM_XSTATUS";
	
	public ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImpl() {
		super();		
	}

	public ZCRMLCOM_E002_READLCOM_XSTATUS_OutputData executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ZCRMLCOM_E002_READLCOM_XSTATUS_OutputData data = new ZCRMLCOM_E002_READLCOM_XSTATUS_OutputData();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
				throw new RuntimeException(RFC_NAME + " not found in SAP.");

			function = ft.getFunction();

			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			function.execute(destination);			
			
			JCoTable dataTableDocumentos = function.getExportParameterList().getTable("ET_DOCTOS");
			log.info("" + dataTableDocumentos.toString());			
			ArrayList<Solicitudes_OutputData> solicitudList = new ArrayList<Solicitudes_OutputData>();
			for (int i = 0; i < dataTableDocumentos.getNumRows(); i++, dataTableDocumentos.nextRow()) {		
				Solicitudes_OutputData solicitud = new Solicitudes_OutputData();				
				solicitud.setNumDoc(dataTableDocumentos.getString("NUMDOC"));	
				solicitud.setTipDoc(dataTableDocumentos.getString("TIPDOC"));
				
				solicitud.setCategory(dataTableDocumentos.getString("CATEGORY"));
				solicitud.setClientId(dataTableDocumentos.getString("NUMCLI"));
				solicitud.setNombre1(dataTableDocumentos.getString("NOMBRE1"));
				solicitud.setNombre2(dataTableDocumentos.getString("NOMBRE2"));
				solicitud.setApellidoPaterno(dataTableDocumentos.getString("APEPAT"));
				solicitud.setApellidoMaterno(dataTableDocumentos.getString("APEMAT"));
				solicitud.setStatus(dataTableDocumentos.getString("STATUS"));
				solicitud.setStatusDesc(dataTableDocumentos.getString("DESTATUS"));
				solicitud.setFecNac(dataTableDocumentos.getDate("FEC_NAC"));
				solicitud.setRfc(dataTableDocumentos.getString("RFC_CLTE"));
				solicitud.setFecSol(dataTableDocumentos.getDate("FEC_SOL"));
				solicitud.setFrecPago(dataTableDocumentos.getString("FREC_PAGO"));
				solicitud.setIdConvenio(dataTableDocumentos.getString("ID_CONVENIO"));
				solicitud.setDescConvenio(dataTableDocumentos.getString("DESC_CONVEN"));
				solicitud.setIdEmpresa(dataTableDocumentos.getString("ID_EMPRESA"));
				solicitud.setDescEmpresa(dataTableDocumentos.getString("DESC_EMPRESA"));
				solicitud.setMonto(dataTableDocumentos.getDouble("MONTO"));
				solicitud.setMontoLiqu(dataTableDocumentos.getDouble("MONTO_LIQU"));
				solicitud.setProducto(dataTableDocumentos.getString("PRODUCTO"));
				solicitud.setDescProducto(dataTableDocumentos.getString("DESC_PRODUCTO"));
				solicitud.setPlazo(dataTableDocumentos.getString("PLAZO"));
				solicitud.setPorcInt(dataTableDocumentos.getString("PORC_INT"));
				solicitud.setCredSus(dataTableDocumentos.getString("CREDSUS"));
				
				JCoTable dataTableOrdenes = dataTableDocumentos.getTable("ORDENES_SERVICIO");
				log.info("" + dataTableOrdenes.toString());		
				ArrayList<OrdenesServicios_OutputData> ordenServicioList = new ArrayList<OrdenesServicios_OutputData>();
				for (int j = 0; j < dataTableOrdenes.getNumRows(); j++, dataTableOrdenes.nextRow()) {		
					OrdenesServicios_OutputData ordenes = new OrdenesServicios_OutputData();				
					ordenes.setIdOrdServ(dataTableOrdenes.getString("ID_ORDSERV"));
					ordenes.setStatus(dataTableOrdenes.getString("STATUS_OS"));
					ordenes.setDescStatus(dataTableOrdenes.getString("DESCSTAT_OS"));
					ordenes.setIdCompetidor(dataTableOrdenes.getString("ID_COMPETIDOR"));
					ordenes.setNombre1(dataTableOrdenes.getString("NOMBRE1"));
					ordenes.setNombre2(dataTableOrdenes.getString("NOMBRE2"));
					ordenes.setApellidoPaterno(dataTableOrdenes.getString("APEPAT"));
					ordenes.setApellidoMaterno(dataTableOrdenes.getString("APEMAT"));
					ordenes.setFechaEmision(dataTableOrdenes.getDate("FECHA_EMISION"));
					ordenes.setFechaVencimiento(dataTableOrdenes.getDate("FECHA_VENCIMIENTO"));
					ordenes.setFechaUltimoDescuento(dataTableOrdenes.getDate("FECHA_ULTDESCTO"));
					ordenes.setFrecPago(dataTableOrdenes.getString("FREC_PAGO"));
					ordenes.setDescFrecPago(dataTableOrdenes.getString("DESC_FREC_PAGO"));
					ordenes.setConcepto(dataTableOrdenes.getString("CONCEPTO"));
					ordenes.setMonto(dataTableOrdenes.getDouble("MONTO"));
					ordenes.setIdMetodoPago(dataTableOrdenes.getString("ID_METODO_PAGO"));
					ordenes.setDesMetodoPago(dataTableOrdenes.getString("DES_METODO_PAGO"));
					ordenes.setPagsTrans(dataTableOrdenes.getString("PAGS_TRANS"));
					ordenes.setReferencia(dataTableOrdenes.getString("REFERENCIA"));
					ordenes.setBancoCompet(dataTableOrdenes.getString("BANCO_COMPET"));
					ordenes.setCuentaBancaria(dataTableOrdenes.getString("CUENTA_BANCARIA"));
					ordenes.setClaveBanco(dataTableOrdenes.getString("CLAVE_BANCO"));
					ordenes.setReferenciaBancaria(dataTableOrdenes.getString("REFERENCIA_BANCARIA"));
					ordenes.setFechaAprobacion(dataTableOrdenes.getDate("FECHA_APROBAC"));
					ordenes.setMontoDescuento(dataTableOrdenes.getDouble("MONTO_DESCTO"));					
					ordenServicioList.add( ordenes );
				}
				
				if(!ordenServicioList.isEmpty())
					solicitud.setOrdenServicioList(ordenServicioList);					
			
				solicitudList.add(solicitud);
			}
			data.setSolicitudList(solicitudList);		
			
			data.setMessageError(function.getExportParameterList().getString("E_MESSAGE"));
			
			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {

		}

		return( data );
	}
	
}
