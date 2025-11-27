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

public class ZRFC_GRP_PLAZOS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_GRP_PLAZOS_ProxyImpl.class );
	
	public ZRFC_GRP_PLAZOS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_GRP_PLAZOS");
			if(ft == null)
	            throw new RuntimeException("ZRFC_GRP_PLAZOS not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("T_PRICE");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_GRP_PLAZOS_OutputData output = new ZRFC_GRP_PLAZOS_OutputData();
				
				output.setPriceGroup( data.getString("PRICE_GROUP") );
				output.setDescription( data.getString("DESCRIPTION") );
				
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_GRP_PLAZOS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
