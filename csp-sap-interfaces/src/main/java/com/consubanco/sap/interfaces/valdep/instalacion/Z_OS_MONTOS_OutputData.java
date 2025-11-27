package com.consubanco.sap.interfaces.valdep.instalacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Z_OS_MONTOS_OutputData implements Serializable {

	private static final long serialVersionUID = 1522711741575608031L;
	private String zMontoDescuento;
	private String zMontoCredito;

	public String getzMontoDescuento() {
		return zMontoDescuento;
	}

	public void setzMontoDescuento(String zMontoDescuento) {
		this.zMontoDescuento = zMontoDescuento;
	}

	public String getzMontoCredito() {
		return zMontoCredito;
	}

	public void setzMontoCredito(String zMontoCredito) {
		this.zMontoCredito = zMontoCredito;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
