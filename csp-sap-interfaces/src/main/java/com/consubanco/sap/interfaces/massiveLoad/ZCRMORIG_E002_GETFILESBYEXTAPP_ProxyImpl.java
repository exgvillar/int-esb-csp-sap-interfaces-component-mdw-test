package com.consubanco.sap.interfaces.massiveLoad;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.massiveLoad.model.ZTT_File_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImpl.class );
	
	
	public ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORIG_E002_GETFILESBYEXTAPP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORIG_E002_GETFILESBYEXTAPP not found in SAP.");
			
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
			
			log.info("InputParameters :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("OutputParameters :: " + function.getExportParameterList().toString() );

			JCoTable dataTbl = function.getExportParameterList().getTable("E_OPPORTUNITIES");
			log.info( "" +  dataTbl.toString() );
			for (int i = 0; i < dataTbl.getNumRows(); i++, dataTbl.nextRow() ) {
				ZCRMORIG_E002_GETFILESBYEXTAPP_OutputData data = new ZCRMORIG_E002_GETFILESBYEXTAPP_OutputData();
				data.setOpportunityId( dataTbl.getString("E_OPPORTUNITYID") );
				data.setCaseId( dataTbl.getString("E_CASEID") );
				data.setSourceChannel( dataTbl.getString("E_SOURCECHANNEL") );
				
				JCoTable dataFileTbl = dataTbl.getTable("E_TABLEFILES");
				log.info( "" +  dataFileTbl.toString() );
				ArrayList<ZTT_File_Model> files = new ArrayList<ZTT_File_Model>();
				for (int j = 0; j < dataFileTbl.getNumRows(); j++, dataFileTbl.nextRow() ) {
					ZTT_File_Model file = new ZTT_File_Model();
					file.setFileName( dataFileTbl.getString("E_FILENAME") );
					file.setUrl( dataFileTbl.getString("E_URL") );
					files.add( file );
				}
				data.setFiles( files );
				returnList.add( data );
			}
				
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORIG_E002_GETFILESBYEXTAPP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
