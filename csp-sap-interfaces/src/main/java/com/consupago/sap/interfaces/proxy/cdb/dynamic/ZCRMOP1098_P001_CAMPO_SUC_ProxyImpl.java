package com.consupago.sap.interfaces.proxy.cdb.dynamic;

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
import com.sap.conn.jco.JCoTable;

public class ZCRMOP1098_P001_CAMPO_SUC_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P001_CAMPO_SUC_ProxyImpl.class );
	
	public ZCRMOP1098_P001_CAMPO_SUC_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMOP1098_P001_CAMPO_SUC");
			if(ft == null)
	            throw new RuntimeException("ZCRMOP1098_P001_CAMPO_SUC not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("T_CAMPOS");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMOP1098_P001_CAMPO_SUC_OutputData output = new ZCRMOP1098_P001_CAMPO_SUC_OutputData();
				output.setIdClasificacion( data.getString("ZID_CLASIF") );
				output.setIdDocumento( data.getString("ZID_DOCTO") );
				output.setIdCampo( data.getString("ZID_CAMPO") );
				output.setDescripcion( data.getString("ZDESCRIPCION") );
				output.setNombreTecnico( data.getString("ZNOM_TECNICO") );
				output.setMaxLength( data.getString("ZLONG_CAMPO") );
				output.setVisibleFlag( data.getString("ZCAMPO_VIS") );
				
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMOP1098_P001_CAMPO_SUC" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
