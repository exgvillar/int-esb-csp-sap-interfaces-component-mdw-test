/**
 * 
 */
package com.consubanco.sap.interfaces.spei7x24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.spei7x24.model.ET_INFOBI_Model;
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
public class ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl.class);

	/**
	 * 
	 */
	public ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList)
			throws Exception {
		log.info("--> ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl.executeRemoteFunction()");

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMSPEI_E001_GET_INFOBI_BYTEL");
			if (ft == null)
				throw new RuntimeException("ZCRMAUTOII_P001_UPDATE_KOSMO not found in SAP.");

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

			String exito = function.getExportParameterList().getString("E_OK");

			ZCRMSPEI_E001_GET_INFOBI_BYTEL_OutputData data = new ZCRMSPEI_E001_GET_INFOBI_BYTEL_OutputData();

			if ("x".equalsIgnoreCase(exito)) {
				data.setExito(true);

				List<ET_INFOBI_Model> details = new ArrayList<ET_INFOBI_Model>();
				ET_INFOBI_Model model = null;

				JCoTable table = function.getExportParameterList().getTable("ET_INFOBI");
				log.info(table.toString());

				for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
					model = new ET_INFOBI_Model();

					model.setClabe(table.getString("CLABE"));
					model.setClient(table.getString("CLIENTE"));
					model.setCuenta(table.getString("CUENTA"));
					model.setDescstatus(table.getString("DESCST"));
					model.setiBase(table.getString("IBASE"));
					model.setRfc(table.getString("RFC"));
					model.setSolici(table.getString("SOLICI"));
					model.setStatus(table.getString("ESTATS"));

					details.add(model);
				}
				data.setDetails(details);

			} else {
				data.setExito(false);
				data.setMessage(function.getExportParameterList().getString("E_MESSAGE"));
			}

			log.info(function.toString());

			returnList.add(data);

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMSPEI_E001_GET_INFOBI_BYTEL", e);
			throw e;
		} finally {

		}

		log.info("<-- ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl.executeRemoteFunction()");

		return (returnList);
	}

}
