/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class ZCRMRECO_P008_SAVESO_ELEGIBILI_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean exito;
	private String mensaje;

	/**
	 * @return the exito
	 */
	public boolean isExito() {
		return exito;
	}

	/**
	 * @param exito
	 *            the exito to set
	 */
	public void setExito(boolean exito) {
		this.exito = exito;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
