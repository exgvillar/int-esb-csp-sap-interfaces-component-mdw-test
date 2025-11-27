package com.consubanco.sap.interfaces.proxy.cm;

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
import com.sap.conn.jco.JCoStructure;

public class ZCRMCOM_GET_INFOGLOB_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMCOM_GET_INFOGLOB_ProxyImpl.class );
	
	public ZCRMCOM_GET_INFOGLOB_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCOM_GET_INFOGLOB" );
			if(ft == null)
				throw new RuntimeException("ZCRMCOM_GET_INFOGLOB not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			log.info(" Input :: " + function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			JCoStructure dataStructure = function.getExportParameterList().getStructure("E_INFOGLOB");
			ZCRMCOM_GET_INFOGLOB_OutputData data = new ZCRMCOM_GET_INFOGLOB_OutputData();			
			data.setBranchId( dataStructure.getString("IDSUCURS") );
			data.setStartDate( dataStructure.getDate("FECINI") );
			data.setEndDate( dataStructure.getDate("FECFIN") );
			data.setBranchShort( dataStructure.getString("SUCSHORT") );
			data.setTotalApplicationsPurchased( dataStructure.getInt("TOTAL_COMPRADAS") );
			data.setTotalApplicationsRejected( dataStructure.getInt("TOTAL_RECHAZADAS") );
			data.setTotalApplicationsCancelled( dataStructure.getInt("TOTAL_CANCELADAS") );
			data.setTotalApplicationsProjected( dataStructure.getInt("TOTAL_PROYECTADO") );
			data.setApprovedRate( dataStructure.getDouble("TASA_APROB") );
			data.setAmountApplicationsPurchased( dataStructure.getDouble("MONTO_COMPRADO") );
			data.setAmountApplicationsRejected( dataStructure.getDouble("MONTO_RECHAZADO") );
			data.setAmountApplicationsCancelled( dataStructure.getDouble("MONTO_CANCELADO") );
			data.setAmountApplicationsProjected( dataStructure.getDouble("MONTO_PROYECTAD") );
			
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( data );	

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCOM_GET_INFOGLOB :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
