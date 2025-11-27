package com.consupago.sap.interfaces.proxy.lcom.cartas;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl  {
	private static Log log = LogFactory.getLog( ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_P004_CAMBIA_ESTAT_OS";
	
	public ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {

		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ArrayList<ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData> arrOutput = new ArrayList<ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData>();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUDES");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			
			while( iterRecord.hasNext() ) {
				tableInput.appendRow();
				ArrayList<ProxyInputParameter> recordParam = (ArrayList<ProxyInputParameter>) iterRecord.next();
				Iterator<ProxyInputParameter> iterRecorParam = recordParam.iterator();
				while (iterRecorParam.hasNext()) {
					ProxyInputParameter inputParam = (ProxyInputParameter) iterRecorParam.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
						
					} else {
						if( inputParam.getType().equals("java.util.Date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}
				}
			}
//			log.info("input : " +  tableInput.toString() );
			function.execute(destination);
			// recupero la salida del rfc...
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
//			log.info(data.toString());
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData output = new ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData();
				output.setIdOperacion( data.getString("OBJNR"));
				output.setMensaje( data.getString("ZMSG"));
				output.setIndicador( data.getString("ZIND"));
				arrOutput.add(output);
			}
			
			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		return( arrOutput );
	}
	
}
