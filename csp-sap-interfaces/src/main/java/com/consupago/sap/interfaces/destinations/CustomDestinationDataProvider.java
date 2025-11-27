package com.consupago.sap.interfaces.destinations;


import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class CustomDestinationDataProvider {
	private static CustomDestinationDataProvider singleton = null;
	private static Log log = LogFactory.getLog( CRMLocalConfigEnvironmentData.class );

	
	static class MyDestinationDataProvider implements DestinationDataProvider {

		private DestinationDataEventListener eL;
		private Hashtable<String, Properties> propertiesTab = new Hashtable<String, Properties>();

		public Properties getDestinationProperties(String destinationName) {
			if (propertiesTab.containsKey(destinationName)) {
				return propertiesTab.get(destinationName);
			}
			return null;
		}

		public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
			this.eL = eventListener;
		}

		public boolean supportsEvents() {
			return true;
		}

		void changePropertiesForABAP_AS(Properties pConProps) {
			if (pConProps.getProperty("ACTION").equalsIgnoreCase("CREATE")) {
				propertiesTab.put(pConProps.getProperty("jco.client.dest"),pConProps);
				eL.updated(pConProps.getProperty("jco.client.dest"));
			} else if (pConProps.getProperty("ACTION").equalsIgnoreCase("DELETE")) {
				propertiesTab.remove(pConProps.getProperty("jco.client.dest"));
				eL.deleted(pConProps.getProperty("jco.client.dest"));
			}
		}
	}
	
	private CustomDestinationDataProvider(){}

	public static CustomDestinationDataProvider instance() {
		log.info("Creation of DestinationDataProvider");
		MyDestinationDataProvider myProvider = new MyDestinationDataProvider();
		if ( !com.sap.conn.jco.ext.Environment.isDestinationDataProviderRegistered() ){
			com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(myProvider);
			myProvider.changePropertiesForABAP_AS(CustomDestinationDataProvider.createProps("sap-erp.config", "CSPSAPERP"));
			myProvider.changePropertiesForABAP_AS(CustomDestinationDataProvider.createProps("sap-crm.config", "CSPSAPCRM"));
		}
		if (singleton == null){
			singleton = new CustomDestinationDataProvider();
		}
		log.info("singleton " + singleton);
		return singleton; 
 
	}

	private static Properties createProps(String fileName, String sapId){
		Properties connectProperties = new Properties();
		Properties properties = new Properties();
		InputStream inStream = ClassLoader.getSystemResourceAsStream( fileName );
		if( inStream == null ) inStream = MyDestinationDataProvider.class.getClassLoader().getResourceAsStream( fileName );
		try {
			if( inStream != null ) properties.load( inStream );
			connectProperties.setProperty("ACTION", "CREATE");
			connectProperties.setProperty(DestinationDataProvider.JCO_DEST, sapId.toUpperCase().trim());
	        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, properties.getProperty("jco.client.ashost") );
	        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  properties.getProperty("jco.client.sysnr"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, properties.getProperty("jco.client.client"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_USER,   properties.getProperty("jco.client.user"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, properties.getProperty("jco.client.passwd"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   properties.getProperty("jco.client.lang"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, properties.getProperty("jco.destination.pool_capacity"));
	        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,    properties.getProperty("jco.destination.peak_limit"));
		} catch( IOException ex ) {
			ex.printStackTrace();
			return null;
		}
		return connectProperties;
	}
	
	
	public static void main(String[] args) throws Exception {
		CustomDestinationDataProvider prov = CustomDestinationDataProvider.instance();
//		System.out.println("prov " +  prov.instance().toString());
		JCoDestination ABAP_AS_EN = JCoDestinationManager.getDestination("CSPSAPERP");
		System.out.println(ABAP_AS_EN.getAttributes());
		ABAP_AS_EN.ping();

		JCoDestination ABAP_AS_DE = JCoDestinationManager.getDestination("CSPSAPCRM");
		System.out.println(ABAP_AS_DE.getAttributes());
		ABAP_AS_DE.ping();

		System.out.println(ABAP_AS_EN.getDestinationName()+ " destination is ok");
		System.out.println(ABAP_AS_DE.getDestinationName()+ " destination is ok");

	}
}
