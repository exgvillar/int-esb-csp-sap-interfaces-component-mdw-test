package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CreditIcbs implements Serializable {
	private static final long serialVersionUID = -6479037491050825553L;
	private Integer icbsproductIcbs;
	private String icbsoperationType;
	private String icbsbankName;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public Integer getIcbsproductIcbs() {
		return icbsproductIcbs;
	}

	public void setIcbsproductIcbs(Integer icbsproductIcbs) {
		this.icbsproductIcbs = icbsproductIcbs;
	}

	public String getIcbsoperationType() {
		return icbsoperationType;
	}

	public void setIcbsoperationType(String icbsoperationType) {
		this.icbsoperationType = icbsoperationType;
	}

	public String getIcbsbankName() {
		return icbsbankName;
	}

	public void setIcbsbankName(String icbsbankName) {
		this.icbsbankName = icbsbankName;
	}

}
