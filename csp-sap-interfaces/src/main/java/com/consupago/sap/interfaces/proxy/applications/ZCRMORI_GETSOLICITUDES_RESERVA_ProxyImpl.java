/**
 * 
 */
package com.consupago.sap.interfaces.proxy.applications;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZES_ATRIBORI_Model;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_ESTATUS_Model;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_TELEFONOS_Model;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * @author
 *
 */
public class ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl {
	
	private static Log log = LogFactory.getLog( ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl.class );
	
	public ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl() {
		super();
	}
	
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ZTT_ESTATUS_Model> inputParamters) throws Exception{
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		try {
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_GETSOLICITUDES_RESERVA" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_GETSOLICITUDES_RESERVA not found in SAP.");
			
			function = ft.getFunction();
	
			if( inputParamters != null ){
				JCoTable table = function.getImportParameterList().getTable("IT_LISTA_STATUS");
				
				Iterator<ZTT_ESTATUS_Model> iterator = inputParamters.iterator();
				ZTT_ESTATUS_Model status = null;
				while (iterator.hasNext()) {
					status  = (ZTT_ESTATUS_Model) iterator.next();
					table.appendRow();
					
					table.setValue("STAT", status.getStatus());
					
					log.info( "Input: >>>" + table.toString() );
				}
					
			}
			
			function.execute(destination);
			
			String message = function.getExportParameterList().getString("E_MESSAGE");
			
			JCoTable data = function.getExportParameterList().getTable("ET_SOLIC_RESERV");
			
			log.info("RFC Response: " + data.toString());
			
			ZCRMORI_GETSOLICITUDES_RESERVA_OutputData outputData = null;
			ZTT_TELEFONOS_Model telefonos_Model = null;
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow()) {
				outputData = new ZCRMORI_GETSOLICITUDES_RESERVA_OutputData();
				
				outputData.setIdConvenio( data.getString("ZID_CONVENIO") );
				outputData.setIdSolicitud( data.getString("ZID_SOLICITUD") );
				outputData.setIdBrms( data.getString("ZID_CONVENIO_BRMS") );
				outputData.setDescConvenio( data.getString("DESC_CONVENIO") );
				outputData.setIdProducto( data.getString("ZID_PRODUCTO") );
				outputData.setDescProducto( data.getString("ZDESC_PRODUCTO") );
				outputData.setCateProducto( data.getString("ZCATEGORIA") );
				outputData.setDescCateProducto( data.getString("ZDESC_CATPROD") );
				outputData.setIdStatus( data.getString("ID_STATUS") );
				outputData.setDescStatus( data.getString("DES_STATUS") );
				
				outputData.setFechaStatus( Formatter.formatStringCRMToDateComplete( data.getString("FECHOR_STS") ) );
				outputData.setBpId( data.getString("BP_SOLICITANTE") );
				outputData.setRfcSolicitante( data.getString("RFC_SOLICITANTE") );
				outputData.setNombre1( data.getString("NOMBRE1") );
				outputData.setNombre2( data.getString("NOMBRE2") );
				outputData.setApPaterno( data.getString("APE_PAT") );
				outputData.setApMaterno( data.getString("APE_MAT") );
				outputData.setFolioReserva( StringUtils.trim(data.getString("FOLIO_RESERVA") ) );
				outputData.setFechaReserva( Formatter.formatStringCRMToDateComplete( data.getString("FECHOR_RESERVA") ) );
				
				JCoTable table = data.getTable("TELEFONOS");
				outputData.setPhones(new ArrayList<ZTT_TELEFONOS_Model>());
				log.info("Table Telefonos: " + table.toString());
				
				for (int j = 0; j < table.getNumRows(); j++, table.nextRow()) {
					telefonos_Model = new ZTT_TELEFONOS_Model();
					telefonos_Model.setNumTel( table.getString("NUMTEL") );
					telefonos_Model.setNumExt( table.getString("NUMEXT") );
					telefonos_Model.setTipAdd( table.getString("TIPADD") );
					telefonos_Model.setTipTel( table.getString("TIPTEL") );
					
					outputData.getPhones().add( telefonos_Model );
				}
				ZES_ATRIBORI_Model atribori_Model = new ZES_ATRIBORI_Model();
				JCoStructure structure = data.getStructure("ATRIB_ORIG");
				log.info("Structure Origination Detail: " + structure.toString());
				
				atribori_Model.setCnca("x".equalsIgnoreCase(structure.getString("ZCNCA")) ? Boolean.TRUE : Boolean.FALSE);
				atribori_Model.setSegundaDispo("x".equalsIgnoreCase(structure.getString("ZSEGUNDA_DISPO")) ? Boolean.TRUE : Boolean.FALSE);
				atribori_Model.setLcom("x".equalsIgnoreCase(structure.getString("ZLCOM")) ? Boolean.TRUE : Boolean.FALSE);
				atribori_Model.setCreditoNuevo("x".equalsIgnoreCase(structure.getString("ZCREDITO_NUEVO")) ? Boolean.TRUE : Boolean.FALSE);
				atribori_Model.setNumDispo(structure.getInt("ZNUM_DISPO"));
				atribori_Model.setInterCompania("x".equalsIgnoreCase(structure.getString("ZINTERCOMPANIA")) ? Boolean.TRUE : Boolean.FALSE);
				
				outputData.setOriginationDetail(atribori_Model);
				
				outputData.setMessage(message);
				
				returnList.add(outputData);
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_GETSOLICITUDES_RESERVA" , e);
			throw e;
		}
		return returnList;
	}
	 

	
}

