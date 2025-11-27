/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class Incidencias_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String consecutivo;
	private String contadorVueltas;
	private String estatusCRM;
	private String fechaCreacion;
	private String fechaModificacion;
	private boolean flagResuelto;
	
	private String idCausa;
	private String idMotivo;
	private String mensajeRechazo1;
	private String mensajeRechazo2;
	
	

	public String getConsecutivo() {
		return consecutivo;
	}




	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}




	public String getContadorVueltas() {
		return contadorVueltas;
	}




	public void setContadorVueltas(String contadorVueltas) {
		this.contadorVueltas = contadorVueltas;
	}




	public String getEstatusCRM() {
		return estatusCRM;
	}




	public void setEstatusCRM(String estatusCRM) {
		this.estatusCRM = estatusCRM;
	}



	public String getFechaCreacion() {
		return fechaCreacion;
	}




	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}




	public String getFechaModificacion() {
		return fechaModificacion;
	}




	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}




	public boolean isFlagResuelto() {
		return flagResuelto;
	}




	public void setFlagResuelto(boolean flagResuelto) {
		this.flagResuelto = flagResuelto;
	}




	public String getIdCausa() {
		return idCausa;
	}




	public void setIdCausa(String idCausa) {
		this.idCausa = idCausa;
	}




	public String getIdMotivo() {
		return idMotivo;
	}




	public void setIdMotivo(String idMotivo) {
		this.idMotivo = idMotivo;
	}




	public String getMensajeRechazo1() {
		return mensajeRechazo1;
	}




	public void setMensajeRechazo1(String mensajeRechazo1) {
		this.mensajeRechazo1 = mensajeRechazo1;
	}




	public String getMensajeRechazo2() {
		return mensajeRechazo2;
	}




	public void setMensajeRechazo2(String mensajeRechazo2) {
		this.mensajeRechazo2 = mensajeRechazo2;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
