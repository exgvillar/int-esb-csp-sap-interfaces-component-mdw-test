package com.consupago.sap.interfaces.proxy.ivr;

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


public class ZRFC_IVR_VALGET_PARTNER_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_IVR_VALGET_PARTNER_ProxyImpl.class );
	
	public ZRFC_IVR_VALGET_PARTNER_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_IVR_VALGET_PARTNER" );
			if(ft == null)
				throw new RuntimeException("ZRFC_IVR_VALGET_PARTNER not found in SAP.");
			
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
			
						
			ZRFC_IVR_VALGET_PARTNER_OutputData output = new ZRFC_IVR_VALGET_PARTNER_OutputData();
			ArrayList<TE_MESSAGE_OutputData> messages = new ArrayList<TE_MESSAGE_OutputData>();
			
			log.info( "" +  function.getExportParameterList().getStructure("E_PERSONALDATA").toString() );
			
			if( !function.getExportParameterList().getStructure("E_PERSONALDATA").getString("IDBUSINESSPARTNER").equals("") )
			{
				output.setIdBussinesPartner( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("IDBUSINESSPARTNER") );
				output.setPaternalName( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("PATERNALNAME") );
				output.setMaternalName( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("MATERNALNAME") );
				output.setFirstName( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("FIRSTNAME") );
				output.setMiddleName( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("MIDDLENAME") );
				output.setBirthDate( function.getExportParameterList().getStructure("E_PERSONALDATA").getDate("BIRTHDATE") );
				output.setRfc( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("RFC") );
				output.setSiglaBranch( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("SIGLA_BRANCH") );
				output.setNameBranch( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("NAME_BRANCH") );
				output.setStreet( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("STREET") );
				output.setExternalNumber( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("EXTERNALNUMBER") );
				output.setInternalNumber( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("INTERNALNUMBER") );
				output.setTownship( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("TOWNSHIP") );
				output.setZipCode( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("ZIPCODE") );
				output.setCity( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("CITY") );
				output.setCountry( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("COUNTRY") );
				output.setNumberPhone( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("NUMBERPHONE") );
				output.setNumberCel( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("NUMBERCEL") );
				output.setNumberPhoneJob( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("NUMBERPHONEJOB") );
				output.setSiglaPosition( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("SIGLA_POSITION") );
				output.setNamePosition( function.getExportParameterList().getStructure("E_PERSONALDATA").getString("NAME_POSITION") );	
			}
			
					
			TE_MESSAGE_OutputData tableData = new TE_MESSAGE_OutputData();
			
			tableData.setKey( "" );
			tableData.setDescription( function.getExportParameterList().getString("E_MESSAGE")  );
			tableData.setClasification( "" );
			messages.add( tableData );
							
			output.setMessages(messages);
			returnList.add( output );
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_IVR_VALGET_PARTNER" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}	
}
