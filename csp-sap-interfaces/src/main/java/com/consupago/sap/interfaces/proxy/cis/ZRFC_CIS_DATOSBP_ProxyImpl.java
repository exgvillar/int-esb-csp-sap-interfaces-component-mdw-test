package com.consupago.sap.interfaces.proxy.cis;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZRFC_CIS_DATOSBP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CIS_DATOSBP_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_CIS_DATOSBP";
	
	public ZRFC_CIS_DATOSBP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_CIS_DATOSBP_OutputData output = new ZRFC_CIS_DATOSBP_OutputData();
				output.setBusinessPartnerId( data.getString("BPID") );
				output.setNombre1( data.getString("NOMBRE1") );
				output.setNombre2( data.getString("NOMBRE2") );
				output.setApellidoPaterno( data.getString("APELLIDOPATERNO") );
				output.setApellidoMaterno( data.getString("APELLIDOMATERNO") );
				output.setRfc( data.getString("RFC") );
				output.setTelefonoCasa( data.getString("TELEFONOCASA") );
				output.setTelefonoDomicilio( data.getString("TELEFONODOMICIOLIO") );
				output.setEmail( data.getString("EMAIL") );
				
				ArrayList<ZRFC_CIS_DATOS_ADDRESS_BP_OutputData> addressList = new ArrayList<ZRFC_CIS_DATOS_ADDRESS_BP_OutputData>();
				JCoTable addressData = data.getTable("DOMICILIOS");
				log.info( "" +  addressData.toString() );
				for (int j = 0; j < addressData.getNumRows(); j++, addressData.nextRow() ) {
					ZRFC_CIS_DATOS_ADDRESS_BP_OutputData outputAddress = new ZRFC_CIS_DATOS_ADDRESS_BP_OutputData();
					outputAddress.setTipoDireccion( addressData.getString("TIPODIRECCION"));
					outputAddress.setCalle( addressData.getString("DIRECCION") );
					outputAddress.setNumeroExterior( addressData.getString("NUMEROEXTERIOR") ) ;
					outputAddress.setNumeroInterior( addressData.getString("NUMEROINTERIOR") );
					outputAddress.setColonia( addressData.getString("COLONIA") );
					outputAddress.setDelegacionMunicipio( addressData.getString("DELEGACIONMUNICIPIO") );
					outputAddress.setCiudad( addressData.getString("CIUDAD") );
					outputAddress.setEstado( addressData.getString("ESTADO") );
					outputAddress.setCp( addressData.getString("CP") );
					
					addressList.add( outputAddress );
				}
				output.setAddressList(addressList);
				returnList.add( output );
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
