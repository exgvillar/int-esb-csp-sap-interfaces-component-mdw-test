package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class ZCRMTESO_P010_PROCESA600_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMTESO_P010_PROCESA600_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMTESO_P010_PROCESA600";
	
	public ZCRMTESO_P010_PROCESA600_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMTESO_P010_PROCESA600_OutputData>  executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ArrayList<ZCRMTESO_P010_PROCESA600_OutputData> returnList = new ArrayList<ZCRMTESO_P010_PROCESA600_OutputData>();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
//			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUDES");
//			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
//			while( iterRecord.hasNext() ) {
//				tableInput.appendRow();
//				ArrayList<ProxyInputParameter> recordParam = (ArrayList<ProxyInputParameter>) iterRecord.next();
//				Iterator<ProxyInputParameter> iterRecorParam = recordParam.iterator();
//				while (iterRecorParam.hasNext()) {
//					ProxyInputParameter inputParam = (ProxyInputParameter) iterRecorParam.next();
//					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
//							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
//						
//					} else {
//						if( inputParam.getType().equals("java.util.Date") )
//							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
//						else
//							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
//					}
//				}
//			}
//			log.info("input : " +  tableInput.toString() );
			function.execute(destination);
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			log.info(data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMTESO_P010_PROCESA600_OutputData output = new ZCRMTESO_P010_PROCESA600_OutputData();

				output.setSociedad( data.getString("SOCIE") );
				output.setFormaPago( data.getString("FORPAG") );
				output.setCodigoBanco( data.getString("CODBAN") );
				output.setClaveBanco( data.getString("CLAVE") );
				output.setReferencia( data.getString("REFERE") );
				output.setMonto( data.getString("MONTO") );
				output.setNumOrden( data.getString("NUMORD") );
				output.setMoneda( data.getString("MONEDA") );
				output.setTipoBeneficiario( data.getString("TIPBEN") );
				output.setApPatertno( data.getString("APEPAT") );
				output.setApMaterno( data.getString("APEMAT") );
				output.setNombre( data.getString("NOMBRE") );
				output.setRfc( data.getString("RFC") );
				output.setTipoIdentificacion( data.getString("TIPIDE") );
				output.setNumIdentificacion( data.getString("NUMIDE") );
				output.setTipoSolicitud( data.getString("TIPSOL") );
				output.setNumCliente( data.getString("NUMCTE") );
				output.setNumSolicitud( data.getString("NUMSOL") );
				output.setFecSolicitud( data.getString("FECSOL") );
				output.setConban( data.getString("CONBAN") );
				output.setIdSucursal( data.getString("IDSUC") );
				output.setNomSucursal( data.getString("NOMSUC") );
				output.setIdDistribuidor( data.getString("IDDIST") );
				output.setNomDistribuidor( data.getString("NOMDIS") );
				output.setIdConvenio( data.getString("IDCONV") );
				output.setNomConvenio( data.getString("NOMCON") );
				output.setConfro( data.getString("CONFRO") );
				output.setFecAutorizacion( data.getString("FECAUT") );
				output.setImpAutorizado( data.getString("IMPAUT") );
				output.setImpDescuento( data.getString("IMPDES") );
				output.setPlazo( data.getString("PLAZO") );
				output.setScm( data.getString("SCM") );


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
