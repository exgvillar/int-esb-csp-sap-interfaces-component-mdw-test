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

public class ZRFC_DATOS_BP_X_NUM_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_DATOS_BP_X_NUM_ProxyImpl.class );
	
	public ZRFC_DATOS_BP_X_NUM_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_DATOS_BP_X_NUM");
			if(ft == null)
	            throw new RuntimeException("ZRFC_DATOS_BP_X_NUM not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			
		
			
			JCoTable data = function.getTableParameterList().getTable("IT_DATOSBP");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				
				ZRFC_DATOS_BP_OutputData output = new ZRFC_DATOS_BP_OutputData();
				
				output.setBusinessPartnerId( data.getString("PARTNER") );
				output.setFirstName( data.getString("NAME_FIRST") );
				output.setSecondName( data.getString("NAMEMIDDLE") );
				output.setLastName( data.getString("NAME_LAST") );
				output.setMaidenName( data.getString("NAME_LST2") );
				output.setBirthDate( data.getDate("BIRTHDT") );
				output.setRfc( data.getString("IDNUMBER") );
				output.setCurp( data.getString("IDNUMBER1") );
				output.setIfe( data.getString("IDNUMBER2") );
				output.setText( data.getString("TEXT") );
				
				returnList.add( output );
			}	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_DATOS_BP_X_NUM" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
