package com.consupago.sap.interfaces.proxy.cm;

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
@Deprecated
public class ZCRM_BP_TOTAL_SEGURO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRM_BP_TOTAL_SEGURO_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRM_BP_TOTAL_SEGURO";
	
	public ZCRM_BP_TOTAL_SEGURO_ProxyImpl() {
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
			
			JCoTable data = function.getTableParameterList().getTable("TE_BPSEGURO");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRM_BP_TOTAL_SEGURO_OutputData tableData = new ZCRM_BP_TOTAL_SEGURO_OutputData();
				
				tableData.setNumeroSolicitudesConSeguro( data.getInt("SOLC_SEGURO") );
				tableData.setMontoSolicitudesConSeguro( data.getDouble("DISPERSADO_SEG") );
				tableData.setNumeroSolicitudesCompradas( data.getInt("SOLC_COMPRADAS") );
				tableData.setMontoSolicitudesCompradas( data.getDouble("DISPERSADO_COM") );
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
