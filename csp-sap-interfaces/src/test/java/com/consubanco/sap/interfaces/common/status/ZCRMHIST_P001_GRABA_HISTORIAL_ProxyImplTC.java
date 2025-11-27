/**
 * 
 */
package com.consubanco.sap.interfaces.common.status;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author jcontreras
 *
 */
public class ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl proxy = new ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
      
		Date curDate = new Date();
		String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ES", "MX")).format(curDate);
		String time =  new SimpleDateFormat("HH:mm:ss", new Locale("ES", "MX")).format(curDate);

		ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("MAN");
//        inputRecord.setValue( "" );
//        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("OBJECT_ID");
        inputRecord.setValue( "0050069010" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("UDATE");
        inputRecord.setValue(fecha);
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("UTIME");
        inputRecord.setValue( time );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("USERNAME");
        inputRecord.setValue( "ESBCOMM" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("INDTEXT");
        inputRecord.setValue( "CAMBIO ESTATUS" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("F_OLD"); 
        inputRecord.setValue( "Autorizada Proceso de Comp" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("F_NEW");
        inputRecord.setValue( "En proceso dispersion Comp" );
        recordParams1.add( inputRecord );
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("USER_CSB");
//        inputRecord.setValue( "" );
//        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("PARTNER");
        inputRecord.setValue( "ESBCOMM" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );
        


        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
