package com.consubanco.sap.interfaces.recommender;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recommender.model.Direccion_Model;
import com.consubanco.sap.interfaces.recommender.model.ZESCRMRECO_E003_Recommended;
import com.consubanco.sap.interfaces.recommender.model.ZESCRMRECO_E003_Recommender;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;

public class ZCRMRECO_E003_GETINFO_LLAMVAL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E003_GETINFO_LLAMVAL_ProxyImpl.class );
	
	public ZCRMRECO_E003_GETINFO_LLAMVAL_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E003_GETINFO_LLAMVAL" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E003_GETINFO_LLAMVAL not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_E003_GETINFO_LLAMVAL_OutputData data = new ZCRMRECO_E003_GETINFO_LLAMVAL_OutputData();
			
			ZESCRMRECO_E003_Recommended recomendado = new ZESCRMRECO_E003_Recommended();
			JCoStructure structureRecomendado = function.getExportParameterList().getStructure( "E_RECOMENDADO" );
			recomendado.setBp( structureRecomendado.getString( "O_BP" ) );
			recomendado.setRfc( structureRecomendado.getString( "O_RFC" ) );
			recomendado.setCurp( structureRecomendado.getString( "O_CURP" ) );
			recomendado.setName1( structureRecomendado.getString( "O_NAME1" ) );
			recomendado.setName2( structureRecomendado.getString( "O_NAME2" ) );
			recomendado.setApePat( structureRecomendado.getString( "O_APEPAT" ) );
			recomendado.setApeMat( structureRecomendado.getString( "O_APEMAT" ) );
						
			JCoStructure structureDireccionRecomendado = structureRecomendado.getStructure( "O_DIREC" );
			Direccion_Model direccionRecomendado = new Direccion_Model();
			direccionRecomendado.setStreet( structureDireccionRecomendado.getString( "STREET" ) );
			direccionRecomendado.setHouseNum1( structureDireccionRecomendado.getString( "HOUSE_NUM1" ) );
			direccionRecomendado.setHouseNum2( structureDireccionRecomendado.getString( "HOUSE_NUM2" ) );
			direccionRecomendado.setHomeCity( structureDireccionRecomendado.getString( "HOME_CITY" ) );
			direccionRecomendado.setCity1( structureDireccionRecomendado.getString( "CITY1" ) );
			direccionRecomendado.setCity2( structureDireccionRecomendado.getString( "CITY2" ) );
			direccionRecomendado.setPostCode1( structureDireccionRecomendado.getString( "POST_CODE1" ) );			
			direccionRecomendado.setRegion( structureDireccionRecomendado.getString( "REGION" ) );
			direccionRecomendado.setCountry( structureDireccionRecomendado.getString( "COUNTRY" ) );
			direccionRecomendado.setTelFijo( structureDireccionRecomendado.getString( "TEL_FIJO" ) );
			direccionRecomendado.setTelMov( structureDireccionRecomendado.getString( "TEL_MOV" ) );					
			recomendado.setDireccion(direccionRecomendado );
			recomendado.setSolcotizacion( structureRecomendado.getString( "O_SOLCOT" ) );
			recomendado.setClaveConvenio( structureRecomendado.getString( "O_CLAVE_CONVENIO" ) );
			recomendado.setDescConvenio( structureRecomendado.getString( "O_DESC_CONVENIO" ) );						
			data.setRecomendado(recomendado);
								
			ZESCRMRECO_E003_Recommender recomendador = new ZESCRMRECO_E003_Recommender();
			JCoStructure structureRecomendador = function.getExportParameterList().getStructure( "E_RECOMENDADOR" );
			recomendador.setBp( structureRecomendador.getString( "O_BP" ) );
			recomendador.setRfc( structureRecomendador.getString( "O_RFC" ) );
			recomendador.setCurp( structureRecomendador.getString( "O_CURP" ) );
			recomendador.setName1( structureRecomendador.getString( "O_NAME1" ) );
			recomendador.setName2( structureRecomendador.getString( "O_NAME2" ) );			
			recomendador.setApePat( structureRecomendador.getString( "O_APEPAT" ) );
			recomendador.setApeMat( structureRecomendador.getString( "O_APEMAT" ) );						
			
			JCoStructure structureDireccionRecomendador = structureRecomendador.getStructure( "O_DIREC" );
			Direccion_Model direccionRecomendador = new Direccion_Model();
			direccionRecomendador.setStreet( structureDireccionRecomendador.getString( "STREET" ) );
			direccionRecomendador.setHouseNum1( structureDireccionRecomendador.getString( "HOUSE_NUM1" ) );
			direccionRecomendador.setHouseNum2( structureDireccionRecomendador.getString( "HOUSE_NUM2" ) );
			direccionRecomendador.setHomeCity( structureDireccionRecomendador.getString( "HOME_CITY" ) );
			direccionRecomendador.setCity1( structureDireccionRecomendador.getString( "CITY1" ) );
			direccionRecomendador.setCity2( structureDireccionRecomendador.getString( "CITY2" ) );
			direccionRecomendador.setPostCode1( structureDireccionRecomendador.getString( "POST_CODE1" ) );
			direccionRecomendador.setRegion( structureDireccionRecomendador.getString( "REGION" ) );
			direccionRecomendador.setCountry( structureDireccionRecomendador.getString( "COUNTRY" ) );
			direccionRecomendador.setTelFijo( structureDireccionRecomendador.getString( "TEL_FIJO" ) );
			direccionRecomendador.setTelMov( structureDireccionRecomendador.getString( "TEL_MOV" ) );						
			recomendador.setDireccion(direccionRecomendador); 
			recomendador.setCliente( "X".equalsIgnoreCase( structureRecomendador.getString( "O_ESCLIENTE" ) ) );						
			data.setRecomendador(recomendador );
			
			returnList.add( data );	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E003_GETINFO_LLAMVAL :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
