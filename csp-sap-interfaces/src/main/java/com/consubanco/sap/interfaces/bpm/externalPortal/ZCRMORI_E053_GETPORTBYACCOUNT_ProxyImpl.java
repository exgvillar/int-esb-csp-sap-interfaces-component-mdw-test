package com.consubanco.sap.interfaces.bpm.externalPortal;

import java.util.ArrayList;
import java.util.Iterator;

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

public class ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl.class);

	public ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl(){
		super();
	}
	
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_E053_GETPORTBYACCOUNT");
			if (ft == null)
				throw new RuntimeException("ZCRMORI_E053_GETPORTBYACCOUNT not found in SAP.");

			function = ft.getFunction();

			/*
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while (iter.hasNext()) {
				ProxyInputParameter inputParam = iter.next();
				if (StringUtils.trimToNull(inputParam.getType()) == null) {
					function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
				} else {
					if (inputParam.getType().equals("java.util.date"))
						function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getDateValue());
					else
						function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
				}
			}
			*/
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_ACCOUNTID");
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while ( iter.hasNext() ) {
				tableInput.appendRow();
				ProxyInputParameter inputParam = iter.next();
				tableInput.setValue(inputParam.getKey(), inputParam.getValue() );
			}
			
			log.info("inputParams :: "+tableInput.toString());
			function.execute(destination);
			 
			JCoTable table = function.getExportParameterList().getTable("E_PORTBYACC");

			log.info("outputParams ::"+table.toString());
			
			for (int j = 0; j < table.getNumRows(); j++, table.nextRow() ) {
				returnList.add(new ZCRMORI_E053_GETPORTBYACCOUNT_OutputData(
						table.getString("E_ACCOUNTID"), 
						table.getString("E_CONTRATO")) );
			}
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E053_GETPORTBYACCOUNT", e);
			throw e;
		} finally {

		}
		
		log.info("<-- ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl.executeRemoteFunction()");
		
		return (returnList);
	}

}
