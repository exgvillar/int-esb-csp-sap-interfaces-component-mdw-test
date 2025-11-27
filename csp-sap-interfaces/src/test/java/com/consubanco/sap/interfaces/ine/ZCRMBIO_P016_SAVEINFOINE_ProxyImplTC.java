package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consubanco.sap.interfaces.ine.model.ZMSaveInfoINERequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

import junit.framework.TestCase;

public class ZCRMBIO_P016_SAVEINFOINE_ProxyImplTC extends TestCase{
	
	private static Log log = LogFactory.getLog( ZCRMBIO_P016_SAVEINFOINE_ProxyImplTC.class );
	private JCoDestination destination;
	@Override
	protected void setUp() throws Exception {
		CRMLocalConfigEnvironmentData.instance();        
		destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		destination = null;
		super.tearDown();
	}
	
	public void testSuccess() {
			ZMSaveInfoINERequest request = new ZMSaveInfoINERequest();
			request.setCustomerBp("1192");
			
			ZMInfoINE infoINE = new ZMInfoINE();
			infoINE.setVoterId("3453JD534535KAKA3242");
			infoINE.setStateId("DF");
			infoINE.setRegistrationYear("2009");
			infoINE.setIssueNumber("02");
			infoINE.setIssueYear("2009");
			infoINE.setValidityYear("2029");
			infoINE.setCic("25345345343");
			infoINE.setOcr("345345432");
			infoINE.setMechanicalReading("PRUEBA");
			infoINE.setPortalCode("PDI");
			infoINE.setCity("CDMX");
			infoINE.setCurp("ADAS0890E809EDD11");
			
			ZMFile file = new ZMFile();
			file.setName("INE_AMBERSO"); //Enviar INE_AMBERSO o INE_REVERSO
			file.setBase64("SG9sYSwgc295IHVuIHRleHRvIGNvZGlmaWNhZG8=");
			
			List<ZMFile> files = new LinkedList<ZMFile>();
			files.add(file);
			
			infoINE.setFiles(files);
			
			request.setInfoINE(infoINE);
			executeOperation(request, "Success Scenery");
	}
	
	private void executeOperation(ZMSaveInfoINERequest request, String message){    
        JCoDestination destination;
		try {
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	        ZCRMBIO_P016_SAVEINFOINE_ProxyImpl proxy = new ZCRMBIO_P016_SAVEINFOINE_ProxyImpl();
	        ArrayList<IProxyOutputData> outputDataList = proxy.executeRemoteFunction(destination, request );

	        assertTrue(message, !outputDataList.isEmpty());
	        
	        ZCRMBIO_P016_SAVEINFOINE_OutputData outputData = (ZCRMBIO_P016_SAVEINFOINE_OutputData) outputDataList.get(0);
	        assertTrue(message, outputData.isSuccess());
		} catch (JCoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
