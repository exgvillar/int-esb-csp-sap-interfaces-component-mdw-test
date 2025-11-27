package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class ZCRMORI_E001_CATGENER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E001_CATGENER_ProxyImpl.class );
	private List<String> removeThis;
	
	public ZCRMORI_E001_CATGENER_ProxyImpl() {
		super();
		removeThis = getRemoveElementsXCatalog();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;


		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E001_CATGENER" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E001_CATGENER not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("T_CATGEN");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E001_CATGENER_OutputData tableData = new ZCRMORI_E001_CATGENER_OutputData();
				
				tableData.setKey( data.getString("IDKEY") );
				tableData.setDescription( data.getString("DESCRIPTION") );

				if( ! removeElement( data.getString("IDKEY") ) )
					returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E001_CATGENER" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	private boolean removeElement(String element) {
		return removeThis.contains(element);
	}

	private List<String> getRemoveElementsXCatalog(){
		if(removeThis == null){
			removeThis = new ArrayList<String>();
			
			removeThis.add("0019000020");
			removeThis.add("TL");
			removeThis.add("001");
			removeThis.add("NP");
			removeThis.add("EU");
			removeThis.add("FT");
			removeThis.add("NN");
			
		}
		
		return removeThis;
	}

	
}
