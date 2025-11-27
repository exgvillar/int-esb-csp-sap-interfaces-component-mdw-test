package com.consupago.sap.interfaces.proxy.cdb;

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


public class ZRFC_ORIG_TOTMENS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_ORIG_TOTMENS_ProxyImpl.class );
	
	public ZRFC_ORIG_TOTMENS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_ORIG_TOTMENS" );
			if(ft == null)
				throw new RuntimeException("ZRFC_ORIG_TOTMENS not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				
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
			
						
			ZRFC_ORIG_TOTMENS_OutputData output = new ZRFC_ORIG_TOTMENS_OutputData();
			ArrayList<TE_MESSAGE_OutputData> messages = new ArrayList<TE_MESSAGE_OutputData>();
			
			log.info( "" +  function.getExportParameterList().getStructure("E_TOTCONV").toString() );
			
			output.setCumulativeAmount( function.getExportParameterList().getStructure("E_TOTCONV").getDouble("MONTO") );
			output.setRequestsNumber( function.getExportParameterList().getStructure("E_TOTCONV").getInt("NUM_SOLIC") );
			output.setBrmsConvenio_id( function.getExportParameterList().getStructure("E_TOTCONV").getString("CVEBRMS") );
					
				
			
			TE_MESSAGE_OutputData tableData = new TE_MESSAGE_OutputData();
			
			tableData.setKey( "" );
			tableData.setDescription( function.getExportParameterList().getString("E_MESSAGE")  );
			tableData.setClasification( "" );
			messages.add( tableData );
							
			output.setMessages(messages);
			returnList.add( output );
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_ORIG_TOTMENS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}	
}
