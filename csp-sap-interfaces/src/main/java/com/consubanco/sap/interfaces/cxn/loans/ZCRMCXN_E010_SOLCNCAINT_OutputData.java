package com.consubanco.sap.interfaces.cxn.loans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.cxn.loans.model.REQUEST_CNCA_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.T_CREDITS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMCXN_E010_SOLCNCAINT_OutputData implements Serializable, IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6026422201642605793L;
	private List<REQUEST_CNCA_Model> requests;
	
	
	/**
	 * @return the requests
	 */
	public List<REQUEST_CNCA_Model> getRequests() {
		return requests;
	}


	/**
	 * @param requests the requests to set
	 */
	public void setRequests(List<REQUEST_CNCA_Model> requests) {
		this.requests = requests;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
