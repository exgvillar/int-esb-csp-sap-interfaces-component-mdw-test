package com.consubanco.sap.interfaces.debtBalanceInsurance;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.debtBalanceInsurance.model.ZTL_SSD_APP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl.class );
	
	public ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMSGDEU_ORDENSERV_X_ESTATUS" );
			if(ft == null)
				throw new RuntimeException("ZCRMSGDEU_ORDENSERV_X_ESTATUS not found in SAP.");
			
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
			
			ZCRMSGDEU_ORDENSERV_X_ESTATUS_OutputData outputData = new ZCRMSGDEU_ORDENSERV_X_ESTATUS_OutputData();
			
			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
			log.info( "" +  data.toString() );
			ArrayList<ZTL_SSD_APP_Model> ssdApplicationsList = new ArrayList<ZTL_SSD_APP_Model>();
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZTL_SSD_APP_Model tableData = new ZTL_SSD_APP_Model();
				
				tableData.setServiceOrderSSD( data.getString("ID_ORDEN_SERV") );
				tableData.setFolioApplication( data.getString("ID_SOL_COT") );
				ssdApplicationsList.add( tableData );
			}
			outputData.setSsdApplicationsList( ssdApplicationsList );
			
			outputData.setMessages( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( outputData );	
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMSGDEU_ORDENSERV_X_ESTATUS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
