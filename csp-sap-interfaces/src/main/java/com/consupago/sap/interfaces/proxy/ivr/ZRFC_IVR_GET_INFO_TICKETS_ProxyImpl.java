/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
 * @author user-admin
 * 
 */
public class ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory
			.getLog(ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl.class);

	private static final String functionCRM_Name = "ZCRMIVR_E001_INFOTICKET";

	/**
	 * 
	 */
	public ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			log.info("Input: " +inputParamtersList.toString());
			ft = destination.getRepository().getFunctionTemplate( functionCRM_Name );
			if (ft == null)
				throw new RuntimeException( functionCRM_Name + " not found in SAP." );

			function = ft.getFunction();

			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while (iter.hasNext()) {
				ProxyInputParameter inputParam = iter.next();
				if (StringUtils.trimToNull(inputParam.getType()) == null) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				} else {
					if (inputParam.getType().equals("java.util.date"))
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}

			function.execute(destination);

			ArrayList<INFO_TICKET_OutputData> infoTicketList = new ArrayList<INFO_TICKET_OutputData>();
			INFO_TICKET_OutputData output = new INFO_TICKET_OutputData();

			JCoStructure structure = function.getExportParameterList().getStructure( "ES_RESULT" );
			
			String message = function.getExportParameterList().getString( "E_MESSAGE" );

			log.info("" + structure.toString());
			
			if (StringUtils.trimToNull(message) != null) {
				
				INFO_TICKET_MESSAGE_OutputData messageOut = new INFO_TICKET_MESSAGE_OutputData();
				messageOut.setDescription(message);
				
				output.setMessage(messageOut);
				
			}else{
				
				output.setCreateDate(structure.getDate("FECHA_CREA_TKT"));
				output.setFinalizedDate(structure.getDate("FECHA_FIN_TKT"));
				output.setExpired(isExpired(output.getFinalizedDate()));
				output.setStatusDesc(structure.getString("DESC_ESTATUS"));
				output.setStatusId(structure.getString("ID_ESTATUS"));
				output.setTypeDesc(structure.getString("DESC_TIPO_TKT"));
				output.setTypeId(structure.getString("TIPO_TICKET"));
				output.setValid(Boolean.TRUE);
				
			}


			infoTicketList.add(output);

			returnList.add(output);

		} catch (AbapException e) {
			log.error(" executing function " + functionCRM_Name, e);
			throw e;
		} finally {

		}

		return (returnList);
	}

	private boolean isExpired(Date date) {
		Timestamp dateStamp = new Timestamp(date.getTime());
		return new Date().after(dateStamp);
	}

}
