package com.consupago.sap.interfaces.proxy.imss.pensionados;

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

public class ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMORI_E003_GET_PRODSIMSSPENS";
	
	public ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			JCoTable tableInput = function.getImportParameterList().getTable("IT_PRODUCTS");
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
//			log.info("input : " +  function.getTableParameterList().getTable("IT_PRODUCTS").toString() );
			function.execute(destination);
			JCoTable data = function.getExportParameterList().getTable("ET_PRODUCTS");

			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E003_GET_PRODSIMSSPENS_OutputData output = new ZCRMORI_E003_GET_PRODSIMSSPENS_OutputData();
				output.setProductId(data.getInt("PRODUCT"));
				output.setProductName(data.getString("DESCRIPTION"));
				output.setEmpresaId(data.getInt("ORG_VTAS"));
				output.setEmpresaName( data.getString("DESC_ORGVTA"));
				//recupero subtabla de categorias.
				JCoTable catTab =  data.getTable("CATEGORIAS");
				ArrayList<String> arrCat = new ArrayList<String>();
				boolean esLcom = false;
				for (int j = 0; j < catTab.getNumRows(); j++, catTab.nextRow() ) {
						String categoria = catTab.getString("CATEGORY_ID");
						esLcom = ( !esLcom )?(categoria.toUpperCase().contains("LCOM") )?true:false:esLcom;
						arrCat.add(categoria);
				}
				output.setIsLcom(esLcom);
				output.setCategoriasName(arrCat);
				returnList.add( output );
			}
			
			
			System.out.println("data :: " + data.toString() );
				
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
