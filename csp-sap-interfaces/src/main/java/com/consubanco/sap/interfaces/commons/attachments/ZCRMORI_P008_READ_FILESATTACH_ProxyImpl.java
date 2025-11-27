/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMORI_P008_READ_FILESATTACH_ProxyImpl implements IStandardSAPProxy {

	private static final Log log = LogFactory.getLog(ZCRMORI_P008_READ_FILESATTACH_ProxyImpl.class);
	
	/* (non-Javadoc)
	 * @see com.consupago.sap.interfaces.proxy.IStandardSAPProxy#executeRemoteFunction(com.sap.conn.jco.JCoDestination, java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, 
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_P008_READ_FILESATTACH");
			if(ft == null)
	            throw new RuntimeException("ZCRMORI_P008_READ_FILESATTACH not found in SAP.");
			
			function = ft.getFunction();
	
			
			Iterator<ProxyInputParameter> iterator = inputParamtersList.iterator();
			
			while (iterator.hasNext()) {
				ProxyInputParameter inputParameter = iterator.next();
				if( StringUtils.trimToNull( inputParameter.getType() ) == null ){
					function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
				}else{
					if(inputParameter.getType().equals("java.util.date")){
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getDateValue());
					}else{
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
					}
					
				}
			}
			
			function.execute(destination);
		
			JCoTable data = function.getExportParameterList().getTable("ET_FILES");
			
			log.info(data.toString());
			
			ZCRMORI_P008_READ_FILESATTACH_OutputData tableData = null;
			
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow()) {
				tableData = new ZCRMORI_P008_READ_FILESATTACH_OutputData();
				
				tableData.setFileName( data.getString("FILENAME") );
				tableData.setDescription( data.getString("DESCRIP") );
				tableData.setCreateBy( data.getString("CREATED_BY") );
				tableData.setCreationDate( Formatter.formatCRMToDate(data.getString("CREATED_ON"))  );
				
				returnList.add(tableData);
			}
			

			
		} catch (AbapException abapex) {
			log.error("executing function ZCRMORI_P008_READ_FILESATTACH ", abapex);
			throw abapex;
		}finally{
			
		}
		
		return returnList;
	}

}
