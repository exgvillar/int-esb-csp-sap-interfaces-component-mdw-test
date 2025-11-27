package com.consubanco.sap.interfaces.cxn.forms.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_P102_PDF_FOLIOCC_Model implements Serializable {

	private static final long serialVersionUID = -2964962166008427160L;

	private Integer i_solicitud = 0;
	private Date i_fecha = new Date();
	private Integer i_folio = 0;
	
	

	public ZCRMORI_P102_PDF_FOLIOCC_Model() {
		super();
	}

	public Integer getI_solicitud() {
		return i_solicitud;
	}

	public void setI_solicitud(Integer i_solicitud) {
		this.i_solicitud = i_solicitud;
	}

	public Date getI_fecha() {
		return i_fecha;
	}

	public void setI_fecha(Date i_fecha) {
		this.i_fecha = i_fecha;
	}

	public Integer getI_folio() {
		return i_folio;
	}

	public void setI_folio(Integer i_folio) {
		this.i_folio = i_folio;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
