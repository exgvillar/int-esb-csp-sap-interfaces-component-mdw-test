package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMDWH_E001_INFO_SOLICITUD_ProxyImplTC  extends TestCase  {

	private static Log log = LogFactory.getLog( ZCRMDWH_E001_INFO_SOLICITUD_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMDWH_E001_INFO_SOLICITUD_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMDWH_E001_INFO_SOLICITUD_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl proxy = new ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl();

        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
        ArrayList<String> arrSolic = new ArrayList<String>();

//        arrSolic.add("0050602540");
        arrSolic.add("0050453624");
        arrSolic.add("0050452780");
        arrSolic.add("0050453648");
        arrSolic.add("0050453653");
        arrSolic.add("0050453717");
        arrSolic.add("0050453766");
        arrSolic.add("0050453771");
        arrSolic.add("0050453780");
        arrSolic.add("0050453781");
        arrSolic.add("0050453805");
        arrSolic.add("0050453811");
        arrSolic.add("0050453816");
        arrSolic.add("0050453837");
        arrSolic.add("0050453943");
        arrSolic.add("0050454093");
        arrSolic.add("0050454341");
        arrSolic.add("0050454342");
        arrSolic.add("0050454369");
        arrSolic.add("0050454371");
        arrSolic.add("0050454374");
        arrSolic.add("0050454376");
        arrSolic.add("0050454385");
        arrSolic.add("0050454423");
        arrSolic.add("0050454427");
        arrSolic.add("0050454431");
        arrSolic.add("0050454432");
        arrSolic.add("0050454433");
        arrSolic.add("0050454440");
        arrSolic.add("0050454441");
        arrSolic.add("0050454450");
        arrSolic.add("0050454458");
        arrSolic.add("0050454459");
        arrSolic.add("0050454462");
        arrSolic.add("0050454464");

//    	System.out.println("Numero SAP\tOrden de Servicio\tCompetidor\tImporte\tReferencia\tNum Cta.");
//    	System.out.println("SOLICITUD\tAP PATERNO\tAP MATERNO\tNOMBRE 1\tNOMBRE 2\tBANCO\tCLABE");

        for (String lasolic : arrSolic) {
        	ArrayList<ProxyInputParameter> inputParamsDWH = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter inputDwh = new ProxyInputParameter();
        	inputDwh.setKey("I_SOLICITUD");
        	inputDwh.setValue( lasolic );
        	inputParamsDWH.add( inputDwh );
        	ZCRMDWH_E001_INFO_SOLICITUD_OutputData returnData = proxy.executeRemoteFunction(destination, inputParamsDWH );
//        	SolicitudOrganizacion_OutputData solOrg = returnData.getSolicitudOrganizacion();
        	Solicitud_OutputData solicitud = returnData.getSolicitud();
//        	ArrayList<CuentasClientes_OutputData> arrCuentasClientes = returnData.getCuentaClienteList();
//        	CuentasClientes_OutputData cuentasClientesOutputData = arrCuentasClientes.get(0) ;
//        	SolicitudCliente_OutputData solicitudClienteOutputData = returnData.getSolicitudCliente();
//        	AtributosOriginacion_OutputData atributosOriginacionOutputData = returnData.getAtributosOriginacion();
//        	Convenio_OutputData convenioOutputData = returnData.getConvenio();
//        	Bundle_OutputData bundleOutputData = convenioOutputData.getBundle();
//        	Producto_OutputData productoOutputData = bundleOutputData.getProducto();
        	ArrayList<Servicios_OutputData> arrOrdServ = returnData.getServicioList();
//        	ArrayList<Tracking_OutputData> arrTraking = returnData.getTrackingList();
//        	Tracking_OutputData firstTracking = arrTraking.get(0);
        	
        	System.out.print(solicitud.getApplication() + "\t");
//        	System.out.println(solicitud.getApplication() + "\t" + StringUtils.trimToEmpty(solicitudClienteOutputData.getPaternalNM()) + "\t"
//        			+ StringUtils.trimToEmpty(solicitudClienteOutputData.getMaternalNm()) + "\t" + solicitudClienteOutputData.getFirstNm() + "\t" 
//        			+ StringUtils.trimToEmpty(solicitudClienteOutputData.getSecondNM()) + "\t'" + StringUtils.trimToEmpty(cuentasClientesOutputData.getIdBanco()) + "\t"
//        			+ "'" + cuentasClientesOutputData.getNumeroCuenta()
//        			);
        	
//        	System.out.println(cuentasClientesOutputData.toString() );
        	for (Servicios_OutputData serviciosOutputData : arrOrdServ) {
				System.out.print(
//						"'" + solicitud.getApplication() + "\t'" +
						serviciosOutputData.getIdOrdenServicio() + "\t" +
						serviciosOutputData.getNombreCompetidor() + "\t" +
//						serviciosOutputData.getImporteLiquidacion() + "\t'" +
//						serviciosOutputData.getReferenciaPago() + "\t'" +
//						serviciosOutputData.getNumeroCuenta()
						serviciosOutputData.getEstatus() + "\t"
						);
			}

//        	System.out.println("\n\n===================================================\nARMADO DE I600:");
//        	String numCtaclie =  ( solicitud.getClientId());
//        	System.out.print( solOrg.getOwnerSigla() +"|" + solicitud.getDisbursementChannelId() + "|" + cuentasClientesOutputData.getIdBanco() + "|" + cuentasClientesOutputData.getNumeroCuenta() + "||" );
//        	System.out.print( solicitud.getAppliedAmt() + "|000000000000|MXN|Z01|" + solicitudClienteOutputData.getPaternalNM() + "|" + solicitudClienteOutputData.getMaternalNm() + "|");
//        	System.out.print( (StringUtils.trimToEmpty(solicitudClienteOutputData.getFirstNm()) + " " + StringUtils.trimToEmpty( solicitudClienteOutputData.getSecondNM()) ).trim()+"|" + solicitudClienteOutputData.getRfc() + "|||" );
//        	System.out.print( ( (StringUtils.trimToNull(atributosOriginacionOutputData.getCnca())!= null)?"Sustitución":"Normal" ) + "|" );
//        	System.out.print( numCtaclie  +"|" + solicitud.getApplication() + "|11/11/2016||");
//        	System.out.print( solOrg.getBranchSigla() + "|" + solOrg.getBranchDesc() + "|" + solOrg.getDistributorSigla() + "|" + solOrg.getDistributorDesc() + "|");
//        	System.out.print( convenioOutputData.getId() +"|" + convenioOutputData.getDescripcion() + "|0|" + this.formateaDia(firstTracking.getMinutoInicial()) + "|");
//        	System.out.print( solicitud.getApproveAmt() + "|" + solicitud.getChargeAmt() + "|024|" );
        	System.out.println("");

        	
        	
//        	AtributosOriginacion_OutputData atrrOrig = returnData.getAtributosOriginacion();
//        	System.out.println("LCOM::"+lasolic + "\t" + this.formateaHora(lastTracking.getMinutoInicial(), lastTracking.getHoraInicial() ) + "");
//        	System.out.println(solicitud.toString() + "\n" + arrOrdServ.toString() + "\n========================\n");
//        	System.out.println( returnData.toString() );
//            Solicitud_OutputData solicitud = returnData.getSolicitud();
//            ArrayList<Servicios_OutputData> arrOs = returnData.getServicioList();
//            System.out.print(solicitud.getApplication() + "\t" + solicitud.getStatusId() + "\t" );
//            for (Servicios_OutputData osDat : arrOs) {
//    			System.out.print(osDat.getIdOrdenServicio() + "\t" + osDat.getEstatus() + "\t" );
//    		}
//            System.out.println();
        }
        /*for( Incidencias_OutputData incidencia : returnData.getIncidenciaList()){
        	 System.out.println("incidencia: " + incidencia.toString());
        }
       
        for( CuentasClientes_OutputData cuentas : returnData.getCuentaClienteList()){
       	 System.out.println("cuentas: " + cuentas.toString());
       }*/
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


	private String formateaDia(String dia ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat salida = new SimpleDateFormat("dd/MM/yyyy");
		String regreso ="";
		try {
			Date fec = sdf.parse(dia);
			regreso = salida.format(fec);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return regreso;
	}

}
