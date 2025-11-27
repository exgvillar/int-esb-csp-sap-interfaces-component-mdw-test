/**
 * 
 */
package com.consubanco.sap.interfaces.coi;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMOP1098_P006_GENERALOTE_OutputData implements Serializable,
		IProxyOutputData {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private String mandante = null;
	
	private String lote = null;
	
	private String requestId = null;
	
	private String folder = null;
	
	private String archivoNomina = null;
	
	private double solvencia = 0;
	
	private String moneda = null;
	
	private Date fechaAlta = null;
	
	private String convenio = null;
	
	private String convenioNombre = null;
	
	private String producto = null;
	
	private String productoNombre = null;
	
	private String primerNombre = null;
	
	private String segundoNombre = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private double montoDescuento = 0;
	
	private String numeroEmpleado = null;
	
	private String rfc = null;
	
	private Date fechaCambioEstatus = null;
	
	private double montoSolicitado = 0;
	
	private String plazo = null;
	
	/**
	 * 
	 */
	public ZCRMOP1098_P006_GENERALOTE_OutputData() {
		super();
	}

	


	/**
	 * @return the mandante
	 */
	public String getMandante() {
		return mandante;
	}




	/**
	 * @param mandante the mandante to set
	 */
	public void setMandante(String mandante) {
		this.mandante = mandante;
	}




	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}




	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}




	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}




	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}




	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}




	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}




	/**
	 * @return the archivoNomina
	 */
	public String getArchivoNomina() {
		return archivoNomina;
	}




	/**
	 * @param archivoNomina the archivoNomina to set
	 */
	public void setArchivoNomina(String archivoNomina) {
		this.archivoNomina = archivoNomina;
	}




	/**
	 * @return the solvencia
	 */
	public double getSolvencia() {
		return solvencia;
	}




	/**
	 * @param solvencia the solvencia to set
	 */
	public void setSolvencia(double solvencia) {
		this.solvencia = solvencia;
	}




	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}




	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}




	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}




	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	


	/**
	 * @return the convenio
	 */
	public String getConvenio() {
		return convenio;
	}




	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}




	/**
	 * @return the convenioNombre
	 */
	public String getConvenioNombre() {
		return convenioNombre;
	}




	/**
	 * @param convenioNombre the convenioNombre to set
	 */
	public void setConvenioNombre(String convenioNombre) {
		this.convenioNombre = convenioNombre;
	}




	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}




	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}




	/**
	 * @return the productoNombre
	 */
	public String getProductoNombre() {
		return productoNombre;
	}




	/**
	 * @param productoNombre the productoNombre to set
	 */
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}




	/**
	 * @return the primerNombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}




	/**
	 * @param primerNombre the primerNombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}




	/**
	 * @return the segundoNombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}




	/**
	 * @param segundoNombre the segundoNombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}




	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}




	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}




	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}




	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	



	/**
	 * @return the montoDescuento
	 */
	public double getMontoDescuento() {
		return montoDescuento;
	}




	/**
	 * @param montoDescuento the montoDescuento to set
	 */
	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}




	/**
	 * @return the numeroEmpleado
	 */
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}




	/**
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}


	

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}




	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}




	/**
	 * @return the fechaCambioEstatus
	 */
	public Date getFechaCambioEstatus() {
		return fechaCambioEstatus;
	}




	/**
	 * @param fechaCambioEstatus the fechaCambioEstatus to set
	 */
	public void setFechaCambioEstatus(Date fechaCambioEstatus) {
		this.fechaCambioEstatus = fechaCambioEstatus;
	}

	


	/**
	 * @return the montoSolicitado
	 */
	public double getMontoSolicitado() {
		return montoSolicitado;
	}




	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}




	/**
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}




	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
