/**
 * 
 */
package com.consubanco.sap.interfaces.puc;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_OutputData;
import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.utils.TransactionLatency;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl implements IStandardSAPProxy {

	private static Log logger = LogFactory.getLog(ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl.class);

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMPUC_E001_ESTADO_CUENTA");
			if (ft == null)
				throw new RuntimeException("ZCRMPUC_E001_ESTADO_CUENTA not found in SAP.");

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

			logger.info("Function.Import:ZCRMPUC_E001_ESTADO_CUENTA: " + function.getImportParameterList().toString());
			TransactionLatency latency = new TransactionLatency("ZCRMPUC_E001_ESTADO_CUENTA");
			function.execute(destination);
			latency.finish();
			logger.info("Function.Export:ZCRMPUC_E001_ESTADO_CUENTA: " + function.getExportParameterList().toString());

			ZCRMPUC_E001_ESTADO_CUENTA_OutputData output = new ZCRMPUC_E001_ESTADO_CUENTA_OutputData();

			if(function.getExportParameterList().getString("E_ACCOUNT_ID")=="" || function.getExportParameterList().getString("E_ACCOUNT_ID")==null){
				output.setSuccess(false);
				output.setMessage("CRM. No existe información para el creditId suministrado");

			}else {
				output.setCreditId(function.getExportParameterList().getString("E_ACCOUNT_ID"));
				output.setFormDate(function.getExportParameterList().getString("E_FECHA_FORM"));
				output.setAccount(function.getExportParameterList().getString("E_CUENTA"));
				output.setNumPay(function.getExportParameterList().getString("E_PAGOS"));
				output.setTypeCurrency(function.getExportParameterList().getString("E_MONEDA"));
				output.setPayPeriod(function.getExportParameterList().getString("E_PERI_PAGOS"));
				output.setOrdInterestAmount(function.getExportParameterList().getString("E_MONTO_INT_ORD"));
				output.setBorrowerName(function.getExportParameterList().getString("E_NOMBRE_ACREDITADO"));
				output.setDependency(function.getExportParameterList().getString("E_DEPENDENCIA"));
				output.setDispoAmount(function.getExportParameterList().getString("E_MONTO_DISPO"));
				output.setTotalAmount(function.getExportParameterList().getString("E_MONTO_TOTAL"));
				output.setPeriodDiscount(function.getExportParameterList().getString("E_DESCUENTO_PERI"));
				output.setOrdInterestRate(function.getExportParameterList().getString("E_TASA_INT_ANUAL"));
				output.setComission(function.getExportParameterList().getString("E_COMISION"));
				output.setTotalComi(function.getExportParameterList().getString("E_TOTAL_COMISION"));
				output.setCurrency(function.getExportParameterList().getString("E_MONEDA_PESOS"));
				output.setPayDate(function.getExportParameterList().getString("E_FECHA_COBRO"));
				output.setAddressCSB(function.getExportParameterList().getString("E_DIRECCION_CSB"));
				output.setSuccess(true);
			}
		

			returnList.add(output);
		} catch (AbapException e) {
			logger.error(" executing function " + "ZCRMPUC_E001_ESTADO_CUENTA", e);
			throw e;
		}

		return (returnList);
	}


}
