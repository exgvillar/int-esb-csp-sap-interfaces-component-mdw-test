/**
 * 
 */
package com.consupago.sap.interfaces.proxy.netcash;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_DESCARGA_NETCASH_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private String loteId = null;
	
	private String caseId = null;
	
	private ArrayList<ZES_REGCASH_TableOutputData> netcashOperationsList = null;
	
	
	
	/**
* 
*/
	public ZRFC_DESCARGA_NETCASH_OutputData() {
		super();
	}

	


	/**
	 * @return the loteId
	 */
	public String getLoteId() {
		return loteId;
	}




	/**
	 * @param loteId the loteId to set
	 */
	public void setLoteId(String loteId) {
		this.loteId = loteId;
	}




	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}




	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}




	/**
	 * @return the netcashOperationsList
	 */
	public ArrayList<ZES_REGCASH_TableOutputData> getNetcashOperationsList() {
		return netcashOperationsList;
	}




	/**
	 * @param netcashOperationsList the netcashOperationsList to set
	 */
	public void setNetcashOperationsList(
			ArrayList<ZES_REGCASH_TableOutputData> netcashOperationsList) {
		this.netcashOperationsList = netcashOperationsList;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
