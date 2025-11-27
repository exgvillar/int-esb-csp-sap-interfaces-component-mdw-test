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
public class MonitorEnLinea2_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( MonitorEnLinea2_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public MonitorEnLinea2_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public MonitorEnLinea2_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		int cta = 0;
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
        
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);

        System.out.println("HORA DE MONITOREO : " + strDate );
        System.out.println("ESTATUS ZCSP_AUTORIZADA_EN_PROCESO_COMPRA [" + ((arrLista!=null)?arrLista.size():"0") + " SOLICITUDES]");
//        System.out.println("arrLista::\n" + arrLista.toString() );
        // obtengo informacion del RFC de DWH para saber si tiene o no el flag de dispersion en linea ...
        ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl dwhProxy = new ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl();
        for (String lasolic : arrLista) {
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
        	cta++;
        	if ( (StringUtils.trimToNull(solOrg.getCtaEmpresarial())!=null) && solOrg.getCtaEmpresarial().trim().toUpperCase().equalsIgnoreCase("SI") ){ // debia ser en linea?
//        	if ( true ){ // debia ser en linea?        		System.out.print("\n" + cta + "\t");
            	System.out.print(cta + " Analizando  ::" + lasolic + "\t");
        		if (StringUtils.trimToNull(atrrOrig.getLcom())==null && solicitud.getDisbursementChannelId().equalsIgnoreCase("6")){
        			System.out.print("NORM::\t" + lasolic + "\t[ DESDE " + this.formateaHora(lastTracking.getMinutoInicial(), lastTracking.getHoraInicial() ) + "]");
        		} else if ( solicitud.getDisbursementChannelId().equalsIgnoreCase("7") ){
        			System.out.print("NORM::\t" + lasolic + "\t Pago en ventanilla." );
        		} else if ( solicitud.getDisbursementChannelId().equalsIgnoreCase("8") ){
        			System.out.print("NORM::\t" + lasolic + "\t Pago con Cheque." );
        		} else {
        			System.out.print("NORM::\t" + lasolic + "\t" + solicitud.getDisbursementChannelId() );
        		}
        		// NO ES LCOM y EL PAGO ES DEPOSITO A CUENTA?
        		// es lcom ??
        		if (StringUtils.trimToNull(atrrOrig.getLcom())!=null ){
        			System.out.print("LCOM::\t" + lasolic);
        			// ejecuto RFC 
        			for (Servicios_OutputData trackingOutputData : arrOrdServ) {
    					System.out.print("\tOS:" + trackingOutputData.getIdOrdenServicio() + "[" + trackingOutputData.getEstatus() + "]");
	        		}
        		}
        	} else {
        		System.out.print(cta + " SIN CTA EMP ::" + lasolic + "\t");
        		if (StringUtils.trimToNull(atrrOrig.getLcom())==null && solicitud.getDisbursementChannelId().equalsIgnoreCase("6")){
        			System.out.print("NORM::\t" + lasolic + "\t[ DESDE " + this.formateaHora(lastTracking.getMinutoInicial(), lastTracking.getHoraInicial() ) + "]");
        		} else if ( solicitud.getDisbursementChannelId().equalsIgnoreCase("7") ){
        			System.out.print("NORM::\t" + lasolic + "\t Pago en ventanilla." );
        		} else if ( solicitud.getDisbursementChannelId().equalsIgnoreCase("8") ){
        			System.out.print("NORM::\t" + lasolic + "\t Pago con Cheque." );
        		} else {
        			System.out.print("NORM::\t" + lasolic + "\t" + solicitud.getDisbursementChannelId() );
        		}
        	}
        	System.out.println();
		}
        System.out.println("\n PROCESO FINALIZADO.");
        
        
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
