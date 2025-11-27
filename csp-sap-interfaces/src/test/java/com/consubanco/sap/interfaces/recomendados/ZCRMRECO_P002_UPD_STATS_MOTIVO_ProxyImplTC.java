package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.ESTATUS_MOTIVO_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImplTC.class );
	


	/**
	 * 
	 */
	public ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImplTC() {
		
	}


	
	/**
	 * @param name
	 */
	public ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl proxy = new ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl();
        
        ESTATUS_MOTIVO_Model inputParamsData = new ESTATUS_MOTIVO_Model();
        
        inputParamsData.setNumeroOrdenServicio("1525000100");
        inputParamsData.setNuevoEstatus("E0004");
        
        ArrayList<ProxyInputParameter> motivos;
        ProxyInputParameter motivo;
        
        motivos = new ArrayList<ProxyInputParameter>();

        motivo = new ProxyInputParameter();
        motivo.setValue("ZRC1");
        motivos.add(motivo);
        
        motivo = new ProxyInputParameter();
        motivo.setValue("ZRC2");
        motivos.add(motivo);
        
        inputParamsData.setMotivos(motivos);

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParamsData );
        
        log.info( returnData.toString() );
        
	}
}
