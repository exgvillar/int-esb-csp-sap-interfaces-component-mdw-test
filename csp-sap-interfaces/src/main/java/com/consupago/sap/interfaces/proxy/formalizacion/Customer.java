package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Customer implements Serializable {
	private static final long serialVersionUID = -3589018114445242466L;
	private String customerrfc;
	private String customerpaternalNm;
	private String customermiddleNm;
	private String customermaternalNm;
	private String customermaritalStatus;
	private String customeridentificationType;
	private String customeridentificationNbr;
	private String customerife;
	private String customergender;
	private String customerfirstNm;
	private String customercustomerCrm;
	private String customercurp;
	private String customerbirthDt;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getCustomerrfc() {
		return customerrfc;
	}

	public void setCustomerrfc(String customerrfc) {
		this.customerrfc = customerrfc;
	}

	public String getCustomerpaternalNm() {
		return customerpaternalNm;
	}

	public void setCustomerpaternalNm(String customerpaternalNm) {
		this.customerpaternalNm = customerpaternalNm;
	}

	public String getCustomermiddleNm() {
		return customermiddleNm;
	}

	public void setCustomermiddleNm(String customermiddleNm) {
		this.customermiddleNm = customermiddleNm;
	}

	public String getCustomermaternalNm() {
		return customermaternalNm;
	}

	public void setCustomermaternalNm(String customermaternalNm) {
		this.customermaternalNm = customermaternalNm;
	}

	public String getCustomermaritalStatus() {
		return customermaritalStatus;
	}

	public void setCustomermaritalStatus(String customermaritalStatus) {
		this.customermaritalStatus = customermaritalStatus;
	}

	public String getCustomeridentificationType() {
		return customeridentificationType;
	}

	public void setCustomeridentificationType(String customeridentificationType) {
		this.customeridentificationType = customeridentificationType;
	}

	public String getCustomeridentificationNbr() {
		return customeridentificationNbr;
	}

	public void setCustomeridentificationNbr(String customeridentificationNbr) {
		this.customeridentificationNbr = customeridentificationNbr;
	}

	public String getCustomerife() {
		return customerife;
	}

	public void setCustomerife(String customerife) {
		this.customerife = customerife;
	}

	public String getCustomergender() {
		return customergender;
	}

	public void setCustomergender(String customergender) {
		this.customergender = customergender;
	}

	public String getCustomerfirstNm() {
		return customerfirstNm;
	}

	public void setCustomerfirstNm(String customerfirstNm) {
		this.customerfirstNm = customerfirstNm;
	}

	public String getCustomercustomerCrm() {
		return customercustomerCrm;
	}

	public void setCustomercustomerCrm(String customercustomerCrm) {
		this.customercustomerCrm = customercustomerCrm;
	}

	public String getCustomercurp() {
		return customercurp;
	}

	public void setCustomercurp(String customercurp) {
		this.customercurp = customercurp;
	}

	public String getCustomerbirthDt() {
		return customerbirthDt;
	}

	public void setCustomerbirthDt(String customerbirthDt) {
		this.customerbirthDt = customerbirthDt;
	}

}
