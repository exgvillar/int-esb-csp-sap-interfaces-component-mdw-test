package com.consubanco.sap.interfaces.bt;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bt.model.ZTL_PHONE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl.class );
	
	public ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMBT_E001_BUSCA_TEL_BP" );
			if(ft == null)
				throw new RuntimeException("ZCRMBT_E001_BUSCA_TEL_BP not found in SAP.");
			
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
			
//			log.info( function.getImportParameterList().toString() );
			function.execute(destination);
			
			ZCRMBT_E001_BUSCA_TEL_BP_OutputData data = new ZCRMBT_E001_BUSCA_TEL_BP_OutputData();
			data.setBp( function.getExportParameterList().getString("E_BP") );
			data.setInterlocutorFunction( function.getExportParameterList().getString("E_TIPO_BP") );
			
			JCoTable dataTable = function.getExportParameterList().getTable("ET_TELEFONOS");
			
			log.info( "" +  dataTable.toString() );
			ArrayList<ZTL_PHONE_Model> phonesList = new ArrayList<ZTL_PHONE_Model>();
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {
				ZTL_PHONE_Model tableData = new ZTL_PHONE_Model();
				tableData.setAddressType( dataTable.getString("TIPO_DIRECCION") );
				tableData.setPhoneType( dataTable.getString("TIPO_TELEFONO") );
				tableData.setPhoneNumber( dataTable.getString("TELEFONO") );
				phonesList.add( tableData );	
			}	
			data.setPhones( phonesList );
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMBT_E001_BUSCA_TEL_BP :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}

	
}
