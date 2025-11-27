package com.consubanco.sap.interfaces.commons;

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

public class ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl.class );
	
	public ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMMCTC_E005_CONSULTA_MOTIVOS" );
			if(ft == null)
				throw new RuntimeException("ZCRMMCTC_E005_CONSULTA_MOTIVOS not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("ET_MOTIVOS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMMCTC_E005_CONSULTA_MOTIVOS_OutputData tableData = new ZCRMMCTC_E005_CONSULTA_MOTIVOS_OutputData();
				
				tableData.setKey( data.getString("IDMOTI") );
				tableData.setDescription( data.getString("DESCRI") );
				tableData.setReprocessable( data.getString("INDREP").equals("X") ? true : false );
				
				returnList.add( tableData );
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMMCTC_E005_CONSULTA_MOTIVOS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
