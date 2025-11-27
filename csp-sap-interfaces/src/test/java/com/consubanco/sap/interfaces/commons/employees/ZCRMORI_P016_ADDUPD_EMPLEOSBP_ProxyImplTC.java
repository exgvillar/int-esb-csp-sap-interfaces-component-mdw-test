/**
 * 
 */
package com.consubanco.sap.interfaces.commons.employees;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl proxy = new ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl();
                
        ArrayList<ZTL_EMPLEOBP_Model> empleos = new ArrayList<ZTL_EMPLEOBP_Model>();
        ZTL_EMPLEOBP_Model empleo = new ZTL_EMPLEOBP_Model();
        empleo.setBpId("0002614352");	
        empleo.setClaveProfesion("1133");        
        empleo.setLugarTrabajo("CSB");
        empleo.setGiroEmpresa("0000500000");    	
        empleo.setActividadEmpresa("0000511015");
        empleo.setCargoDesempenadoId("02");   
        empleo.setCargoDesempenado("Empleado"); 
        empleo.setAntiguedadEmpleoActual(0); 	
        empleo.setAntiguedadEmpleoAnterior(0);
        empleo.setGiroActividadAltoRiesgo( "1074" );  
         	
        empleo.setTelefonoTrabajo("2281001100");        
        empleo.setMail("lpercio@gmg.com");
                
        empleo.setIngresoMensual(10000.00);	
    	empleo.setOtrosIngresos(2000);    	
    	empleo.setFuenteOtrosIngresos("Consultorio");    	
    	empleo.setIngresoMensual(10000.0);
    	empleos.add(empleo);
        
    	List<IProxyOutputData> result = proxy.executeRemoteFunction(destination, empleos );
    	log.info("Resultado :: "+result.toString());
        
	}
}
