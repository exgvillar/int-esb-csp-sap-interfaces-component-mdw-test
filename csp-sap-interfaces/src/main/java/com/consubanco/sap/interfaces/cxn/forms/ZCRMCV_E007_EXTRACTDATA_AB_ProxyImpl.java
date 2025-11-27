package com.consubanco.sap.interfaces.cxn.forms;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.forms.model.ZTL_CRMCV_CAMPOS_AF_Model;
import com.consubanco.sap.interfaces.cxn.forms.model.ZTL_CRMCV_DOCS_AF_Model;
import com.consubanco.sap.interfaces.cxn.forms.model.ZTL_CRMCV_EXTRACTOR_AB_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMCV_E007_EXTRACTDATA_AB_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMCV_E007_EXTRACTDATA_AB_ProxyImpl.class );
	
	public ZCRMCV_E007_EXTRACTDATA_AB_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCV_E007_EXTRACTDATA_AB" );
			if(ft == null)
				throw new RuntimeException("ZCRMCV_E007_EXTRACTDATA_AB not found in SAP.");
			
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
			
			JCoStructure data = function.getExportParameterList().getStructure("E_DATA");
						
			log.info( "" +  data.toString() );
			ArrayList<ZTL_CRMCV_EXTRACTOR_AB_Model> recordList = new ArrayList<ZTL_CRMCV_EXTRACTOR_AB_Model>();
			ZCRMCV_E007_EXTRACTDATA_AB_OutputData outputData = new ZCRMCV_E007_EXTRACTDATA_AB_OutputData();
						
				
			ZTL_CRMCV_EXTRACTOR_AB_Model tableData = new ZTL_CRMCV_EXTRACTOR_AB_Model();
			
			tableData.setSolicitudId( data.getString("ID_SOLICITUD") );
			tableData.setEmpresaId( data.getString("ID_EMPRESA") );
			tableData.setConvenioId( data.getString("ID_CONVENIO") );
			
			
			ArrayList<ZTL_CRMCV_DOCS_AF_Model> documentsList = new ArrayList<ZTL_CRMCV_DOCS_AF_Model>();
			JCoTable documentsTable = data.getTable("T_DOCUMENTOS");
			for (int j = 0; j < documentsTable.getNumRows(); j++, documentsTable.nextRow() ) {
				ZTL_CRMCV_DOCS_AF_Model documentModel = new ZTL_CRMCV_DOCS_AF_Model();
				documentModel.setIdDocumento( documentsTable.getInt("ID_DOCTO") );
				documentModel.setOrder( documentsTable.getInt("ORDERN") );
				documentModel.setNombreDocumento( documentsTable.getString("DOCADOBE") );
				documentModel.setRuta( documentsTable.getString("RUTA") );
				documentModel.setNombreTecnico( documentsTable.getString("NOMTECT") );
				
				ArrayList<ZTL_CRMCV_CAMPOS_AF_Model> fieldList = new ArrayList<ZTL_CRMCV_CAMPOS_AF_Model>();
				JCoTable fieldsTable = documentsTable.getTable("T_CAMPOS");
				for (int k = 0; k < fieldsTable.getNumRows(); k++, fieldsTable.nextRow() ) {
					ZTL_CRMCV_CAMPOS_AF_Model fieldModel = new ZTL_CRMCV_CAMPOS_AF_Model();
					fieldModel.setId( fieldsTable.getString("ID_CANPO") );
					fieldModel.setValue( fieldsTable.getString("VALUE") );
					fieldModel.setFormat( fieldsTable.getInt("FORMATO") );
					if( fieldsTable.getString("ESPACIADO") == null 
							|| StringUtils.isEmpty( fieldsTable.getString("ESPACIADO") ) )
						fieldModel.setSpacing( 0 );
					else
						fieldModel.setSpacing( Integer.valueOf( fieldsTable.getString("ESPACIADO") ) );
					fieldModel.setType( fieldsTable.getInt("TIPO") );
					
					fieldList.add( fieldModel );
				}
				documentModel.setFieldList(fieldList);
				
				documentsList.add( documentModel );
			}
			tableData.setDocumentsList(documentsList);
			recordList.add( tableData );
							
			
			outputData.setDataList( recordList );
			outputData.setResult( function.getExportParameterList().getString("E_RESULT") );
			
			returnList.add( outputData );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCV_E007_EXTRACTDATA_AB" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
