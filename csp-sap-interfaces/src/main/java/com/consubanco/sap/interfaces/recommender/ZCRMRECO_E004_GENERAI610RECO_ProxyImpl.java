package com.consubanco.sap.interfaces.recommender;

import java.util.ArrayList;

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

public class ZCRMRECO_E004_GENERAI610RECO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E004_GENERAI610RECO_ProxyImpl.class );
	
	public ZCRMRECO_E004_GENERAI610RECO_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E004_GENERAI610RECO" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E004_GENERAI610RECO not found in SAP.");
			
			function = ft.getFunction();
			
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_E004_GENERAI610RECO_OutputData data = null;			
			JCoTable exportTable = function.getExportParameterList().getTable("ET_DATA");			
			
			for (int i = 0; i < exportTable.getNumRows(); i++, exportTable.nextRow() ) {
				data = new ZCRMRECO_E004_GENERAI610RECO_OutputData();
				
				data.setIdSolicitud( exportTable.getString("ID_SOL") ); 
				data.setForpag( exportTable.getString("FORPAG") );
				data.setCodban( exportTable.getString("CODBAN") );
				data.setClave( exportTable.getString("CLAVE") );
				data.setRefere( exportTable.getString("REFERE") );
				data.setMonto( exportTable.getString("MONTO") );
				data.setNumord( exportTable.getString("ID_ORDEN") );
				data.setApepat( exportTable.getString("APEPAT") );
				data.setApemat( exportTable.getString("APEMAT") );
				data.setNombre( exportTable.getString("NOMBRE") );
				data.setTipide( exportTable.getString("TIPIDE") );
				data.setNumide( exportTable.getString("NUMIDE") );
				//CONSUPAGO
				data.setIdEmpresa( exportTable.getString("BP_EMPRESA") );
				data.setNombreEmpresa( exportTable.getString("NOM_EMPRESA") );
				data.setSiglaEmpresaOrg( exportTable.getString("SIGLA_EMPRESA") );
				data.setConvenioH2H( exportTable.getString("CONVENIO_EMPRESA") );
				data.setTelCel( exportTable.getString("TEL_CEL") );
				data.setFecEnvSms( exportTable.getString("FEC_ENV_SMS") );
				data.setRfc( exportTable.getString("RFC_BENEFICIARIO") );
				data.setCp( exportTable.getString("CP") );
				data.setCurp( exportTable.getString("CURP") );
				data.setFechaNac(exportTable.getString("FECHA_NAC") );
				
				returnList.add( data );
			}
		
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E004_GENERAI610RECO :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
