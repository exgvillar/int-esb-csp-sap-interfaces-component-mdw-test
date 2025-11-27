package com.consubanco.sap.interfaces.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl.class);

	public ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl() {

	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P002_GETBP_FROM_FP");
			if (ft == null)
				throw new RuntimeException("ZCRMCSB_P002_GETBP_FROM_FP not found in SAP.");

			function = ft.getFunction();

			Iterator<ProxyInputParameter> iterator = inputParamtersList.iterator();

			while (iterator.hasNext()) {
				ProxyInputParameter inputParameter = iterator.next();
				if (StringUtils.trimToNull(inputParameter.getType()) == null) {
					function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
				} else {
					if (inputParameter.getType().equals("java.util.date")) {
						function.getImportParameterList().setValue(inputParameter.getKey(),inputParameter.getDateValue());
					} else {
						function.getImportParameterList().setValue(inputParameter.getKey(),inputParameter.getValue());
					}

				}
			}

			function.execute(destination);

			try {

				String bp = function.getExportParameterList().getString("E_PARTNER");
				String name = function.getExportParameterList().getString("E_NAMEBP");
				byte[] picture = function.getExportParameterList().getByteArray("E_PICTURE");
				
				FileOutputStream fo = new FileOutputStream(new File("c:/temp/" + name + "-" + bp + ".jpg"));
				fo.write(picture);
				fo.close();
				

				returnList.add(null);

			} catch (Exception ex) {
				log.error("saving file", ex);
				throw ex;
			} finally {

			}

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P002_GETBP_FROM_FP", e);
			throw e;
		}

		return returnList;
	}
}
