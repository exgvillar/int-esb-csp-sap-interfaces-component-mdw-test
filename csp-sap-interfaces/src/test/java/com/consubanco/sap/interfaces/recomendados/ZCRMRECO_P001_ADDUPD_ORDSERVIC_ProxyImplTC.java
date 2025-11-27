package com.consubanco.sap.interfaces.recomendados;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImplTC.class );
	


	/**
	 * 
	 */
	public ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImplTC() {
		
	}


	
	/**
	 * @param name
	 */
	public ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl proxy = new ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl();

		ORDEN_SERVICIO_Model serviceOrder = new ORDEN_SERVICIO_Model();

		serviceOrder.setNumeroOrdenServicio("");
		serviceOrder.setBpRefiere("578020");
		serviceOrder.setSolClienteRefiere(fillStringWithZerosOnLeft("50001552", 10 ));
		serviceOrder.setBpReferido("578021");
		serviceOrder.setMontoPago(500.0);
		serviceOrder.setBpEmpleadoResponsable("10002446");
		serviceOrder.setSolClienteReferido(fillStringWithZerosOnLeft("50001552", 10 ));
		serviceOrder.setTipoSolicitudCredito("ZCSP");
		serviceOrder.setFechaAprobacion(Date.valueOf("2015-08-02"));
		serviceOrder.setObservaciones("Test Case Add Service Order 50001554");
		serviceOrder.setOcurrenciasPago("1");
		serviceOrder.setCanalOrigen("003");
		serviceOrder.setReferenciaPago("");


		ArrayList<String> motivos = new ArrayList<String>();
		serviceOrder.setMotivos(motivos);

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, serviceOrder );
        
        log.info( returnData.toString() );

	}
	
	public static String fillStringWithZerosOnLeft(String str, int toLength) {
		StringBuffer buffer = new StringBuffer();
		if (str.length() >= toLength)
			buffer.append(str);
		else {
			int j = str.length();
			for (int i = j; i < toLength; i++) {
				buffer.append("0");
			}
			buffer.append(str);
		}
		return (buffer.toString());
	}

}
