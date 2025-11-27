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

public class ZCRMORI_E004_BUSCACP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E004_BUSCACP_ProxyImpl.class );
	
	public ZCRMORI_E004_BUSCACP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E004_BUSCACP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E004_BUSCACP not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("T_CODPOS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E004_BUSCACP_OutputData tableData = new ZCRMORI_E004_BUSCACP_OutputData();
				
				tableData.setZipCode( data.getString("CODPOS") );
				tableData.setSuburb( data.getString("ASENTAMIENTO") );
				tableData.setSettlementTypeId( data.getString("CVE_TIPOASEN") );
				tableData.setSettlementTypeDesc( data.getString("TIPO_ASENTAM") );
				tableData.setTownshipId( data.getString("CVE_MUNICIPIO") );
				tableData.setTownshipDesc( data.getString("MUNICIPIO") );
				tableData.setStateId( data.getString("CVE_ESTADO") );
				tableData.setStateDesc( data.getString("ESTADO") );
				tableData.setCityId( data.getString("CVE_CIUDAD") );
				tableData.setCityDesc( data.getString("CIUDAD") );
				tableData.setOffice( data.getString("CVE_OFICINA") );
				tableData.setZone( data.getString("DESC_ZONA") ); 
				tableData.setStateCRM( data.getString("EDOSAP") ); 
									
				returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E004_BUSCACP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
