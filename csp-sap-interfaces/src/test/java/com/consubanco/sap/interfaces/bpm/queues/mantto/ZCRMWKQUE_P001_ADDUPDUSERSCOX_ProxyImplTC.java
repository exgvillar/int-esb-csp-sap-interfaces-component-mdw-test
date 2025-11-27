/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_WORKINGHOURS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl proxy = new ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl();
        
        ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData data = new ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData();
        data.setBusinessPartner( "0010001950" );
        data.setUserName( "BRASSO" );
        data.setName1( "BALBINA" );
        data.setName2( "MARIA" );
        data.setLastName1( "RASSO" );
        data.setLastName2( "JUAREZ" );
        data.setAreaKey( "1" );
        data.setAreaDesc( "CAPTURA" );
        data.setExperienceLevelKey( "3" );
        data.setExperienceLevelDesc( "EXPERTO" );
        data.setBreakTime( 60 );
        data.setStatusKey( "1" );
        data.setStatusDesc( "ACTIVO" );
        data.setLocationKey( "1" );
        data.setLocationDesc( "COX" );
        data.setUserLastUpdate( "hsanchez" );
        
        ArrayList<ZM_WORKINGHOURS_Model> workingHoursList = new ArrayList<ZM_WORKINGHOURS_Model>();
        ZM_WORKINGHOURS_Model dataHours = new ZM_WORKINGHOURS_Model();
        dataHours.setDayOfWeek("LUNES");
        dataHours.setCheckIn("0700");
        dataHours.setCheckOut("1500");
        workingHoursList.add( dataHours );
        
        dataHours = new ZM_WORKINGHOURS_Model();
        dataHours.setDayOfWeek("MARTES");
        dataHours.setCheckIn("0930");
        dataHours.setCheckOut("1830");
        workingHoursList.add( dataHours );
        
        data.setWorkingHoursList(workingHoursList);
        
        data.setRfcCrmMode("M"); //I (insert)/ M (modify) / B (delete)
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, data );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
