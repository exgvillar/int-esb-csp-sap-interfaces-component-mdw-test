package com.consupago.sap.interfaces.proxy.formalizacion;

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
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author jcontreras
 * Llamada al JCO que ejecuta la formalizacion de GEM.
 * de las solicitudes.
 * 
 */
public class ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMCTEM_E001_SOLBYESTAT";
	
	public ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP in System ::" + destination.getClient());
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
			
			
//			log.info("Datos de Entrada JCO:" +function.getImportParameterList().toString());
			
			function.execute(destination);

			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
//			log.info("Salida JCO: " +  data.toString() );
			ArrayList<String> requestIdList = new ArrayList<String>();
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {				
				requestIdList.add(data.getString("ID_SOLICITUD"));
			}
			
			ZCRMCTEM_E001_SOLBYESTAT_OutputData returnData = new ZCRMCTEM_E001_SOLBYESTAT_OutputData();
			if(!requestIdList.isEmpty())
				returnData.setRequestIdList(requestIdList);
			
			
			
			returnList.add( returnData );	
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		return( returnList );
	}
	
}
