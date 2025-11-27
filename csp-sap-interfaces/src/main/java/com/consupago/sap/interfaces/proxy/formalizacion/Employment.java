package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Employment implements Serializable {
	private static final long serialVersionUID = -2875180615504192596L;
	private String employmentpuestoNm;
	private String employmentpuestoCrm;
	private String employmentpositionNm;
	private String employmentnetIncome;
	private String employmenthiringDt;
	private String employmentgrossIncome;
	private String employmentcompanyNm;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getEmploymentpuestoNm() {
		return employmentpuestoNm;
	}

	public void setEmploymentpuestoNm(String employmentpuestoNm) {
		this.employmentpuestoNm = employmentpuestoNm;
	}

	public String getEmploymentpuestoCrm() {
		return employmentpuestoCrm;
	}

	public void setEmploymentpuestoCrm(String employmentpuestoCrm) {
		this.employmentpuestoCrm = employmentpuestoCrm;
	}

	public String getEmploymentpositionNm() {
		return employmentpositionNm;
	}

	public void setEmploymentpositionNm(String employmentpositionNm) {
		this.employmentpositionNm = employmentpositionNm;
	}

	public String getEmploymentnetIncome() {
		return employmentnetIncome;
	}

	public void setEmploymentnetIncome(String employmentnetIncome) {
		this.employmentnetIncome = employmentnetIncome;
	}

	public String getEmploymenthiringDt() {
		return employmenthiringDt;
	}

	public void setEmploymenthiringDt(String employmenthiringDt) {
		this.employmenthiringDt = employmenthiringDt;
	}

	public String getEmploymentgrossIncome() {
		return employmentgrossIncome;
	}

	public void setEmploymentgrossIncome(String employmentgrossIncome) {
		this.employmentgrossIncome = employmentgrossIncome;
	}

	public String getEmploymentcompanyNm() {
		return employmentcompanyNm;
	}

	public void setEmploymentcompanyNm(String employmentcompanyNm) {
		this.employmentcompanyNm = employmentcompanyNm;
	}
}
