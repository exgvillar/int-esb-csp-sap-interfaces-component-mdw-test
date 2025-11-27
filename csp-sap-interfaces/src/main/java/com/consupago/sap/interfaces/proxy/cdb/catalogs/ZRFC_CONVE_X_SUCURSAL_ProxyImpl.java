package com.consupago.sap.interfaces.proxy.cdb.catalogs;

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

public class ZRFC_CONVE_X_SUCURSAL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CONVE_X_SUCURSAL_ProxyImpl.class );
	
	public ZRFC_CONVE_X_SUCURSAL_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_CONVE_X_SUCURSAL");
			if(ft == null)
	            throw new RuntimeException("ZRFC_CONVE_X_SUCURSAL not found in SAP.");
			
			function = ft.getFunction();
	
			// TODO Change to uppercase
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("IT_CATA_CONVENIO");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_CONVE_X_SUCURSAL_OutputData output = new ZRFC_CONVE_X_SUCURSAL_OutputData();
				output.setConvenioId( data.getString("CONVENIO") );
				output.setConvenioShortText( data.getString("C_TXT_CORTO") );
				output.setIdOrgVentas( data.getString("ORG_VENTAS") );
				output.setOrgVentasShortText( data.getString("O_TXT_CORTO") );
				
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_CONVE_X_SUCURSAL" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
