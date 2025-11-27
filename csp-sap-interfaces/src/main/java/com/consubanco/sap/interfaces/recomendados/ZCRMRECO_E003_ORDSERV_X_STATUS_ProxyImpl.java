package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_RECOMENDADO_Model;
import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_REFIERE_Model;
import com.consubanco.sap.interfaces.recomendados.model.CONVENIO_Model;
import com.consubanco.sap.interfaces.recomendados.model.DISTRIBUIDOR_Model;
import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consubanco.sap.interfaces.recomendados.model.REGION_Model;
import com.consubanco.sap.interfaces.recomendados.model.SUCURSAL_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl.class );
	
	public ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E003_ORDSERV_X_STATUS" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E003_ORDSERV_X_STATUS not found in SAP.");

			function = ft.getFunction();

			if( inputParamtersList != null ) {

				//Iterate STATUS Table
				JCoTable statusTable = function.getImportParameterList().getTable("IT_STATUS");
			
				Iterator<ProxyInputParameter> intIterator = inputParamtersList.iterator();
				while( intIterator.hasNext() ) {
					ProxyInputParameter inputParameter = (ProxyInputParameter) intIterator.next();

					statusTable.appendRow();
					statusTable.setValue("STATUS", inputParameter.getValue());

				}

			}
			
			
			function.execute(destination);
			
			
			
			ZCRMRECO_E003_ORDSERV_X_STATUS_OutputData data = new ZCRMRECO_E003_ORDSERV_X_STATUS_OutputData();

			data.setMessage(function.getExportParameterList().getString("E_MESSAGES"));

			JCoTable dataTable = function.getExportParameterList().getTable("ET_ORDSERV");
			log.info( "" +  dataTable.toString() );

			List<ORDEN_SERVICIO_Model> listServiceOrder = new ArrayList<ORDEN_SERVICIO_Model>();
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {

				ORDEN_SERVICIO_Model ordenServicio = new ORDEN_SERVICIO_Model();
				ordenServicio.setNumeroOrdenServicio( dataTable.getString("CLR_ORDSERV") ); 

				CLIENTE_RECOMENDADO_Model referido = new CLIENTE_RECOMENDADO_Model();

				DISTRIBUIDOR_Model distribuidorClr = new DISTRIBUIDOR_Model();
				distribuidorClr.setId(dataTable.getString("CLR_DISTRIBUIDOR"));
				distribuidorClr.setDescription(dataTable.getString("CLR_DESC_DISTRIB"));
				referido.setDistribuidor(distribuidorClr);
				
				REGION_Model regionClr = new REGION_Model();
				regionClr.setId(dataTable.getString("CLR_REGION"));
				regionClr.setDescription(dataTable.getString("CLR_DESC_REGION"));
				referido.setRegion(regionClr);

				SUCURSAL_Model sucursalClr = new SUCURSAL_Model();
				sucursalClr.setId(dataTable.getString("CLR_SUCURSAL"));
				sucursalClr.setDescription(dataTable.getString("CLR_DESC_SUCURS"));
				referido.setSucursal(sucursalClr);
				
				referido.setPromotor(dataTable.getString("CLR_PROMOTOR"));

				CONVENIO_Model convenioClr = new CONVENIO_Model();
				convenioClr.setId(dataTable.getString("CLR_ID_CONVENIO"));
				convenioClr.setDescription(dataTable.getString("CLR_DESC_CONVEN"));
				referido.setConvenio(convenioClr);
				
				referido.setNumeroSolicitud(dataTable.getString("CLR_NUMSOLIC"));
				referido.setNumeroCliente(dataTable.getString("CLR_NUMCLI"));
				
				referido.setNombre1(dataTable.getString("CLR_NOMBRE1"));
				referido.setNombre2(dataTable.getString("CLR_NOMBRE2"));
				referido.setApellidoPaterno(dataTable.getString("CLR_APEPAT"));
				referido.setApellidoMaterno(dataTable.getString("CLR_APEMAT"));
				referido.setRFC(dataTable.getString("CLR_RFC"));
				
				referido.setMontoCredito(dataTable.getString("CLR_MONTO_CREDITO"));
				referido.setDescuento(dataTable.getString("CLR_DESCUENTO"));
				referido.setPlazoCredito(dataTable.getString("CLR_PLAZO_CREDITO"));
				referido.setFechaInicioSolicitud(dataTable.getDate("CLR_FEC_SOLIC"));
				referido.setFechaCompra(dataTable.getDate("CLR_FEC_COMPRA"));
				referido.setIncidencia(dataTable.getString("CLR_INCIDENCIA"));
				
				CLIENTE_REFIERE_Model refiere = new CLIENTE_REFIERE_Model(); 
				
				refiere.setBusinessPartner(dataTable.getString("CRE_PARTNER"));
				refiere.setNucleoCliente(dataTable.getString("CRE_NUCLEO"));

				refiere.setNombre1(dataTable.getString("CRE_NOMBRE1"));
				refiere.setNombre2(dataTable.getString("CRE_NOMBRE2"));
				refiere.setApellidoPaterno(dataTable.getString("CRE_APEPAT"));
				refiere.setApellidoMaterno(dataTable.getString("CRE_APEMAT"));
				refiere.setRFC(dataTable.getString("CRE_RFC"));
				
				DISTRIBUIDOR_Model distribuidorCre = new DISTRIBUIDOR_Model();
				distribuidorCre.setId(dataTable.getString("CRE_DISTRIBUIDOR"));
				distribuidorCre.setDescription(dataTable.getString("CRE_DESC_SUCURS"));
				refiere.setDistribuidor(distribuidorCre);
				
				refiere.setTelefonoPrincipal(dataTable.getString("CRE_TELEFONO_PRIN"));
				refiere.setTelefonoSecundario(dataTable.getString("CRE_TELEFONO_SEC"));
				
				refiere.setMontoPago(dataTable.getString("CRE_MONTO_PAGO"));
				refiere.setReferenciaPago(dataTable.getString("CRE_REFPAGO"));
				refiere.setFechaVencimiento(dataTable.getDate("CRE_FECVEN"));

				ordenServicio.setClienteRecomendado(referido);
				ordenServicio.setClienteRefiere(refiere);
				
				listServiceOrder.add( ordenServicio );	
			}

			data.setListServiceOrder(listServiceOrder);

			log.info( "" +  data.toString() );

			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E003_ORDSERV_X_STATUS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

}
