package com.consubanco.sap.interfaces.proxy.cm;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.proxy.cm.models.ZM_AMOUNT_Model;
import com.consubanco.sap.interfaces.proxy.cm.models.ZM_EMPLOYEE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl.class );
	
	public ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCOM_GET_ORGANIGRAMA" );
			if(ft == null)
				throw new RuntimeException("ZCRMCOM_GET_ORGANIGRAMA not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			log.info(" Input :: " + function.getImportParameterList().toString() );
			
			function.execute(destination);
			
			ZCRMCOM_GET_ORGANIGRAMA_OutputData data = new ZCRMCOM_GET_ORGANIGRAMA_OutputData();
			data.setBranchId( function.getExportParameterList().getString("E_SUCURSAL") );
			
			JCoTable dataTable = function.getExportParameterList().getTable("ET_RELACIONES");
			log.info( "" +  dataTable.toString() );
			ArrayList<ZM_EMPLOYEE_Model> employees = new ArrayList<ZM_EMPLOYEE_Model>();
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {
				ZM_EMPLOYEE_Model tableData = new ZM_EMPLOYEE_Model();
				tableData.setBusinessPartner( dataTable.getString("PARTNER") );
				tableData.setResponsibleEmployee( dataTable.getString("INDPROMO").equals("X") ? true : false );
				tableData.setPosition( StringUtils.trimToEmpty( dataTable.getString("PUESTO") ).replace(" ", "_").toUpperCase() );
				tableData.setName1( dataTable.getString("NOMBRE1") );
				tableData.setName2( dataTable.getString("NOMBRE2") );
				tableData.setLastName1( dataTable.getString("APEPAT") );
				tableData.setLastName2( dataTable.getString("APEMAT") );
				tableData.setRfc( dataTable.getString("REGFED") );
				tableData.setPersonalNumber( dataTable.getString("PERNO") );
				
				JCoTable dataTableAmt = dataTable.getTable("MONTOS");
				log.info( "" +  dataTableAmt.toString() );
				ArrayList<ZM_AMOUNT_Model> amounts = new ArrayList<ZM_AMOUNT_Model>();
				for (int j = 0; j < dataTableAmt.getNumRows(); j++, dataTableAmt.nextRow() ) {
					ZM_AMOUNT_Model tableDataAmt = new ZM_AMOUNT_Model();
					tableDataAmt.setType( dataTableAmt.getString("TYPEIMP") );
					tableDataAmt.setAmount( dataTableAmt.getDouble("MONTO") );
					
					amounts.add( tableDataAmt );
				}
				tableData.setAmounts( amounts );
				
				//subordinates
				JCoTable dataTableSbd = dataTable.getTable("RELBPS");
				log.info( "" +  dataTableSbd.toString() );
				ArrayList<ZM_EMPLOYEE_Model> subordinates = new ArrayList<ZM_EMPLOYEE_Model>();
				for (int k = 0; k < dataTableSbd.getNumRows(); k++, dataTableSbd.nextRow() ) {
					ZM_EMPLOYEE_Model tableDataSbd = new ZM_EMPLOYEE_Model();
					tableDataSbd.setBusinessPartner( dataTableSbd.getString("PARTNER") );
					tableDataSbd.setResponsibleEmployee( dataTableSbd.getString("INDPROMO").equals("X") ? true : false );
					tableDataSbd.setPosition( dataTableSbd.getString("PUESTO") );
					tableDataSbd.setName1( dataTableSbd.getString("NOMBRE1") );
					tableDataSbd.setName2( dataTableSbd.getString("NOMBRE2") );
					tableDataSbd.setLastName1( dataTableSbd.getString("APEPAT") );
					tableDataSbd.setLastName2( dataTableSbd.getString("APEMAT") );
					tableDataSbd.setRfc( dataTableSbd.getString("REGFED") );
					tableDataSbd.setPersonalNumber( dataTableSbd.getString("PERNO") );
					
					JCoTable dataTableSbdAmt = dataTableSbd.getTable("MONTOS");
					log.info( "" +  dataTableSbdAmt.toString() );
					ArrayList<ZM_AMOUNT_Model> amountsSbd = new ArrayList<ZM_AMOUNT_Model>();
					for (int m = 0; m < dataTableSbdAmt.getNumRows(); m++, dataTableSbdAmt.nextRow() ) {
						ZM_AMOUNT_Model tableDataAmtSbd = new ZM_AMOUNT_Model();
						tableDataAmtSbd.setType( dataTableSbdAmt.getString("TYPEIMP") );
						tableDataAmtSbd.setAmount( dataTableSbdAmt.getDouble("MONTO") );
						
						amountsSbd.add( tableDataAmtSbd );
					}
					tableDataSbd.setAmounts( amountsSbd );
					
					subordinates.add( tableDataSbd );
				}
				
				tableData.setSubordinates( subordinates );
				
				employees.add( tableData );
			}
			data.setEmployees( employees );
			
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( data );	

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCOM_GET_ORGANIGRAMA :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
