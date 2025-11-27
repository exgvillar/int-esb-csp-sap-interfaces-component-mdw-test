package com.consubanco.sap.interfaces.massiveLoad;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMORIG_P003_DELETE_OPP_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORIG_P003_DELETE_OPP_ProxyImpl.class );
	
	
	public ZCRMORIG_P003_DELETE_OPP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORIG_P003_DELETE_OPP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORIG_P003_DELETE_OPP not found in SAP.");
			
			function = ft.getFunction();
			
		
			// general params
			Iterator<ProxyInputParameter> iterGeneralParams = inputParamters.getGeneralParam().iterator();
			while( iterGeneralParams.hasNext() ) {
				ProxyInputParameter inputParam = iterGeneralParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					}	
				
			}
			
			
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("IT_OPORTUNIDADES");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ArrayList<ProxyInputParameter>  recordParams = (ArrayList<ProxyInputParameter>)iterRecord.next();
				Iterator<ProxyInputParameter> iterRecordParams = recordParams.iterator();
				while( iterRecordParams.hasNext() ) {
					ProxyInputParameter inputParam = iterRecordParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}						
				}
			}
			

			function.execute(destination);
			
			log.info( "" +  function.getExportParameterList().toString() );
			ZCRMORIG_P003_DELETE_OPP_OutputData data = new ZCRMORIG_P003_DELETE_OPP_OutputData();
			data.setSuccess( function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false );
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORIG_P003_DELETE_OPP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
