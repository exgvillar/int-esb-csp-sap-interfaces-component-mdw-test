/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.forms;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.cxn.forms.model.ZTL_CRMCV_EXTRACTOR_AB_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCV_E007_EXTRACTDATA_AB_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private ArrayList<ZTL_CRMCV_EXTRACTOR_AB_Model> dataList = null;
	
	private String result = null;
	
	
	
	/**
	 * 
	 */
	public ZCRMCV_E007_EXTRACTDATA_AB_OutputData() {
		super();
	}

	
	
	



	/**
	 * @return the dataList
	 */
	public ArrayList<ZTL_CRMCV_EXTRACTOR_AB_Model> getDataList() {
		return dataList;
	}







	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<ZTL_CRMCV_EXTRACTOR_AB_Model> dataList) {
		this.dataList = dataList;
	}







	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}







	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
