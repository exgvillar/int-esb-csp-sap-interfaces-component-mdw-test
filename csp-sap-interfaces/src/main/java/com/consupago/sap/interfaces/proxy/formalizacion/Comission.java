package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Comission implements Serializable {
	private static final long serialVersionUID = 1686601296438078979L;
	private String comisioncommissionName;
	private String comisionisDeferred;
	private Double comisioncommissionAmount;
	private Date comisioncommissionDate;
	private String comisioncommissionCurrencyName;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getComisioncommissionName() {
		return comisioncommissionName;
	}

	public void setComisioncommissionName(String comisioncommissionName) {
		this.comisioncommissionName = comisioncommissionName;
	}

	public String getComisionisDeferred() {
		return comisionisDeferred;
	}

	public void setComisionisDeferred(String comisionisDeferred) {
		this.comisionisDeferred = comisionisDeferred;
	}

	public Double getComisioncommissionAmount() {
		return comisioncommissionAmount;
	}

	public void setComisioncommissionAmount(Double comisioncommissionAmount) {
		this.comisioncommissionAmount = comisioncommissionAmount;
	}

	public Date getComisioncommissionDate() {
		return comisioncommissionDate;
	}

	public void setComisioncommissionDate(Date comisioncommissionDate) {
		this.comisioncommissionDate = comisioncommissionDate;
	}

	public String getComisioncommissionCurrencyName() {
		return comisioncommissionCurrencyName;
	}

	public void setComisioncommissionCurrencyName(
			String comisioncommissionCurrencyName) {
		this.comisioncommissionCurrencyName = comisioncommissionCurrencyName;
	}
}
