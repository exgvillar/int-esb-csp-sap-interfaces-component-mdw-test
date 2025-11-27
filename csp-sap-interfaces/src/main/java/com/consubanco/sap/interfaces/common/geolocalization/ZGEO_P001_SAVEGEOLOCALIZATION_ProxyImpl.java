package com.consubanco.sap.interfaces.common.geolocalization;

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

public class ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl.class );
	
	public ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZGEO_P001_SAVEGEOLOCALIZATION" );
			if(ft == null)
				throw new RuntimeException("ZGEO_P001_SAVEGEOLOCALIZATION not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			log.info("InputParams :: "+function.getImportParameterList().toString());
			function.execute(destination);
			log.info("OutputParams :: "+function.getExportParameterList().toString());
			
			ZGEO_P001_SAVEGEOLOCALIZATION_OutputData tableData = new ZGEO_P001_SAVEGEOLOCALIZATION_OutputData();
			tableData.setId( function.getExportParameterList().getLong("E_ID") );
			tableData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( tableData );	
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZGEO_P001_SAVEGEOLOCALIZATION" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
