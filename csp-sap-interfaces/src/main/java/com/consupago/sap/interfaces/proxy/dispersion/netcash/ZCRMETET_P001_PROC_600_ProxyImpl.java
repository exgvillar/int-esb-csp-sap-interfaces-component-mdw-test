package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author jcontreras
 *	proxy que devuelve la informacion de las solicitudes para armar lo que era el i600.
 */
public class ZCRMETET_P001_PROC_600_ProxyImpl {


	private static Log log = LogFactory.getLog( ZCRMETET_P001_PROC_600_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMETET_P001_PROC_600";
	
	public ZCRMETET_P001_PROC_600_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMETET_P001_PROC_600_OutputData>  executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ArrayList<ZCRMETET_P001_PROC_600_OutputData> returnList = new ArrayList<ZCRMETET_P001_PROC_600_OutputData>();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
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

			JCoTable messages = function.getExportParameterList().getTable("E_MESSAGE");
			HashMap<String, ArrayList<ZCRMETET_P001_PROC_600_OutputMessage>> hshMensajes = new HashMap<String, ArrayList<ZCRMETET_P001_PROC_600_OutputMessage>>();
			for (int i = 0; i < messages.getNumRows(); i++, messages.nextRow() ) {
				String numSolic = messages.getString("ZID_SOL");
				ZCRMETET_P001_PROC_600_OutputMessage proc_600OutputMessage = new ZCRMETET_P001_PROC_600_OutputMessage();
				proc_600OutputMessage.setZidSol(numSolic);
				proc_600OutputMessage.setzMessage(messages.getString("ZMESSAGE"));
				proc_600OutputMessage.setzInd( ( StringUtils.trimToNull(messages.getString("ZIND"))!=null )?true:false);
				if (hshMensajes.containsKey(numSolic)){
					ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> arrOutMsg = hshMensajes.get(numSolic);
					arrOutMsg.add(proc_600OutputMessage);
					hshMensajes.put(numSolic,arrOutMsg);
				} else {
					ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> arrOutMsg = new ArrayList<ZCRMETET_P001_PROC_600_OutputMessage>();
					arrOutMsg.add(proc_600OutputMessage);
					hshMensajes.put(numSolic, arrOutMsg);
				}
			}

			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				boolean contieneError = false;
				ZCRMETET_P001_PROC_600_OutputData output = new ZCRMETET_P001_PROC_600_OutputData();
				output.setZidEmpresa( data.getString("ZID_EMPRESA") );
				output.setZdescripcionViaPago( data.getString("ZDESCRIPCION_VIA_PAGO") );
				output.setZclaveBanco( data.getString("ZCLAVE_BANCO") );
				output.setZclaveInterbancaria( data.getString("ZCLAVE_INTERBANCARIA") );
				output.setZrefere( data.getString("ZREFERE") );
				output.setZmontoSolicitud( data.getString("ZMONTO_SOLICITUD") );
//				output.setZnumord( data.getString("ZNUMORD") );
				output.setZmon( data.getString("ZMON") );
				output.setZbuGroup( data.getString("ZBU_GROUP") );
				output.setZapePaternoClie( data.getString("ZAPE_PATERNO_CLIE") );
				output.setZapeMaternoClie( data.getString("ZAPE_MATERNO_CLIE") );
				output.setZnombreClie( data.getString("ZNOMBRE_CLIE") );
				output.setZnombreClie2( data.getString("ZNOMBRE_CLIE2") );
				output.setZrfcCliente( data.getString("ZRFC_CLIENTE") );
				output.setZidType( data.getString("ZID_TYPE") );
				output.setZid( data.getString("ZID") );
				output.setZtipsol( data.getString("ZTIPSOL") );
				output.setZbpCliente( data.getString("ZBP_CLIENTE") );
				output.setZnumSol( data.getString("ZNUM_SOL") );
				output.setZfechaSolicitud( data.getString("ZFECHA_SOLICITUD") );
				output.setZconban( data.getString("ZCONBAN") );
				output.setZidSucursal( data.getString("ZID_SUCURSAL") );
				output.setZdescSucursal( data.getString("ZDESC_SUCURSAL") );
				output.setZidDistribuidor( data.getString("ZID_DISTRIBUIDOR") );
				output.setZdescDistribuidor( data.getString("ZDESC_DISTRIBUIDOR") );
				output.setZconvenio( data.getString("ZCONVENIO") );
				output.setZnomconv( data.getString("ZNOMCONV") );
				output.setZconvf( data.getString("ZCONVF") );
				output.setZfecaut( data.getString("ZFECAUT") );
				output.setZmontoAut( data.getString("ZMONTO_AUT") );
				output.setZmontoDes( data.getString("ZMONTO_DES") );
				output.setZplazo( data.getString("ZPLAZO") );
				output.setZscm( data.getString("ZSCM") );
				output.setZidOrdserv( data.getString("ZID_ORDSERV") );
				output.setZfcreaOs( data.getString("ZFCREA_OS") );
				output.setZstatusOs( data.getString("ZSTATUS_OS") );
				output.setZimpOs( data.getString("ZIMP_OS") );
				
				// obtengo los detalles de los mensajes devueltos.
				ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> arrOutMsgs = hshMensajes.get(output.getZnumSol());
				if (!arrOutMsgs.isEmpty()){
					for (ZCRMETET_P001_PROC_600_OutputMessage zcrmetetP001PROC_600OutputMessage : arrOutMsgs) {
						if(zcrmetetP001PROC_600OutputMessage.iszInd() && !contieneError){
							contieneError = true;
							break;
						}
					}
				}
				output.setError(contieneError);
				output.setArrMsgReturn(arrOutMsgs);

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
