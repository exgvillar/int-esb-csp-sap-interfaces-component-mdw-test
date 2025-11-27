/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bt.model.ZESCRMBT_E002_INCIDENCIAS_Model;
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
public class ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl.class);
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
	
	/**
	 * 
	 */
	public ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl() {
		super();
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction(
			JCoDestination destination,
			List<ZESCRMBT_E002_INCIDENCIAS_Model> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMBT_P004_SAVE_INCIDENCIAS" );
			if(ft == null)
				throw new RuntimeException("ZCRMBT_P004_SAVE_INCIDENCIAS not found in SAP.");
			
			function = ft.getFunction();
			
			JCoTable tableInput = function.getImportParameterList().getTable("IT_INCIDENCIAS");
			
			Iterator<ZESCRMBT_E002_INCIDENCIAS_Model> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ZESCRMBT_E002_INCIDENCIAS_Model incidencia = iter.next();
				tableInput.appendRow();
				
				tableInput.setValue("ID_INCIDENCIA" , incidencia.getIdIncidencia());
				tableInput.setValue("ID_SOLICITUD" , incidencia.getIdSolicitud());
				tableInput.setValue("ID_CAUSA" , incidencia.getIdCausa());
				tableInput.setValue("ID_MOTIVO" , incidencia.getIdMotivo());
				tableInput.setValue("DESC_INT" , incidencia.getDescInt());
				tableInput.setValue("DESC_EXT" , incidencia.getDescExt());
				tableInput.setValue("PHONE" , incidencia.getPhone());
				
			}
			
			log.info( tableInput.toString() );
			
			function.execute(destination);
			
			ZCRMBT_P004_SAVE_INCIDENCIAS_OutputData data = new ZCRMBT_P004_SAVE_INCIDENCIAS_OutputData();
			String success = function.getExportParameterList().getString("E_EXITO");
			
			if( "X".equalsIgnoreCase( success ) ){
				data.setSuccess(Boolean.TRUE);
			}
			data.setMessage( function.getExportParameterList().getString("E_MENSAJE") );
			
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMBT_P004_SAVE_INCIDENCIAS :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

}
