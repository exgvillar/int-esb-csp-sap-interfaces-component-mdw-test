package com.consupago.sap.interfaces.proxy.applications;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZTL_SOLICITUD_Model;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl.class );
	
	
	public ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ZTL_SOLICITUD_Model> inputParams ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMAYCLN_OBTIENE_PRODUCTO" );
			if(ft == null)
				throw new RuntimeException("ZCRMAYCLN_OBTIENE_PRODUCTO not found in SAP.");
			
			function = ft.getFunction();
		
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUDES");
			Iterator<ZTL_SOLICITUD_Model> iterRecord = inputParams.iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ZTL_SOLICITUD_Model inputParam = iterRecord.next();
				tableInput.setValue("ZOBJECT_ID", inputParam.getApplicationId() );
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZTL_SOLICITUD_Model tableData = new ZTL_SOLICITUD_Model();
				
				tableData.setApplicationId( data.getString("ZNUMERO_SOLICITUD") );
				tableData.setProductId( data.getString("ZID_PRODUCTO") );
				tableData.setProductDesc( data.getString("ZDESCRIPCION_PRODUCTO") );
				tableData.setConvenioId( data.getString("ZID_CONVENIO") );
				tableData.setConvenioDesc( data.getString("ZDESCRIPCION_CONVENIO") );
				
				returnList.add( tableData );
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMAYCLN_OBTIENE_PRODUCTO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
