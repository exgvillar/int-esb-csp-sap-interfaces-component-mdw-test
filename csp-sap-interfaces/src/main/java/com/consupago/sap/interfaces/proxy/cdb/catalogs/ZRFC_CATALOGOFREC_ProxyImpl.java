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

public class ZRFC_CATALOGOFREC_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CATALOGOFREC_ProxyImpl.class );
	
	public ZRFC_CATALOGOFREC_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_CATALOGOFREC");
			if(ft == null)
	            throw new RuntimeException("ZRFC_CATALOGOFREC not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("PT_PERIODOS");
		
			ZRFC_CATALOGOFREC_OutputData output = new ZRFC_CATALOGOFREC_OutputData();
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				
				output.setPeriodsTermFrom( data.getInt("TERMFROM") );
				output.setPeriodsTermTo( data.getInt("TERMTO") );
				output.setPeriodsTimeUnit( data.getString("TIMEUNIT") );
				output.setPeriodsDefTerm( data.getString("DEFTERM") );
				
			}
			
			data = function.getTableParameterList().getTable("PT_PERIODICIDAD");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				
				output.setPayFrequencyCode( data.getString("PAYFREQU") );
				output.setPayFrequencyDescription( data.getString("TEXT") );
				
			}
			
			data = function.getTableParameterList().getTable("PT_MONTOS");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				
				output.setMontoMinimo( data.getDouble("ZZ0010") );
				output.setMontoMaximo( data.getDouble("ZZ0011") );
				
			}
			
			returnList.add( output );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_CATALOGOFREC" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
