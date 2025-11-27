/**
 * 
 */
package com.consupago.sap.interfaces.proxy.incidencias;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_INCIDENCIAS_SOLIC_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_INCIDENCIAS_SOLIC_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_INCIDENCIAS_SOLIC_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_INCIDENCIAS_SOLIC_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_INCIDENCIAS_SOLIC_ProxyImpl proxy = new ZRFC_INCIDENCIAS_SOLIC_ProxyImpl();
        
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CVEINC");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_TIPOINC");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESCINC");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_INCREP");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
               
        
        inputParams.getRecordParam().add( recordParams1 );
        
        // Second table for incidents recording
        ProxyInputParameterWithTable inputParams2 = new ProxyInputParameterWithTable();
        inputParams2.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams2 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_CVEINC");
        inputRecord2.setValue( "" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_DESCINC");
        inputRecord2.setValue( "" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_ESTAT");
        inputRecord2.setValue( "" );
        recordParams2.add( inputRecord2 );
        
               
        
        inputParams2.getRecordParam().add( recordParams2 );
        
        ArrayList<ProxyInputParameter> _inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ACCION");
        input.setValue( "U" );
        _inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CVECASO");
        input.setValue( StringUtils.trim( "" ) );
        _inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CVESOL");
        input.setValue( StringUtils.trim( "" ) );
        _inputParams.add( input );
        
//        Long inicio = System.currentTimeMillis();
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, _inputParams, inputParams, inputParams2 );
        
//        Long fin = System.currentTimeMillis();
        System.out.println("returnData: " + returnData.toString() );

	}
}
