package com.consupago.sap.interfaces.proxy.imss.pensionados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMORI_E002_GET_IMSSPENSIONAD";
	
	public ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			JCoStructure data = function.getExportParameterList().getStructure("E_DATOS");

			ZCRMORI_E002_GET_IMSSPENSIONAD_OutputData output = new ZCRMORI_E002_GET_IMSSPENSIONAD_OutputData();
				String nss= "000000000000" +data.getString("ZZNSS");
				Double prestInt = (data.getDouble("ZZIMP_MENSUAL") * data.getInt("ZZNUM_MESES"));
				output.setMandt( data.getInt("MANDT") );
				output.setObject_id( data.getString("OBJECT_ID") );
				output.setZznumprov( data.getString("ZZNUMPROV") );
				output.setZzdelegacion( data.getString("ZZDELEGACION") );
				output.setZznss( nss.substring(nss.length() -11) );
				output.setZzgrupo( data.getString("ZZGRUPO") );
				output.setZznombres( data.getString("ZZNOMBRES") );
				output.setZzpaterno( data.getString("ZZPATERNO") );
				output.setZzmaterno( data.getString("ZZMATERNO") );
				output.setZzcurp( data.getString("ZZCURP") );
				output.setZzclave( data.getString("ZZCLAVE") );
				output.setZzimp_presta( prestInt );
				output.setZzimp_mensual( data.getBigDecimal("ZZIMP_MENSUAL") );
				output.setZznum_meses( data.getInt("ZZNUM_MESES") );
				output.setZztipo_mov_immsp( data.getString("ZZTIPO_MOV_IMMSP") );
				output.setZznum_contrat( data.getString("ZZNUM_CONTRAT") );
				output.setZzref_dep( data.getString("ZZREF_DEP") );
				output.setZzarch_org( data.getString("ZZARCH_ORG") );
				output.setZzarch_reno( data.getString("ZZARCH_RENO") );
				output.setZzfecha_alta( data.getDate("ZZFECHA_ALTA") );
				output.setZzfecha_compra( data.getDate("ZZFECHA_COMPRA") );
				output.setZzf_comprado( data.getString("ZZF_COMPRADO") );
				output.setZzfecha_envio( data.getDate("ZZFECHA_ENVIO") );
				output.setZzf_enviado( data.getString("ZZF_ENVIADO") );
				output.setZzintmens( data.getDouble("ZZINTMENS") );
				output.setZzcat( data.getDouble("ZZCAT") );
				output.setZzimpprest( data.getDouble("ZZIMP_PRESTA") );

				JCoTable tableRet = function.getExportParameterList().getTable("E_PRODUCTS");
				boolean esLcom = false;
				for (int i = 0; i < tableRet.getNumRows(); i++, tableRet.nextRow() ) {
					Integer id = tableRet.getInt("PRODUCT");
					if (id > 10000000){
						output.setIdconvenio(id);
						output.setConvenioName(tableRet.getString("DESCRIPTION"));
						output.setEmpresaConvID(tableRet.getInt("ORG_VTAS"));
						output.setEmpresaConvName( tableRet.getString("DESC_ORGVTA") );
					} else {
						output.setIdProducto( id);
						output.setProductoName( tableRet.getString("DESCRIPTION"));
						output.setEmpresaProdId( tableRet.getInt("ORG_VTAS"));
						output.setEmpresaProdName( tableRet.getString("DESC_ORGVTA") );
					}
					JCoTable tablCat = tableRet.getTable("CATEGORIAS");
					for ( int j = 0; j < tablCat.getNumRows(); j++, tablCat.nextRow() ){
						String categoria = tablCat.getString("CATEGORY_ID");
						esLcom = ( !esLcom )?(categoria.toUpperCase().contains("LCOM") )?true:false:esLcom;
					}
				}
				output.setLcom(esLcom);
//				System.out.println( tableRet.toString() );
				log.info( "" +  data.toString() );

				returnList.add( output );
				
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
