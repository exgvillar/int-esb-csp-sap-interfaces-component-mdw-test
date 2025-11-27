package com.consubanco.sap.interfaces.cobranza.requests;

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

public class ZCRMCOB_INFO_COMP_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMCOB_INFO_COMP_ProxyImpl.class );
	
	public ZCRMCOB_INFO_COMP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCOB_INFO_COMP" );
			if(ft == null)
				throw new RuntimeException("ZCRMCOB_INFO_COMP not found in SAP.");
			
			function = ft.getFunction();
			
			JCoTable tableInput = function.getImportParameterList().getTable("I_CUENTAS");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ArrayList<ProxyInputParameter>  recordParams = (ArrayList<ProxyInputParameter>)iterRecord.next();
				Iterator<ProxyInputParameter> iterRecordParams = recordParams.iterator();
				while( iterRecordParams.hasNext() ) {
					ProxyInputParameter inputParam = iterRecordParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}						
				}
			}
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				
				JCoTable dataCompetidores = data.getTable("ZCOMPETIDORES");
				
				log.info( "" +  dataCompetidores.toString() );
				for (int j = 0; j < dataCompetidores.getNumRows(); j++, dataCompetidores.nextRow() ) {
					ZCRMCOB_INFO_COMP_OutputData tableData = new ZCRMCOB_INFO_COMP_OutputData();
					
					tableData.setSiglaEmpresa( data.getString("ZSIGLA") );
					tableData.setEmpresa( data.getString("ZDESC_EMPRESA") );
					tableData.setNss( data.getString("ZNSS") );
					tableData.setSolicitud( data.getString("ZID_SOLICITUD") );
					tableData.setNombreCliente( data.getString("ZNOMBRE_CLIENTE") );
					tableData.setFechaDispersion( data.getDate("ZFECHA_DISPERSION") );
					tableData.setFechaCompra( data.getDate("ZFECHA_COMPRA") );
					tableData.setConvenioId( data.getString("ZID_CONVENIO") );
					tableData.setConvenio( data.getString("ZDESC_CONVENIO") );
					tableData.setFechaInicioInstalacion( data.getDate("ZFECHA_INSTALAC") );
					tableData.setFechaCreacionSolicitud( data.getDate("ZFECHA_CREACION") );
					tableData.setNumeroCuenta( data.getString("ZCUENTA") );
					
					tableData.setRazonSocialCompetidor( dataCompetidores.getString("ZRAZON_SOCIAL") );
					tableData.setNombreCortoCompetidor( dataCompetidores.getString("ZNOM_CORTO") );
					tableData.setNombreComercialCompetidor( dataCompetidores.getString("ZNOM_COMERCIAL") );
					tableData.setFechaEmisionCarta( dataCompetidores.getDate("ZFECHA_EMISION") );
					tableData.setFechaVencimientoCarta( dataCompetidores.getDate("ZFECHA_VENCIMIENTO") );
					tableData.setNumCompetidor( dataCompetidores.getString("ZID_COMPETIDOR") );
					tableData.setFechaDispersionCompetidor( dataCompetidores.getDate("ZFECHA_DISPER") );
					tableData.setNumCuentaCompetidor( dataCompetidores.getString("ZCUENTA") );
					tableData.setReferenciaCompetidor( dataCompetidores.getString("ZREFERENCIA") );
					tableData.setMontoCompetidor( dataCompetidores.getDouble("ZMONTO_LIQ") );
					returnList.add( tableData );
				}		
				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCOB_INFO_COMP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
