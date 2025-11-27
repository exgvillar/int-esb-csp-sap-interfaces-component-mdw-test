/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.spei;

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

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl implements
		IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl.class);

	public ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(
			JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		log.info("--> ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl.executeRemoteFunction()");

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMUTL_P001_CHG_COMP_A_SPEIDE");
			if (ft == null)
				throw new RuntimeException("ZCRMUTL_P001_CHG_COMP_A_SPEIDE not found in SAP.");

			function = ft.getFunction();

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

			function.execute(destination);

			String success = function.getExportParameterList().getString("E_OK");

			ZCRMUTL_P001_CHG_COMP_A_SPEIDE_OutputData data = new ZCRMUTL_P001_CHG_COMP_A_SPEIDE_OutputData();

			if ("X".equalsIgnoreCase(success)) {

				data.setSuccess(true);

				JCoTable table = function.getExportParameterList().getTable("ET_SALIDA");
				
				log.info("ET_SALIDA: " + table.toString());
				
				for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
					data.setAccountId(table.getString("ACCOUNT_ID"));
					data.setStatusId(table.getString("STAT_ANT"));
					data.setStatusDesc(table.getString("DESC_STAT"));
				}
			} else {
				data.setSuccess(false);
				data.setMessage(function.getExportParameterList().getString( "E_MESSAGE") );
			}

			log.info(function.toString());

			returnList.add(data);

		} catch (AbapException e) {
			log.error(
					" executing function " + "ZCRMUTL_P001_CHG_COMP_A_SPEIDE",
					e);
			throw e;
		} finally {

		}

		log.info("<-- ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl.executeRemoteFunction()");

		return (returnList);
	}

}
