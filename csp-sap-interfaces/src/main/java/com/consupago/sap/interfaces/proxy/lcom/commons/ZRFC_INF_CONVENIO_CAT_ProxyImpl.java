package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZRFC_INF_CONVENIO_CAT_ProxyImpl  {
	private static Log log = LogFactory.getLog( ZRFC_INF_CONVENIO_CAT_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_INF_CONVENIO_CAT";
	
	public ZRFC_INF_CONVENIO_CAT_ProxyImpl() {
		super();		
	}

	public ArrayList<ZIT_CONVENIO_CAT_OutputData>  executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<ZIT_CONVENIO_CAT_OutputData> returnList = new ArrayList<ZIT_CONVENIO_CAT_OutputData>();
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
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			log.info(inputParamtersList.toString() );
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("TI_CONVENIO");
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZIT_CONVENIO_CAT_OutputData output = new ZIT_CONVENIO_CAT_OutputData();
				output.setMandt(data.getString("MANDT") );
				output.setProductId(data.getString("PRODUCT_ID") );
				output.setZaltasistemaexte(data.getString("ZALTASISTEMAEXTE") );
				output.setZavaladosdiscapp(data.getString("ZAVALADOSDISCAPP") );
				output.setZcapturarava(data.getString("ZCAPTURARAVA") );
				output.setProductId2(data.getString("PRODUCT_ID2") );
				output.setProductId3(data.getString("PRODUCT_ID3") );
				output.setZempleadobase(data.getString("ZEMPLEADOBASE") );
				output.setZdisseparada(data.getString("ZDISSEPARADA") );
				output.setZz0011(data.getDate("ZZ0011") );
				output.setZz0012(data.getDate("ZZ0012") );
				output.setZllamadadecalida(data.getString("ZLLAMADADECALIDA") );
				output.setShortText(data.getString("SHORT_TEXT") );
				output.setZrequierevale(data.getString("ZREQUIEREVALE") );
				output.setZsupempoderado(data.getString("ZSUPEMPODERADO") );
				output.setZz0010(data.getString("ZZ0010") );
				output.setZempleadotienena(data.getString("ZEMPLEADOTIENENA") );
				output.setZcapturarava2(data.getString("ZCAPTURARAVA2") );
				output.setZvalidanosujetos(data.getString("ZVALIDANOSUJETOS") );
				output.setZbdsobregirado(data.getString("ZBDSOBREGIRADO") );
				output.setZvalidasujeto(data.getString("ZVALIDASUJETO") );
				output.setZdeduccionesadd(data.getString("ZDEDUCCIONESADD") );
				output.setZgrupconv(data.getString("ZGRUPCONV") );
				output.setZtipoamortiza(data.getString("ZTIPOAMORTIZA") );
				output.setZcvebrms(data.getString("ZCVEBRMS") );
				output.setZgpoanalista(data.getString("ZGPOANALISTA") );
				output.setZinicjur(data.getDate("ZINICJUR") );
				output.setZfinjur(data.getDate("ZFINJUR") );
				output.setZcategoria(data.getString("ZCATEGORIA") );
				output.setZcattext(data.getString("ZCATTEXT") );

				returnList.add(output);
			}
			log.info(returnList.toString() );
			return returnList;
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
