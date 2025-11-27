package com.consubanco.sap.interfaces.origmovil;

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

public class ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImpl.class );
	
	public ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMMOV_E006_GET_SUPCALLCENTER" );
			if(ft == null)
				throw new RuntimeException("ZCRMMOV_E006_GET_SUPCALLCENTER not found in SAP.");
			
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
			
			log.info( "Input Parameters List :: " +  function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("ET_SUPCALLCEN");
			
			log.info( "Return Table :: " +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMMOV_E006_GET_SUPCALLCENTER_OutputData tableData = new ZCRMMOV_E006_GET_SUPCALLCENTER_OutputData();
				tableData.setFechaInicio( data.getDate("BEGDA") );
				tableData.setFechaFin( data.getDate("ENDDA") );
				tableData.setBpId( data.getString("SHORT") );
				tableData.setNombre( data.getString("STEXT") );
				
				
				returnList.add( tableData );
			}
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMMOV_E006_GET_SUPCALLCENTER" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
