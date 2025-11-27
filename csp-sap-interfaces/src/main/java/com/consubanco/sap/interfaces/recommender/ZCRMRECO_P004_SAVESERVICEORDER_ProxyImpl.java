package com.consubanco.sap.interfaces.recommender;

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

public class ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl.class );
	
	public ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_P004_SAVESERVICEORDER" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_P004_SAVESERVICEORDER not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_P004_SAVESERVICEORDER_OutputData data = new ZCRMRECO_P004_SAVESERVICEORDER_OutputData();
			data.setIdOrdenServicio( function.getExportParameterList().getString("E_ID_ORDEN_SERVICIO") );
			data.setExito( "X".equalsIgnoreCase( function.getExportParameterList().getString( "E_EXITO" ) ));
			data.setMensaje(function.getExportParameterList().getString("E_MENSAJE"));
						
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_P004_SAVESERVICEORDER :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
