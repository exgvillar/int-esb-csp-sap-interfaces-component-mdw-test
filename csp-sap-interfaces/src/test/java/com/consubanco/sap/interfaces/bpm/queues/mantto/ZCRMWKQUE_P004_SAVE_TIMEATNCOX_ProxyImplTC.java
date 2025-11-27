/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl proxy = new ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl();
        
        ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData inputParams = new ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData();
        inputParams.setBusinessPartner( "0010000061" ); 
        
        ArrayList<String> convenioIdList = new ArrayList<String>();
        convenioIdList.add( "10000027" );
        convenioIdList.add( "10000050" );
        inputParams.setConvenioIdList( convenioIdList );//
        
        inputParams.setProductCategoryId( "LCOM" );//
        inputParams.setAttentionTime( 20 );//
        inputParams.setUser( "hsanchez" );//
        inputParams.setSourceChannelId("Z01"); //Z01
        inputParams.setDelete( false );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
