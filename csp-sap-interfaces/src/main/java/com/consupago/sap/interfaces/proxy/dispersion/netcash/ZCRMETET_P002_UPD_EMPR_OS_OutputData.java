package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMETET_P002_UPD_EMPR_OS_OutputData implements Serializable, IProxyOutputData {
	private static final long serialVersionUID = -1973049518924763481L;
	private String idOrdenServicio;
	private boolean error;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getIdOrdenServicio() {
		return idOrdenServicio;
	}
	public void setIdOrdenServicio(String idOrdenServicio) {
		this.idOrdenServicio = idOrdenServicio;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
}
