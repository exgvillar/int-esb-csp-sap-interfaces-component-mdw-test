package com.consubanco.sap.interfaces.valdep.instalacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Z_OS_FECHAS_OutputData implements Serializable {
	private static final long serialVersionUID = 4189234220495795734L;
	private String zFechaDesinst;
	private String zFechaInst;
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}


	public String getzFechaDesinst() {
		return zFechaDesinst;
	}


	public void setzFechaDesinst(String zFechaDesinst) {
		this.zFechaDesinst = zFechaDesinst;
	}


	public String getzFechaInst() {
		return zFechaInst;
	}


	public void setzFechaInst(String zFechaInst) {
		this.zFechaInst = zFechaInst;
	}

		
}
