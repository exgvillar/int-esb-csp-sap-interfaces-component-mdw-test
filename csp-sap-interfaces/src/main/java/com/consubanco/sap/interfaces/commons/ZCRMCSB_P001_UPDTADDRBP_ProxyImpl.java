package com.consubanco.sap.interfaces.commons;

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


public class ZCRMCSB_P001_UPDTADDRBP_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMCSB_P001_UPDTADDRBP_ProxyImpl.class );
	
	
	public ZCRMCSB_P001_UPDTADDRBP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCSB_P001_UPDTADDRBP" );
			if(ft == null)
				throw new RuntimeException("ZCRMCSB_P001_UPDTADDRBP not found in SAP.");
			
			function = ft.getFunction();
			
		
			// general params
			Iterator<ProxyInputParameter> iterGeneralParams = inputParamters.getGeneralParam().iterator();
			while( iterGeneralParams.hasNext() ) {
				ProxyInputParameter inputParam = iterGeneralParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					}	
				
			}
			
			
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_ADDRESS");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ArrayList<ProxyInputParameter>  recordParams = (ArrayList<ProxyInputParameter>)iterRecord.next();
				Iterator<ProxyInputParameter> iterRecordParams = recordParams.iterator();
				while( iterRecordParams.hasNext() ) {
					ProxyInputParameter inputParam = iterRecordParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}						
				}
			}
			

			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_ADDRESS");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMCSB_P001_UPDTADDRBP_OutputData tableData = new ZCRMCSB_P001_UPDTADDRBP_OutputData();
				
				tableData.setAddressId( data.getString("ADDRESS_ID") );
				tableData.setAddressTypeId( data.getString("ADDRESS_TYPE") ); 
				tableData.setAddressTypeDesc( data.getString("ADDTYPE_DESC") ); 
				tableData.setAddressTypeViaId( data.getString("ADDRESS_TYPEVIA") );
				tableData.setAddressTypeViaDesc( data.getString("ADDTVIA_DESC") ); 
				tableData.setStreet( data.getString("STREET") );
				tableData.setInternalNumber( data.getString("INTERNALNUMBER") );
				tableData.setExternalNumber( data.getString("EXTERNALNUMBER") );
				tableData.setZipCode( data.getString("ZIPCODE") );
				tableData.setSuburb( data.getString("SUBURB") );
				tableData.setSettlementTypeId( data.getString("SETTLEMENTTYPE") ); 
				tableData.setSettlementTypeDesc( data.getString("SETLTYPE_DESC") ); 
				tableData.setTown( data.getString("TOWN") );
				tableData.setTownship( data.getString("TOWNSHIP") );
				tableData.setCity( data.getString("CITY") );
				tableData.setState( data.getString("STATE") );
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
				
				tableData.setEmail( data.getString("EMAIL") );
				
			returnList.add( tableData );				
				
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P001_UPDTADDRBP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
