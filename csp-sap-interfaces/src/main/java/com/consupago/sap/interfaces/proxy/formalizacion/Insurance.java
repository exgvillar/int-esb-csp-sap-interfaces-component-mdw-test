package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Insurance implements Serializable {
	private static final long serialVersionUID = -8420696562796368582L;
	private String insuranceinsuranceAmt;
	private String insuranceproductId;
	private String insuranceproductNm;
	private String insuranceproductCategory;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getInsuranceinsuranceAmt() {
		return insuranceinsuranceAmt;
	}

	public void setInsuranceinsuranceAmt(String insuranceinsuranceAmt) {
		this.insuranceinsuranceAmt = insuranceinsuranceAmt;
	}

	public String getInsuranceproductId() {
		return insuranceproductId;
	}

	public void setInsuranceproductId(String insuranceproductId) {
		this.insuranceproductId = insuranceproductId;
	}

	public String getInsuranceproductNm() {
		return insuranceproductNm;
	}

	public void setInsuranceproductNm(String insuranceproductNm) {
		this.insuranceproductNm = insuranceproductNm;
	}

	public String getInsuranceproductCategory() {
		return insuranceproductCategory;
	}

	public void setInsuranceproductCategory(String insuranceproductCategory) {
		this.insuranceproductCategory = insuranceproductCategory;
	}
}
