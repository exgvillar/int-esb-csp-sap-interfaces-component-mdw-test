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

/**
 * @author hsanchez
 *
 */
public class ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImpl.class );
	
	public ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_CRMORI_E001_GETCTRLDISP" );
			if(ft == null)
				throw new RuntimeException("ZRFC_CRMORI_E001_GETCTRLDISP not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);			
			log.info("Function.Export: " + function.getExportParameterList().toString() );			
			
			ZRFC_CRMORI_E001_GETCTRLDISP_OutputData data = new ZRFC_CRMORI_E001_GETCTRLDISP_OutputData();			
			data.setDocumentId( function.getExportParameterList().getString("E_ID_DOCUMENTO") );
			data.setOperationType( function.getExportParameterList().getString("E_TIPO_OPERACION") );
			data.setTrackingId( function.getExportParameterList().getString("E_CLAVE_RASTREO") );
			data.setSameBank( function.getExportParameterList().getString("E_MISMO_BANCO").equals("X") ? true : false );
			data.setCreateDate( function.getExportParameterList().getDate("E_FECHA_CREACION") );
			data.setCreateHour( function.getExportParameterList().getString("E_HORA_CREACION") );
			data.setApplicationIdAssociated( function.getExportParameterList().getString("E_SOLICITUD_ASOCIADA") );
			
			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_CRMORI_E001_GETCTRLDISP :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
