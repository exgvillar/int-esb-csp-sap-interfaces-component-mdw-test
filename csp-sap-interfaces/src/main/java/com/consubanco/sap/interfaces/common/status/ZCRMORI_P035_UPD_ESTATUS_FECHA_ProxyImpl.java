package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.lcom.dispersion.ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData.CompetidorInfo;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMORI_P035_UPD_ESTATUS_FECHA";
	
	public ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();

			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
//			log.info(inputParamtersList);
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
//				log.info(inputParam);
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			log.info("Input :: "+function.getImportParameterList().toString() );
			function.execute(destination);
			

		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
