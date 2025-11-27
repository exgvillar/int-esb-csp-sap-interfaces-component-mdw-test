package com.consubanco.sap.interfaces.dispersion;

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

public class ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl.class );
	
	public ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMTESO_GET_IND_DISPAUTO" );
			if(ft == null)
				throw new RuntimeException("ZCRMTESO_GET_IND_DISPAUTO not found in SAP.");
			
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
			
//			log.info( "Request Function :: " +  function.getImportParameterList().toString() );
			
			function.execute(destination);
						
			ZCRMTESO_GET_IND_DISPAUTO_OutputData tableData = new ZCRMTESO_GET_IND_DISPAUTO_OutputData();
			
			tableData.setDispersionOnlineOpen( function.getExportParameterList().getString("E_INDICADOR").equals("X") ? true : false );
			tableData.setFechaActualizacion( function.getExportParameterList().getDate("E_FECHA") );
			
			returnList.add( tableData );	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMTESO_GET_IND_DISPAUTO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
