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

public class ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl.class );
	
	
	public ZCRMORI_E006_BUSCATTRMKTG_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E006_BUSCATTRMKTG" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E006_BUSCATTRMKTG not found in SAP.");
			
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

			JCoTable data = function.getExportParameterList().getTable("E_ATTMKTG");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E006_BUSCATTRMKTG_OutputData tableData = new ZCRMORI_E006_BUSCATTRMKTG_OutputData();
				
				tableData.setBpId( data.getString("PARTNER") );
				tableData.setAttributeMktGroupId( data.getString("GRUPO_ATRIBUTOS") );
				tableData.setAttributeMktGroupDesc( data.getString("DESCR_GRUPOATT") );
				tableData.setAttributeMktId( data.getString("CLAVE_ATRIBUTO") );
				if( data.getString("VALOR_ATRIBUTO").equalsIgnoreCase("SI") )
					tableData.setValueAttributeMkt( Boolean.TRUE.toString() );
				else if( data.getString("VALOR_ATRIBUTO").equalsIgnoreCase("NO") )
					tableData.setValueAttributeMkt( Boolean.FALSE.toString() );
				else
					tableData.setValueAttributeMkt( data.getString("VALOR_ATRIBUTO") );
				tableData.setAttributeMktDesc( data.getString("DESCR_ATRIBUTO") );
				
				returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E006_BUSCATTRMKTG" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
