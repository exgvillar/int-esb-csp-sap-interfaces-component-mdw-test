package com.consupago.sap.interfaces.proxy.cotizador;

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

public class ZRFC_TAMORT_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_TAMORT_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_TAMORT";
	
	public ZRFC_TAMORT_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
//				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else if( inputParam.getType().equals("java.lang.Double") )
						function.getImportParameterList().setValue( inputParam.getKey(), Double.valueOf( inputParam.getValue() ) );
					else if( inputParam.getType().equals("java.lang.Integer") )
						function.getImportParameterList().setValue( inputParam.getKey(), Integer.valueOf( inputParam.getValue() ) );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			
			function.execute(destination);
			
			ZRFC_TAMORT_OutputData tableData = new ZRFC_TAMORT_OutputData();
			tableData.setMontoDescuento( function.getExportParameterList().getDouble("E_MOTO_PAGO") );
			tableData.setTasaInteres( function.getExportParameterList().getString("E_TASA_MEN") );
			tableData.setTasaInteresAnual( function.getExportParameterList().getString("E_TASA_ANUAL") );
			tableData.setCAT( function.getExportParameterList().getDouble("E_TASA_CAT") );
			
			JCoTable data = function.getExportParameterList().getTable("E_TAMORT");
			
			log.info( "" +  data.toString() );
			
			ArrayList<ZTL_TAMORT_OutputData> amortizationsList = new ArrayList<ZTL_TAMORT_OutputData>();
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZTL_TAMORT_OutputData amortizationData = new ZTL_TAMORT_OutputData();
				
				amortizationData.setNumeroPago( data.getInt("PAGO_NO") );
				amortizationData.setCapital( data.getDouble("CAPITAL") );				
				amortizationData.setInteres( data.getDouble("INTERES") );				
				amortizationData.setIva( data.getDouble("IVA") );
				amortizationData.setAmortizacion( data.getDouble("AMOTIZACION") );
				amortizationData.setPago( data.getDouble("PAGO") );
				amortizationsList.add( amortizationData );				
			}
			
			tableData.setAmortizationTable(amortizationsList);
			
			returnList.add( tableData );	
			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
