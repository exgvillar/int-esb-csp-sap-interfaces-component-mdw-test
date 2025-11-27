package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_RECOMENDADO_Model;
import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_REFIERE_Model;
import com.consubanco.sap.interfaces.recomendados.model.CONVENIO_Model;
import com.consubanco.sap.interfaces.recomendados.model.DISTRIBUIDOR_Model;
import com.consubanco.sap.interfaces.recomendados.model.EMPRESA_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;

public class ZCRMRECO_E000_BPMSTARTER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E000_BPMSTARTER_ProxyImpl.class );
	
	public ZCRMRECO_E000_BPMSTARTER_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E000_BPMSTARTER" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E000_BPMSTARTER not found in SAP.");
			
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

			function.execute(destination);
			
			ZCRMRECO_E000_BPMSTARTER_OutputData data = new ZCRMRECO_E000_BPMSTARTER_OutputData();

			
			JCoStructure dataStructure = function.getExportParameterList().getStructure("ES_BPMSTARTER");
			
			data.setOperationId(dataStructure.getString("ID_ORDSERV"));
			data.setCreationDate(dataStructure.getDate("FECREA_OS"));
			data.setCanalOrigen(dataStructure.getString("CANAL_ORIG"));
			data.setCanalOrigenDesc( StringUtils.trimToEmpty( dataStructure.getString("DESC_CNLORG") ).toUpperCase() );
			
			CLIENTE_REFIERE_Model refiere = new CLIENTE_REFIERE_Model(); 
			refiere.setBusinessPartner(dataStructure.getString("BP_RECOMENDADOR"));
			refiere.setNucleoCliente(dataStructure.getString("NUCLEO_RDOR"));
			refiere.setRFC(dataStructure.getString("RFC_RDOR"));
			refiere.setNombre1(dataStructure.getString("NOMBRE1_RDOR"));
			refiere.setNombre2(dataStructure.getString("NOMBRE2_RDOR"));
			refiere.setApellidoPaterno(dataStructure.getString("APEPATE_RDOR"));
			refiere.setApellidoMaterno(dataStructure.getString("APEMATE_RDOR"));

			refiere.setNumeroSolicitud( dataStructure.getString("ID_SOL_COTIRR") );
			
			EMPRESA_Model empresaRef = new EMPRESA_Model();
			empresaRef.setId( dataStructure.getString("CLV_EMPRDOR") );
			empresaRef.setDescription( dataStructure.getString("NOM_EMPRDOR") );
			refiere.setEmpresa( empresaRef );
			
			refiere.setNumSucursal( dataStructure.getString("CLV_SUCRDOR") );
			refiere.setNombreSucursal( dataStructure.getString("NOM_SUCRDOR") );
			
			DISTRIBUIDOR_Model distribuidorRef = new DISTRIBUIDOR_Model(); 
			distribuidorRef.setDescription(dataStructure.getString("NOMREDIST_RDOR"));
			distribuidorRef.setSiglas(dataStructure.getString("SIGLADIST_RDOR"));
			refiere.setDistribuidor(distribuidorRef);
			
			CONVENIO_Model convenioRef = new CONVENIO_Model();
			convenioRef.setId(dataStructure.getString("IDCONVENI_RDOR"));
			convenioRef.setBrmsId( dataStructure.getString("BRMS_RDOR") );
			convenioRef.setDescription(dataStructure.getString("NOMCONVEN_RDOR"));
			convenioRef.setProductId( dataStructure.getString("IDPRODUCT_RDOR") );
			convenioRef.setProductDesc( dataStructure.getString("NOMPRODUC_RDOR") );
			refiere.setConvenio(convenioRef);
			
			data.setRefiere(refiere);			

			
			CLIENTE_RECOMENDADO_Model recomendado = new CLIENTE_RECOMENDADO_Model();
			recomendado.setBusinessPartner(dataStructure.getString("BP_RECOMENDADO"));
			recomendado.setNucleoCliente(dataStructure.getString("NUCLEO_RADO"));
			recomendado.setRFC(dataStructure.getString("RFC_RADO"));
			recomendado.setNombre1(dataStructure.getString("NOMBRE1_RADO"));
			recomendado.setNombre2(dataStructure.getString("NOMBRE2_RADO"));
			recomendado.setApellidoPaterno(dataStructure.getString("APEPATE_RADO"));
			recomendado.setApellidoMaterno(dataStructure.getString("APEMATE_RADO"));
			
			recomendado.setNumeroSolicitud( dataStructure.getString("ID_SOL_COTIRO") );
			
			EMPRESA_Model empresaRec = new EMPRESA_Model();
			empresaRec.setId( dataStructure.getString("CLV_EMPRADO") );
			empresaRec.setDescription( dataStructure.getString("NOM_EMPRADO") );
			recomendado.setEmpresa( empresaRec );
			
			recomendado.setNumSucursal( dataStructure.getString("CLV_SUCRADO") );
			recomendado.setNombreSucursal( dataStructure.getString("NOM_SUCRADO") );
			
			DISTRIBUIDOR_Model distribuidorRec = new DISTRIBUIDOR_Model(); 
			distribuidorRec.setDescription(dataStructure.getString("NOMREDIST_RADO"));
			distribuidorRec.setSiglas(dataStructure.getString("SIGLADIST_RADO"));
			recomendado.setDistribuidor(distribuidorRec);
			
			CONVENIO_Model convenioRec = new CONVENIO_Model();
			convenioRec.setId(dataStructure.getString("IDCONVENI_RADO"));
			convenioRec.setBrmsId(dataStructure.getString("BRMS_RADO"));
			convenioRec.setDescription(dataStructure.getString("NOMCONVEN_RADO"));
			convenioRec.setProductId( dataStructure.getString("IDPRODUCT_RADO") );
			convenioRec.setProductDesc( dataStructure.getString("NOMPRODUC_RADO") );
			recomendado.setConvenio(convenioRec);
			
			data.setRecomendado(recomendado);
			
			log.info( "" +  dataStructure.toString() );


			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E000_BPMSTARTER" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
