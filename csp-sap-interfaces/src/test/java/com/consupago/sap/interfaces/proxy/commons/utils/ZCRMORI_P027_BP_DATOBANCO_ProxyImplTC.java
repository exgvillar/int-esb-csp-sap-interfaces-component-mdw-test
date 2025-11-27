/**
 * 
 */
package com.consupago.sap.interfaces.proxy.commons.utils;

import java.util.ArrayList;

import javax.swing.Box.Filler;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.common.utils.ZCRMORI_P027_BP_DATOBANCO_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMORI_P027_BP_DATOBANCO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P027_BP_DATOBANCO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P027_BP_DATOBANCO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P027_BP_DATOBANCO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P027_BP_DATOBANCO_ProxyImpl proxy = new ZCRMORI_P027_BP_DATOBANCO_ProxyImpl();
        
        ArrayList<String> arrBpInfo = new ArrayList<String>();

//        arrBpInfo.add("0003779865|014|014312605707380979");
        
        for (String informaicon : arrBpInfo) {
			String[] infoBP = informaicon.split("\\|") ;
	        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
	        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
	        inputParams.setRecordParam( new ArrayList<Object>() );
	        // general Params
	        ProxyInputParameter input = new ProxyInputParameter();
	        input.setKey("I_BP");
	        input.setValue( infoBP[0] );
	        inputParams.getGeneralParam().add( input );
	        // tableParams - record1
	        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
	        ProxyInputParameter inputRecord = new ProxyInputParameter();
	        inputRecord = new ProxyInputParameter();
	        inputRecord.setKey("CLAVE_BANCO");
	        inputRecord.setValue( infoBP[1] );
	        recordParams1.add( inputRecord );
	        inputRecord = new ProxyInputParameter();
	        inputRecord.setKey("CUENTA_BANCARIA");
	        inputRecord.setValue( infoBP[2] );
	        recordParams1.add( inputRecord );
	        inputParams.getRecordParam().add( recordParams1 );
	        proxy.executeRemoteFunction(destination, inputParams );
		}
        
//        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
//        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
//        inputParams.setRecordParam( new ArrayList<Object>() );
//        // general Params
//        ProxyInputParameter input = new ProxyInputParameter();
//        input.setKey("I_BP");
//        input.setValue( "0003779729" );
//        inputParams.getGeneralParam().add( input );
//        // tableParams - record1
//        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
//        ProxyInputParameter inputRecord = new ProxyInputParameter();
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("CLAVE_BANCO");
//        inputRecord.setValue( "002" );
//        recordParams1.add( inputRecord );
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("CUENTA_BANCARIA");
//        inputRecord.setValue( "002180902657481894" );
//        recordParams1.add( inputRecord );
//        inputParams.getRecordParam().add( recordParams1 );
//        proxy.executeRemoteFunction(destination, inputParams );
	}
}
