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
public class ZCRMRECO_P001_SAVE_ENROLREC_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String numTarea;
	private boolean exito;
	private String mensaje;
	
	
	/**
	 * @return the numTarea
	 */
	public String getNumTarea() {
		return numTarea;
	}


	/**
	 * @param numTarea the numTarea to set
	 */
	public void setNumTarea(String numTarea) {
		this.numTarea = numTarea;
	}


	/**
	 * @return the exito
	 */
	public boolean isExito() {
		return exito;
	}


	/**
	 * @param exito the exito to set
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
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
