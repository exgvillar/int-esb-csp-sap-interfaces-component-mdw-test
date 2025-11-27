package com.consubanco.sap.interfaces.disbusrment;

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

/**
 * @author hsanchez
 *
 */
public class ZCRMCXN_E012_GETOSBYAPP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMCXN_E012_GETOSBYAPP_ProxyImpl.class );
	
	public ZCRMCXN_E012_GETOSBYAPP_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCXN_E012_GETOSBYAPP" );
			if(ft == null)
				throw new RuntimeException("ZCRMCXN_E012_GETOSBYAPP not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);			
			log.info("Function.Export: " + function.getExportParameterList().toString() );			
			
			JCoTable dataTbl = function.getExportParameterList().getTable("E_ORDENESSERV");
			log.info( "" +  dataTbl.toString() );
			for (int i = 0; i < dataTbl.getNumRows(); i++, dataTbl.nextRow() ) {
				ZCRMCXN_E012_GETOSBYAPP_OutputData tableData = new ZCRMCXN_E012_GETOSBYAPP_OutputData();

				tableData.setServiceOrderId( dataTbl.getString("ORDENSERVICIOID") );
				tableData.setServiceOrderType( dataTbl.getString("TIPOORDENSERVICIO") );
				tableData.setStatusId( dataTbl.getString("ESTATUSID") );
				tableData.setStatusDesc( dataTbl.getString("ESTATUSDESC") );
				returnList.add( tableData );	
				
			}
						
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCXN_E012_GETOSBYAPP :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
