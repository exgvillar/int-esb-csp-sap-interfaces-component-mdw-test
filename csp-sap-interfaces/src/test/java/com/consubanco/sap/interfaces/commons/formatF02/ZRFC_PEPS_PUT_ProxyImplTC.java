/**
 * 
 */
package com.consubanco.sap.interfaces.commons.formatF02;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.ZRFC_PEPS_PUT_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_INGRESO_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_PEPS_PUT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_PEPS_PUT_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_PEPS_PUT_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_PEPS_PUT_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_PEPS_PUT_ProxyImpl proxy = new ZRFC_PEPS_PUT_ProxyImpl();
        
        ZTL_PEPS_Model pepInputParams = new ZTL_PEPS_Model();
        pepInputParams.setNumCliente("0000541941");
        pepInputParams.setNumSolicitud("0070000943");
        pepInputParams.setFechaCreacionSolicitud( null );
        pepInputParams.setFechaEstatusPEP( null );
        pepInputParams.setFechaAltaQEQ( null );
        pepInputParams.setFechaBajaQEQ( null );
        pepInputParams.setPuestoPEP( "GOBERNADOR" );
        pepInputParams.setAreaDepto( "GOB COAHUILA" );
        pepInputParams.setCargoEleccionPopular( "SI" );
        pepInputParams.setFechaInicioGestion( Date.valueOf("2015-01-28") );
        pepInputParams.setNombreDependencia( "H. GOB. COAH" );
        pepInputParams.setDireccionDependencia( "CONOCIDA SIN NUM" );
        pepInputParams.setIngresoBrutoMensual( 10000 );
        pepInputParams.setOtrosNegocios( "EJEMPLO PEP" );
        pepInputParams.setDescOtrosNegocios( "" );
        
        
        ArrayList<ZTL_PEPS_INGRESO_Model> ingresosList = new ArrayList<ZTL_PEPS_INGRESO_Model>();
		ZTL_PEPS_INGRESO_Model _ingreso1 = new ZTL_PEPS_INGRESO_Model();
		_ingreso1.setCveIngreso("SU");
		_ingreso1.setDescIngreso("SUELDOS");
		_ingreso1.setTipoValor(null);
		_ingreso1.setValor("X");
		ingresosList.add( _ingreso1 );
		
		ZTL_PEPS_INGRESO_Model _ingreso2 = new ZTL_PEPS_INGRESO_Model();
		_ingreso2.setCveIngreso("HO");
		_ingreso2.setDescIngreso("HONORARIOS");
		_ingreso2.setTipoValor(null);
		_ingreso2.setValor("X");
		ingresosList.add( _ingreso2 );
		
		
		pepInputParams.setIngresos( ingresosList );
        
        
        boolean resut = proxy.executeRemoteFunction(destination, pepInputParams );
        
        //log.info( pepData.toString() );
        
        
        
	}
}
