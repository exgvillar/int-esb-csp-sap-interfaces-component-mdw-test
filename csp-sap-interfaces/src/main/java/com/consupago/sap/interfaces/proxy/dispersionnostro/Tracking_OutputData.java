/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class Tracking_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero;
	private String estatus;
	
	private String user;
	private String horaInicial;
	private String minutoInicial;
	
	private String horaFinal;
	private String minutoFinal;

	


	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getEstatus() {
		return estatus;
	}




	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}




	public String getUser() {
		return user;
	}




	public void setUser(String user) {
		this.user = user;
	}




	public String getHoraInicial() {
		return horaInicial;
	}




	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}




	public String getMinutoInicial() {
		return minutoInicial;
	}




	public void setMinutoInicial(String minutoInicial) {
		this.minutoInicial = minutoInicial;
	}




	public String getHoraFinal() {
		return horaFinal;
	}




	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}




	public String getMinutoFinal() {
		return minutoFinal;
	}




	public void setMinutoFinal(String minutoFinal) {
		this.minutoFinal = minutoFinal;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
