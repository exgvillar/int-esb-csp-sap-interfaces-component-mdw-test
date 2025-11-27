package com.consubanco.sap.interfaces.sic.requests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
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

public class ZFM_SIC_DATOS_DINAMICOS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZFM_SIC_DATOS_DINAMICOS_ProxyImpl.class );
	
	public ZFM_SIC_DATOS_DINAMICOS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZFM_SIC_DATOS_DINAMICOS" );
			if(ft == null)
				throw new RuntimeException("ZFM_SIC_DATOS_DINAMICOS not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("TL_DATOS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZFM_SIC_DATOS_DINAMICOS_OutputData tableData = new ZFM_SIC_DATOS_DINAMICOS_OutputData();
				
				tableData.setDocumentId( data.getString("DOCUMENTID") );
				tableData.setDocumentDesc( data.getString("DOCUMENTNAME") );
				tableData.setFieldId( data.getString("ZKEY") );
				tableData.setFieldDesc( data.getString("NAME") );
				tableData.setValue( data.getString("VALUE") );
				
				returnList.add( tableData );
						
			}
			
			//add tipo de empleado
			//log.info( "" +  function.getExportParameterList().getStructure("TL_TIPOS_EMP").getString("ZTIPO_EMPL") );
			ZFM_SIC_DATOS_DINAMICOS_OutputData tableData = new ZFM_SIC_DATOS_DINAMICOS_OutputData();
			tableData.setDocumentId( "99999" );
			tableData.setDocumentDesc( "N/A" );
			tableData.setFieldId( "99999" );
			tableData.setFieldDesc( "tipo-empleado" );
			tableData.setValue( function.getExportParameterList().getStructure("TL_TIPOS_EMP").getString("ZTIPO_EMPL") );
			returnList.add( tableData );
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZFM_SIC_DATOS_DINAMICOS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
