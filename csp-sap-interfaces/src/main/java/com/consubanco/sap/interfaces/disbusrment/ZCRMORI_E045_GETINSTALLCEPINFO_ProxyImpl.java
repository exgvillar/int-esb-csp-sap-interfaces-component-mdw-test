package com.consubanco.sap.interfaces.disbusrment;

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
import com.sap.conn.jco.JCoStructure;

/**
 * @author hsanchez
 *
 */
public class ZCRMORI_E045_GETINSTALLCEPINFO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E045_GETINSTALLCEPINFO_ProxyImpl.class );
	
	public ZCRMORI_E045_GETINSTALLCEPINFO_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E045_GETINSTALLCEPINFO" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E045_GETINSTALLCEPINFO not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);			
			log.info("Function.Export: " + function.getExportParameterList().toString() );			
			
			ZCRMORI_E045_GETINSTALLCEPINFO_OutputData data = new ZCRMORI_E045_GETINSTALLCEPINFO_OutputData();
			data.setApplyInstallCEP( function.getExportParameterList().getString("E_APPLYINSTALLCEP").equals("X") ? true : false );
			data.setConvenioId( function.getExportParameterList().getString("E_CONVENIOID") );
			data.setConvenioDesc( function.getExportParameterList().getString("E_CONVENIODESC") );
			
			JCoStructure clienteStr = function.getExportParameterList().getStructure("E_CLIENTE");
			data.setBp( clienteStr.getString("BP") );
			data.setRfc( clienteStr.getString("RFC") );
			data.setCurp( clienteStr.getString("CURP") );
			data.setName1( clienteStr.getString("NAME1") );
			data.setName2( clienteStr.getString("NAME2") );
			data.setLastName1( clienteStr.getString("LASTNAME1") );
			data.setLastName2( clienteStr.getString("LASTNAME2") );
			data.setNss( clienteStr.getString("CUSTOMERNSS") );
			
			data.setFolioCartaInstruccion( function.getExportParameterList().getString("E_FOLIOCARTAINSTRUCCION") );
			
			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E045_GETINSTALLCEPINFO :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
