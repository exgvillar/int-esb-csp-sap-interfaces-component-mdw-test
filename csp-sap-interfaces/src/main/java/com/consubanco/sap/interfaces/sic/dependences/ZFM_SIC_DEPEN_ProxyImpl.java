package com.consubanco.sap.interfaces.sic.dependences;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.sic.ZUT_ADDRESS_OutputData;
import com.consubanco.sap.interfaces.sic.ZUT_PERSON_OutputData;
import com.consubanco.sap.interfaces.sic.model.ZFM_SIC_CONVENIOS_MOVS_model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZFM_SIC_DEPEN_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZFM_SIC_DEPEN_ProxyImpl.class );
	
	public ZFM_SIC_DEPEN_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZFM_SIC_DEPEN" );
			if(ft == null)
				throw new RuntimeException("ZFM_SIC_DEPEN not found in SAP.");
			
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
			
			JCoTable data = function.getExportParameterList().getTable("TL_DEP");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZFM_SIC_CONVENIOS_DET_OutputData tableData = new ZFM_SIC_CONVENIOS_DET_OutputData();
				ZUT_ADDRESS_OutputData address = new ZUT_ADDRESS_OutputData();
				
				tableData.setDependenceId( data.getString("PARTNER") );
				tableData.setDependenceDesc( data.getString("NAME") );
				tableData.setFrecuency( data.getString("ZFREC") );
				tableData.setFrecuencyInstallation( data.getString("ZATT_FREPAGCOB") );

				//TODO: quitar movementTypes para fase 2 SIC
				ArrayList<String> movementTypes = new ArrayList<String>();
				if( data.getString("ZTLALTA").equals("X") )
					movementTypes.add( "ALTA" );
				if( data.getString("ZTLBAJA").equals("X") )
					movementTypes.add( "BAJA" );
				if( data.getString("ZTLCAMB").equals("X") )
					movementTypes.add( "CAMBIO" );
				
				tableData.setMovementTypes(movementTypes);
				
				ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes = new ArrayList<ZFM_SIC_CONVENIOS_MOVS_model>();
				if( data.getString("ZTLALTA").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "ALTA" );
					attributeModel.setOrderType( data.getString("ZO_ALTA") );
					attributes.add( attributeModel );
				}
					
				if( data.getString("ZTLBAJA").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "BAJA" );
					attributeModel.setOrderType( data.getString("ZO_BAJA") );
					attributes.add( attributeModel );
				}
					
				if( data.getString("ZTLCAMB").equals("X") ){
					ZFM_SIC_CONVENIOS_MOVS_model attributeModel = new ZFM_SIC_CONVENIOS_MOVS_model();
					attributeModel.setMoveType( "CAMBIO" );
					attributeModel.setOrderType( data.getString("ZO_CAMB") );
					attributes.add( attributeModel );
				}
				tableData.setAttributes(attributes);
				
				address.setAddressId( data.getString("ADDRESS_ID") );
				address.setAddressTypeId( data.getString("ADDRESS_TYPE") );
				address.setAddressTypeDesc( data.getString("ADDTYPE_DESC") );
				address.setAddressTypeViaId( data.getString("ADDRESS_TYPEVIA") );
				address.setAddressTypeViaDesc( data.getString("ADDTVIA_DESC") );
				address.setStreet( data.getString("STREET") );
				address.setInternalNumber( data.getString("INTERNALNUMBER") );
				address.setExternalNumber( data.getString("EXTERNALNUMBER") );
				address.setZipCode( data.getString("ZIPCODE") );
				address.setSuburb( data.getString("SUBURB") );
				address.setSettlementTypeId( data.getString("SETTLEMENTTYPE") );
				address.setSettlementTypeDesc( data.getString("SETLTYPE_DESC") );
				address.setTown( data.getString("TOWN") );
				address.setTownship( data.getString("TOWNSHIP") );
				address.setCity( data.getString("CITY") );
				address.setState( data.getString("STATE") );
				address.setCountry( data.getString("COUNTRY") );
				address.setBetweenStreet( data.getString("BETWEENSTREET") );
				address.setAndStreet( data.getString("ANDSTREET") );
				
				//phones
				if( StringUtils.isNotEmpty( data.getString("TELFIJO") ) ){
					address.addPhone(
							data.getString("TELFIJO") , 
							StringUtils.trimToEmpty(data.getString("EXTENCI") ), 
							"PRINCIPAL"); // 
				}
				
				if( StringUtils.isNotEmpty( data.getString("TELCELU") ) ){
					address.addPhone(
							data.getString("TELCELU") , 
							"" , 
							"MOVIL"); 
				}
				
				if( StringUtils.isNotEmpty( data.getString("TELFAX") ) ){
					address.addPhone(
							data.getString("TELFAX") , 
							StringUtils.trimToEmpty(data.getString("EXTFAX") ), 
							"FAX"); 
				}
				
				tableData.setAddress( address );
				
				JCoTable dataPerson = data.getTable("PERSON");
				ArrayList<ZUT_PERSON_OutputData> persons = new ArrayList<ZUT_PERSON_OutputData>();
				log.info( "" +  dataPerson.toString() );
				for (int j = 0; j < dataPerson.getNumRows(); j++, dataPerson.nextRow() ) {
					ZUT_PERSON_OutputData person = new ZUT_PERSON_OutputData();
					
					person.setBusinessPartnerId( dataPerson.getString("PARTNER") );
					person.setRelationType( dataPerson.getString("RELTYP") );
					person.setName1( dataPerson.getString("NAME_FIRST") );
					person.setName2( dataPerson.getString("NAMEMIDDLE") );
					person.setLastName1( dataPerson.getString("NAME_LAST") );
					person.setLastName2( dataPerson.getString("NAME_LST2") );
					person.setPosition( dataPerson.getString("ZPUESTO") );
					person.setDegree( dataPerson.getString("DEGREE") );
					person.setEmail( dataPerson.getString("EMAIL") );
					person.setNss( dataPerson.getString("NSS") );
					person.setCurp( dataPerson.getString("CURP") );
						
					JCoTable dataPersonAdd = dataPerson.getTable("ADDRESS");
					ArrayList<ZUT_ADDRESS_OutputData> addressPersonList = new ArrayList<ZUT_ADDRESS_OutputData>();
					log.info( "" +  dataPersonAdd.toString() );
					for (int k = 0; k < dataPersonAdd.getNumRows(); k++, dataPersonAdd.nextRow() ) {
					{
						ZUT_ADDRESS_OutputData addPerson = new ZUT_ADDRESS_OutputData();
						addPerson.setAddressId( dataPersonAdd.getString("ADDRESS_ID") );
						addPerson.setAddressTypeId( dataPersonAdd.getString("ADDRESS_TYPE") );
						addPerson.setAddressTypeDesc( dataPersonAdd.getString("ADDTYPE_DESC") );
						addPerson.setAddressTypeViaId( dataPersonAdd.getString("ADDRESS_TYPEVIA") );
						addPerson.setAddressTypeViaDesc( dataPersonAdd.getString("ADDTVIA_DESC") );
						addPerson.setStreet( dataPersonAdd.getString("STREET") );
						addPerson.setInternalNumber( dataPersonAdd.getString("INTERNALNUMBER") );
						addPerson.setExternalNumber( dataPersonAdd.getString("EXTERNALNUMBER") );
						addPerson.setZipCode( dataPersonAdd.getString("ZIPCODE") );
						addPerson.setSuburb( dataPersonAdd.getString("SUBURB") );
						addPerson.setSettlementTypeId( dataPersonAdd.getString("SETTLEMENTTYPE") );
						addPerson.setSettlementTypeDesc( dataPersonAdd.getString("SETLTYPE_DESC") );
						addPerson.setTown( dataPersonAdd.getString("TOWN") );
						addPerson.setTownship( dataPersonAdd.getString("TOWNSHIP") );
						addPerson.setCity( dataPersonAdd.getString("CITY") );
						addPerson.setState( dataPersonAdd.getString("STATE") );
						addPerson.setCountry( dataPersonAdd.getString("COUNTRY") );
						addPerson.setBetweenStreet( dataPersonAdd.getString("BETWEENSTREET") );
						addPerson.setAndStreet( dataPersonAdd.getString("ANDSTREET") );
						
						//phones
						if( StringUtils.isNotEmpty( dataPersonAdd.getString("TELFIJO") ) ){
							addPerson.addPhone(
									dataPersonAdd.getString("TELFIJO") , 
									StringUtils.trimToEmpty(dataPersonAdd.getString("EXTENCI") ), 
									"PRINCIPAL"); // 
						}
						
						if( StringUtils.isNotEmpty( dataPersonAdd.getString("TELCELU") ) ){
							addPerson.addPhone(
									dataPersonAdd.getString("TELCELU") , 
									"" , 
									"MOVIL"); 
						}
						
						if( StringUtils.isNotEmpty( dataPersonAdd.getString("TELFAX") ) ){
							addPerson.addPhone(
									dataPersonAdd.getString("TELFAX") , 
									StringUtils.trimToEmpty(dataPersonAdd.getString("EXTFAX") ), 
									"FAX"); 
						}
						addressPersonList.add( addPerson );
					}
					person.setAddress( addressPersonList );
				}
				persons.add( person );
			}
				
				tableData.setPersons(persons);
				returnList.add( tableData );
						
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZFM_SIC_DEPEN" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
