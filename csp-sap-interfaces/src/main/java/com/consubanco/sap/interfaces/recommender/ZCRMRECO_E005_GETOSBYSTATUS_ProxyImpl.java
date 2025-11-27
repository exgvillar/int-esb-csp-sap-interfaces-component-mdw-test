/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
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
public class ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl.class);

	public ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, List<String> statusList)
			throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMRECO_E005_GETOSBYSTATUS");
			if (ft == null)
				throw new RuntimeException("ZCRMRECO_E005_GETOSBYSTATUS not found in SAP.");

			function = ft.getFunction();
			JCoTable statusTable = function.getImportParameterList().getTable("IT_ESTATUS");
			if (statusList != null && !statusList.isEmpty()) {
				for (String status : statusList) {
					statusTable.appendRow();
					statusTable.setValue("ID_ESTATUS", status);
				}
			}			
			log.info("Function.Input: " + statusTable);

			function.execute(destination);
			
			
			JCoTable dataTable = function.getExportParameterList().getTable("ET_RESULT");			
			
			log.info("Function.Output.Table: " + dataTable.toString());
			
			ZCRMRECO_E005_GETOSBYSTATUS_OutputData data = null; 
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {
				data = new ZCRMRECO_E005_GETOSBYSTATUS_OutputData();
				data.setServiceOrderId( dataTable.getString("ID_ORDEN_SERV") );
				data.setRecommenderBp( dataTable.getString( "BP_RECOMENDADOR" ) );
				data.setCompleteName( getFullName( dataTable ) );
				data.setRtsmCode( dataTable.getString( "COD_SEG_RSTM" ) );
				data.setPaymentRTSMConcept( dataTable.getString( "CPTO_PAGO_RSTM" ) );
				data.setCellPhone( dataTable.getString( "CELULAR" ) );	
				data.setAmount( dataTable.getDouble( "MONTO" ) );	
				
				returnList.add( data );
			}							
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E005_GETOSBYSTATUS :: ", e);
			throw e;
		} finally {

		}

		return (returnList);
	}

	private String getFullName(JCoTable dataTable) {
		StringBuffer sbFullName = new StringBuffer();		
		try {
			StringBuffer sbComponentNames = new StringBuffer();
			sbComponentNames.append( StringUtils.trimToEmpty( dataTable.getString( "NOMBRE1" ) ) ).append( " " );
			sbComponentNames.append( StringUtils.trimToEmpty( dataTable.getString( "NOMBRE2" ) ) );
			sbFullName.append( StringUtils.trimToEmpty( sbComponentNames.toString() ) ).append( " " );
			sbComponentNames = new StringBuffer();
			sbComponentNames.append( StringUtils.trimToEmpty( dataTable.getString( "APE_PAT" ) ) ).append( " " );
			sbComponentNames.append( StringUtils.trimToEmpty( dataTable.getString( "APE_MAT" ) ) );
			sbFullName.append( StringUtils.trimToEmpty( sbComponentNames.toString() ) );			
			return sbFullName.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
