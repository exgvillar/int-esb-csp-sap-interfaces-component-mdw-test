package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
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
public class ZCRMETET_P002_UPD_EMPR_OS_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMETET_P002_UPD_EMPR_OS_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMETET_P002_UPD_EMPR_OS";
	
	public ZCRMETET_P002_UPD_EMPR_OS_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMETET_P002_UPD_EMPR_OS_OutputData>  executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ArrayList<ZCRMETET_P002_UPD_EMPR_OS_OutputData> returnList = new ArrayList<ZCRMETET_P002_UPD_EMPR_OS_OutputData>();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			
			
			// Parametros normales o generales
//			log.info("General Param:" + inputParamters.getGeneralParam() );
			Iterator<ProxyInputParameter> iterGeneralParams = inputParamters.getGeneralParam().iterator();
			while( iterGeneralParams.hasNext() ) {
				ProxyInputParameter inputParam = iterGeneralParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					}	
				
			}

			
			// Parametros de tipo table input
			JCoTable tableInput = function.getImportParameterList().getTable("IT_ORDSERV");
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
			
			log.info("input : " +  tableInput.toString() );
			function.execute(destination);


			// obtento respuesta del tipo table (export)
			JCoTable data = function.getExportParameterList().getTable("ET_RETURN");
			log.info(data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMETET_P002_UPD_EMPR_OS_OutputData output = new ZCRMETET_P002_UPD_EMPR_OS_OutputData();
				output.setIdOrdenServicio(data.getString("ORDSERV"));
				output.setError( (StringUtils.trimToEmpty( data.getString("ESTATUS") )!= null)?(data.getString("ESTATUS").trim().toUpperCase().equalsIgnoreCase("E"))?true:false:false);
				returnList.add( output );
			}
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
		}
		return( returnList );
	}
	
}
