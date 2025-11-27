package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_E003_GETCNCATASKBYSTS_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1150367715503192931L;
	private List<GENERIC_CATALOG_Model> status = new ArrayList<GENERIC_CATALOG_Model>();
	private String promotorBp;
	
	/**
	 * @return the status
	 */
	public List<GENERIC_CATALOG_Model> getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(List<GENERIC_CATALOG_Model> status) {
		this.status = status;
	}	
	/**
	 * @return the promotorBp
	 */
	public String getPromotorBp() {
		return promotorBp;
	}
	/**
	 * @param promotorBp the promotorBp to set
	 */
	public void setPromotorBp(String promotorBp) {
		this.promotorBp = promotorBp;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
