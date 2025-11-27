package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author omar.corona
 *
 */
public class CLIENTE_REFIERE_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String businessPartner = null;
	
	private String nucleoCliente = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private String nombre1 = null;
	
	private String nombre2 = null;
	
	private String RFC = null;
	
	private DISTRIBUIDOR_Model distribuidor = null;
	
	private EMPRESA_Model empresa = null;
	
	private String numSucursal = null;
	
	private String nombreSucursal = null;
	
	private String telefonoPrincipal = null;
	
	private String telefonoSecundario = null;
	
	private String montoPago = null;
	
	private String referenciaPago = null;
	
	private Date fechaVencimiento = null;

	private String siglasdistribuidor = null;
	
	private CONVENIO_Model convenio = null;
	
	private String numeroSolicitud = null;
	
	public CLIENTE_REFIERE_Model() {
		super();
	}

	

	/**
	 * @return the businessPartner
	 */
	public String getBusinessPartner() {
		return businessPartner;
	}



	/**
	 * @param businessPartner the businessPartner to set
	 */
	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}



	/**
	 * @return the nucleoCliente
	 */
	public String getNucleoCliente() {
		return nucleoCliente;
	}



	/**
	 * @param nucleoCliente the nucleoCliente to set
	 */
	public void setNucleoCliente(String nucleoCliente) {
		this.nucleoCliente = nucleoCliente;
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
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}



	/**
	 * @param nombre1 the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}



	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}



	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}



	/**
	 * @return the rFC
	 */
	public String getRFC() {
		return RFC;
	}



	/**
	 * @param rFC the rFC to set
	 */
	public void setRFC(String rFC) {
		RFC = rFC;
	}





	/**
	 * @return the distribuidor
	 */
	public DISTRIBUIDOR_Model getDistribuidor() {
		return distribuidor;
	}



	/**
	 * @param distribuidor the distribuidor to set
	 */
	public void setDistribuidor(DISTRIBUIDOR_Model distribuidor) {
		this.distribuidor = distribuidor;
	}



	/**
	 * @return the telefonoPrincipal
	 */
	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}



	/**
	 * @param telefonoPrincipal the telefonoPrincipal to set
	 */
	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}



	/**
	 * @return the telefonoSecundario
	 */
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}



	/**
	 * @param telefonoSecundario the telefonoSecundario to set
	 */
	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}



	/**
	 * @return the montoPago
	 */
	public String getMontoPago() {
		return montoPago;
	}



	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}



	/**
	 * @return the referenciaPago
	 */
	public String getReferenciaPago() {
		return referenciaPago;
	}



	/**
	 * @param referenciaPago the referenciaPago to set
	 */
	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}


	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}



	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	/**
	 * @return the siglasdistribuidor
	 */
	public String getSiglasdistribuidor() {
		return siglasdistribuidor;
	}



	/**
	 * @param siglasdistribuidor the siglasdistribuidor to set
	 */
	public void setSiglasdistribuidor(String siglasdistribuidor) {
		this.siglasdistribuidor = siglasdistribuidor;
	}



	/**
	 * @return the convenio
	 */
	public CONVENIO_Model getConvenio() {
		return convenio;
	}



	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(CONVENIO_Model convenio) {
		this.convenio = convenio;
	}



	/**
	 * @return the numeroSolicitud
	 */
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}



	/**
	 * @param numeroSolicitud the numeroSolicitud to set
	 */
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}



	/**
	 * @return the empresa
	 */
	public EMPRESA_Model getEmpresa() {
		return empresa;
	}



	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EMPRESA_Model empresa) {
		this.empresa = empresa;
	}



	public String getNumSucursal() {
		return numSucursal;
	}



	public void setNumSucursal(String numSucursal) {
		this.numSucursal = numSucursal;
	}



	public String getNombreSucursal() {
		return nombreSucursal;
	}



	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
