package com.consubanco.sap.interfaces.commons.orgdata;

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

public class ZCRMORI_E003_BPORGAN_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E003_BPORGAN_ProxyImpl.class );
	
	public ZCRMORI_E003_BPORGAN_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E003_BPORGAN" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E003_BPORGAN not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("E_ORGAN");
						
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E003_BPORGAN_OutputData tableData = new ZCRMORI_E003_BPORGAN_OutputData();
				
				tableData.setIdOficinaVentas( data.getString("SUC_MOD_OBJID") );
				tableData.setShortnameOficinaVentas( data.getString("SUC_MOD_SHORT") );
				tableData.setNameOficinaVentas( data.getString("SUC_MOD_STEXT") );
				tableData.setIdOrganizacionVentas( data.getString("ORG_OBJID") );
				tableData.setShortnameOrganizacionVentas( data.getString("ORG_SHORT") );
				tableData.setNameOrganizacionVentas( data.getString("ORG_STEXT") );
				tableData.setIdLocalizacionOficinaVentas( data.getString("ORG_CVEOV") );
				tableData.setDescLocalizacionOficinaVentas( data.getString("ORG_LOCOV") );
				tableData.setApplyProspector( data.getString("IND_PROSPECTOR").equals("X") ? true : false );
				tableData.setBpTDCI( data.getString("IND_BPTDCI").equals("X") ? true : false );
				tableData.setSalesOfficeTDCI( data.getString("IND_MOTDCI").equals("X") ? true : false );
				tableData.setApplyNewScoring( function.getExportParameterList().getString("E_APLICANEWSCORING").equals("X") ? true : false );
				returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E003_BPORGAN" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
