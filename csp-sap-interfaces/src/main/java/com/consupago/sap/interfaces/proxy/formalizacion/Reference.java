package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Reference implements Serializable {
	private static final long serialVersionUID = 5443866645847934699L;
	private String refrfc;
	private String refpersonalRelationTypeNm;
	private String refpersonalRelationCrm;
	private String refpaternalNm;
	private String refmiddleNm;
	private String refmaternalNm;
	private String refmaritalStatus;
	private String refife;
	private String refgender;
	private String reffirstNm;
	private String refcurp;
	private String refbirthDt;
	private ArrayList<Contact> arrContact;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getRefrfc() {
		return refrfc;
	}

	public void setRefrfc(String refrfc) {
		this.refrfc = refrfc;
	}

	public String getRefpersonalRelationTypeNm() {
		return refpersonalRelationTypeNm;
	}

	public void setRefpersonalRelationTypeNm(String refpersonalRelationTypeNm) {
		this.refpersonalRelationTypeNm = refpersonalRelationTypeNm;
	}

	public String getRefpersonalRelationCrm() {
		return refpersonalRelationCrm;
	}

	public void setRefpersonalRelationCrm(String refpersonalRelationCrm) {
		this.refpersonalRelationCrm = refpersonalRelationCrm;
	}

	public String getRefpaternalNm() {
		return refpaternalNm;
	}

	public void setRefpaternalNm(String refpaternalNm) {
		this.refpaternalNm = refpaternalNm;
	}

	public String getRefmiddleNm() {
		return refmiddleNm;
	}

	public void setRefmiddleNm(String refmiddleNm) {
		this.refmiddleNm = refmiddleNm;
	}

	public String getRefmaternalNm() {
		return refmaternalNm;
	}

	public void setRefmaternalNm(String refmaternalNm) {
		this.refmaternalNm = refmaternalNm;
	}

	public String getRefmaritalStatus() {
		return refmaritalStatus;
	}

	public void setRefmaritalStatus(String refmaritalStatus) {
		this.refmaritalStatus = refmaritalStatus;
	}

	public String getRefife() {
		return refife;
	}

	public void setRefife(String refife) {
		this.refife = refife;
	}

	public String getRefgender() {
		return refgender;
	}

	public void setRefgender(String refgender) {
		this.refgender = refgender;
	}

	public String getReffirstNm() {
		return reffirstNm;
	}

	public void setReffirstNm(String reffirstNm) {
		this.reffirstNm = reffirstNm;
	}

	public String getRefcurp() {
		return refcurp;
	}

	public void setRefcurp(String refcurp) {
		this.refcurp = refcurp;
	}

	public String getRefbirthDt() {
		return refbirthDt;
	}

	public void setRefbirthDt(String refbirthDt) {
		this.refbirthDt = refbirthDt;
	}

	public ArrayList<Contact> getArrContact() {
		return arrContact;
	}

	public void setArrContact(ArrayList<Contact> arrContact) {
		this.arrContact = arrContact;
	}
}
