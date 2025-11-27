package com.consubanco.sap.interfaces.commons;

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

public class ZCRMORI_E005_BUSCADDRBP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E005_BUSCADDRBP_ProxyImpl.class );
	
	
	public ZCRMORI_E005_BUSCADDRBP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E005_BUSCADDRBP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E005_BUSCADDRBP not found in SAP.");
			
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

			JCoTable data = function.getExportParameterList().getTable("E_ADDRESS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMORI_E005_BUSCADDRBP_OutputData tableData = new ZCRMORI_E005_BUSCADDRBP_OutputData();
				tableData.setAddressId( data.getString("ADDRESS_ID") );
				if( StringUtils.isEmpty( data.getString("ADDRESS_TYPE") ) )
					tableData.setAddressTypeId( "NOT_FOUND" );
				else
					tableData.setAddressTypeId( data.getString("ADDRESS_TYPE") ); 
				tableData.setAddressTypeDesc( data.getString("ADDTYPE_DESC") );
				
				if( StringUtils.isEmpty( data.getString("ADDRESS_TYPEVIA") ) )
					tableData.setAddressTypeViaId( "NOT_FOUND" );
				else
					tableData.setAddressTypeViaId( data.getString("ADDRESS_TYPEVIA") );
				tableData.setAddressTypeViaDesc( data.getString("ADDTVIA_DESC") ); 
				tableData.setStreet( data.getString("STREET") );
				tableData.setInternalNumber( data.getString("INTERNALNUMBER") );
				tableData.setExternalNumber( data.getString("EXTERNALNUMBER") );
				tableData.setZipCode( data.getString("ZIPCODE") );
				tableData.setSuburb( data.getString("SUBURB") );
				
				if( StringUtils.isEmpty( data.getString("SETTLEMENTTYPE") ) )
					tableData.setSettlementTypeId( "NOT_FOUND" );
				else
					tableData.setSettlementTypeId( data.getString("SETTLEMENTTYPE") ); 
				tableData.setSettlementTypeDesc( data.getString("SETLTYPE_DESC") ); 
				tableData.setTown( data.getString("TOWN") );
				tableData.setTownship( data.getString("TOWNSHIP") );
				tableData.setCity( data.getString("CITY") );
				tableData.setState( data.getString("STATE") );
				
				tableData.setStateDesc( data.getString("STATE_DESC") );
				
				tableData.setCountry( data.getString("COUNTRY") );
				tableData.setBetweenStreet( data.getString("BETWEENSTREET") );
				tableData.setAndStreet( data.getString("ANDSTREET") );
								
				 //phones
				if( StringUtils.isNotEmpty( data.getString("TELFIJO") ) ){
					tableData.addPhone(
							data.getString("TELFIJO") , 
							StringUtils.trimToEmpty(data.getString("EXTENCI") ), 
							"PRINCIPAL"); // 
				}
				
				if( StringUtils.isNotEmpty( data.getString("TELCELU") ) ){
					tableData.addPhone(
							data.getString("TELCELU") , 
							"" , 
							"MOVIL"); 
				}
				
				if( StringUtils.isNotEmpty( data.getString("TELFAX") ) ){
					tableData.addPhone(
							data.getString("TELFAX") , 
							StringUtils.trimToEmpty(data.getString("EXTFAX") ), 
							"FAX"); 
				}
				
				
				
				returnList.add( tableData );
				
				log.info(">>>>>"+tableData.toString());
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E005_BUSCADDRBP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
