package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Contact implements Serializable {
	private static final long serialVersionUID = 854402423965605040L;
	private String contactcontactTypeNm;
	private String contactcontactNbr;
	private String contactcontactExt;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getContactcontactTypeNm() {
		return contactcontactTypeNm;
	}

	public void setContactcontactTypeNm(String contactcontactTypeNm) {
		this.contactcontactTypeNm = contactcontactTypeNm;
	}

	public String getContactcontactNbr() {
		return contactcontactNbr;
	}

	public void setContactcontactNbr(String contactcontactNbr) {
		this.contactcontactNbr = contactcontactNbr;
	}

	public String getContactcontactExt() {
		return contactcontactExt;
	}

	public void setContactcontactExt(String contactcontactExt) {
		this.contactcontactExt = contactcontactExt;
	}
}
