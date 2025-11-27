package com.consupago.sap.interfaces.proxy.formalizacion;

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
public class ZCRMGEM_FORMALIZA2_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMGEM_FORMALIZA2_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMGEM_FORMALIZA2";
	
	public ZCRMGEM_FORMALIZA2_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos

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
			log.info("input : " +  tableInput.toString() );
			function.execute(destination);

			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
