/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.status.ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.common.utils.CRM_Estatus_Solicitudes;
import com.consupago.sap.interfaces.proxy.dispersionnostro.AtributosOriginacion_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.Servicios_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.SolicitudOrganizacion_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.Solicitud_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.Tracking_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.ZCRMDWH_E001_INFO_SOLICITUD_OutputData;
import com.consupago.sap.interfaces.proxy.dispersionnostro.ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMCTEM_E001_SOLBYESTAT_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl;
import com.consupago.sap.interfaces.proxy.lcom.cartas.ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData;
import com.consupago.sap.interfaces.proxy.lcom.cartas.ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class MonitorEnLinea_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( MonitorEnLinea_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public MonitorEnLinea_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public MonitorEnLinea_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		int cta = 1;
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        // obtengo la lista de las solicitudes que estan en autorizadas en proceso de compra.
		ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl proxy = new ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl();
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue(  CRM_Estatus_Solicitudes.ZCSP_AUTORIZADA_EN_PROCESO_COMPRA );
        inputParams.add( input );
//                
        ZCRMCTEM_E001_SOLBYESTAT_OutputData returnData = getData(proxy.executeRemoteFunction(destination, inputParams ));
        ArrayList<String> arrLista = returnData.getRequestIdList();

        System.out.println("ESTATUS AUTORIZADA_EN_PROCESO_COMPRA [" + arrLista.size() + " SOLICITUDES]");
        // obtengo informacion del RFC de DWH para saber si tiene o no el flag de dispersion en linea ...
        ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl dwhProxy = new ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl();
        for (String lasolic : arrLista) {
        	System.out.print("\n" + cta++ + "\t");
//        	System.out.println("solicitud::" + lasolic );
        	ArrayList<ProxyInputParameter> inputParamsDWH = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter inputDwh = new ProxyInputParameter();
        	inputDwh.setKey("I_SOLICITUD");
        	inputDwh.setValue( lasolic );
        	inputParamsDWH.add( inputDwh );
        	ZCRMDWH_E001_INFO_SOLICITUD_OutputData dataDwhRet = dwhProxy.executeRemoteFunction(destination, inputParamsDWH );
        	SolicitudOrganizacion_OutputData solOrg = dataDwhRet.getSolicitudOrganizacion();
        	Solicitud_OutputData solicitud = dataDwhRet.getSolicitud();
        	ArrayList<Servicios_OutputData> arrOrdServ = dataDwhRet.getServicioList();
        	ArrayList<Tracking_OutputData> arrTraking = dataDwhRet.getTrackingList();
        	Tracking_OutputData lastTracking = arrTraking.get(arrTraking.size()-1);
        	AtributosOriginacion_OutputData atrrOrig = dataDwhRet.getAtributosOriginacion();
        	// si no es lcom, mostrar desde que momento esta en autorizada?
        	if ( (StringUtils.trimToNull(solOrg.getCtaEmpresarial())!=null) && solOrg.getCtaEmpresarial().trim().toUpperCase().equalsIgnoreCase("SI") ){ // debia ser en linea?
        		// NO ES LCOM y EL PAGO ES DEPOSITO A CUENTA?
        		if (StringUtils.trimToNull(atrrOrig.getLcom())==null && solicitud.getDisbursementChannelId().equalsIgnoreCase("6")){
        			System.out.print(lasolic + "\t[ DESDE " + this.formateaHora(lastTracking.getMinutoInicial(), lastTracking.getHoraInicial() ) + "]");
        		} else if ( solicitud.getDisbursementChannelId().equalsIgnoreCase("7") ){
        			System.out.print(lasolic + "\t Pago en ventanilla." );
        		}
        		// es lcom ??
        		if (StringUtils.trimToNull(atrrOrig.getLcom())!=null ){
        			System.out.print("LCOM::\t" + lasolic);
        			boolean allDispersado = false;
        			//checo las OS...
        			for (Servicios_OutputData trackingOutputData : arrOrdServ) {
        				System.out.print("\tOS:" + trackingOutputData.getIdOrdenServicio() + "[" + trackingOutputData.getEstatus() + "]");
						if (!trackingOutputData.getEstatus().equalsIgnoreCase(CRM_Estatus_Solicitudes.ZLIQCOMP_DISPERSADO) 
								&& !trackingOutputData.getEstatus().equalsIgnoreCase(CRM_Estatus_Solicitudes.ZLIQCOMP_CANCELADO) ){
							allDispersado = false;
							break;
						} else if ( trackingOutputData.getEstatus().equalsIgnoreCase(CRM_Estatus_Solicitudes.ZLIQCOMP_DISPERSADO) ) {
							allDispersado = true;
						}
					}
//        			System.out.print("\n");
        			if (allDispersado){
//        				System.out.println("LCOM::"+lasolic + "\t" + this.formateaHora(lastTracking.getMinutoInicial(), lastTracking.getHoraInicial() ) + "");
//        				System.out.println(solicitud.toString() + "\n" + arrOrdServ.toString() + "\n========================\n");
        				// ejecuto RFC para avanzar la OS...
        				System.out.print("\n\tAVANZANDO SOLICITUD::" + lasolic );
        				ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl proxyAvanzaSol = new ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl();
        		        ProxyInputParameterWithTable inputParamsAvanza = new ProxyInputParameterWithTable();
        		        inputParamsAvanza.setRecordParam( new ArrayList<Object>() );
        		    	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        		        ProxyInputParameter inputRecord = new ProxyInputParameter();
        		        inputRecord.setKey("ZOBJECT_ID");
        		        inputRecord.setValue( lasolic ); // justificar ceros a la izq
        		        recordParams1.add( inputRecord );
        		        inputParamsAvanza.getRecordParam().add( recordParams1 );
        		        ArrayList<ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData> arrRet = proxyAvanzaSol.executeRemoteFunction(destination, inputParamsAvanza );
        		        if (!arrRet.isEmpty()) {
        		        	ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData salida = arrRet.get(0);
        		        	System.out.print("\t " + salida.getMensaje() );
        		        	if (salida.getMensaje().trim().equalsIgnoreCase("Se ha cambiado el Estatus de la Solicitud")){
//        		        		System.out.println("AVANZAR A EN ESP. DISP. CLIENTE.");
        		        		ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl prxUpdEstFec = new ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl();
        		            	ArrayList<ProxyInputParameter> inputParEspDispCli = new ArrayList<ProxyInputParameter>();
        		            	ProxyInputParameter inputEspDispCli = new ProxyInputParameter();
        		            	inputEspDispCli.setKey("I_DOCID");
        		            	inputEspDispCli.setValue( lasolic );
        		            	inputParEspDispCli.add( inputEspDispCli );
        		            	inputEspDispCli = new ProxyInputParameter();
        		            	inputEspDispCli.setKey("I_ESTATUS");
        		            	inputEspDispCli.setValue( CRM_Estatus_Solicitudes.ZCSP_EN_ESPERA_DISPERSION_CLIENTE );
        		            	inputParEspDispCli.add( inputEspDispCli );
        		            	inputEspDispCli = new ProxyInputParameter();
        		            	inputEspDispCli.setKey("I_DOCTYPE");
        		            	inputEspDispCli.setValue( "ZCSP"  ); // para solicitudes de CXN.
        		            	inputParEspDispCli.add( inputEspDispCli );
        		            	prxUpdEstFec.executeRemoteFunction(destination, inputParEspDispCli );
        		            	System.out.print("\tSolicitud Avanzada a Espera Disp Cliente.");
        		        	}
        		        }
        			}
        		}
        	} else {
        		System.out.print(lasolic + "\t No es Cta empresarial. [" + solOrg.getOwnerDesc() + "]");
        	}
//        	if (!dataDwhRet.getAtributosOriginacion().getLcom().equalsIgnoreCase("")){
        		
//        	} else {
        		
//        	}
		}
        System.out.println("\n PROCESO FINALIZADO.");
        
//        log.info( arrLista.toString() );

        
        
	}

	private ZCRMCTEM_E001_SOLBYESTAT_OutputData getData(ArrayList<IProxyOutputData> returnIProxyData)throws Exception{
		
		ZCRMCTEM_E001_SOLBYESTAT_OutputData returnBean = null;
		
		Iterator<IProxyOutputData> iter = returnIProxyData.iterator();
		while( iter.hasNext() ) {
			returnBean = (ZCRMCTEM_E001_SOLBYESTAT_OutputData) iter.next();						
		}
		
		return returnBean;
		
	}

	private String formateaHora(String dia, String hora){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat salida = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String regreso ="";
		try {
			Date fec = sdf.parse(dia+hora);
			regreso = salida.format(fec);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return regreso;
	}

}
