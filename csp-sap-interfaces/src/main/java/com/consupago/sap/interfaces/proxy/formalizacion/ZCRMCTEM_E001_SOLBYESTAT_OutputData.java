/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author olan
 *
 */
public class ZCRMCTEM_E001_SOLBYESTAT_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2484282174128662999L;
	private ArrayList<String> requestIdList;
	public ArrayList<String> getRequestIdList() {
		return requestIdList;
	}
	public void setRequestIdList(ArrayList<String> requestIdList) {
		this.requestIdList = requestIdList;
	}
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.DEFAULT_STYLE);
	}

	
	
	

}
