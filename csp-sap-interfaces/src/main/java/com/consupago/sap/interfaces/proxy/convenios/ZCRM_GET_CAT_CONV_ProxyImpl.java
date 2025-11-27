package com.consupago.sap.interfaces.proxy.convenios;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
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

public class ZCRM_GET_CAT_CONV_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRM_GET_CAT_CONV_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRM_GET_CAT_CONV";
	
	public ZCRM_GET_CAT_CONV_ProxyImpl() {
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
//				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			
			function.execute(destination);
			
			
			JCoTable returnTable = function.getTableParameterList().getTable("CAT_CONVEMP_EDO");
			
			log.info( "" +  returnTable.toString() );
			for (int i = 0; i < returnTable.getNumRows(); i++, returnTable.nextRow() ) {
				ZCRM_GET_CAT_CONV_OutputData tableData = new ZCRM_GET_CAT_CONV_OutputData();
				
				tableData.setConvenioId( returnTable.getString("ID_CONVENIO") );
				tableData.setConvenioDescription( returnTable.getString("DESC_CONVENIO") );
				tableData.setFinancialProductId( returnTable.getString("ID_PRODFI") );
				tableData.setFinancialProductDescription( returnTable.getString("DESC_PRODFI") );
				tableData.setFrecuencyFinancialProduct( returnTable.getString("FREC_PRODFI") );
				tableData.setPlazoMaximoFinancialProduct( returnTable.getInt("PZO_MAX") );
				tableData.setPlazoMinimoFinancialProduct( returnTable.getInt("PZO_MIN") );
				tableData.setMontoMaximoFinancialProduct( returnTable.getDouble("MONTO_MAX") );
				tableData.setMontoMinimoFinancialProduct( returnTable.getDouble("MONTO_MIN") );
				returnList.add( tableData );				
			}
			
						
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
