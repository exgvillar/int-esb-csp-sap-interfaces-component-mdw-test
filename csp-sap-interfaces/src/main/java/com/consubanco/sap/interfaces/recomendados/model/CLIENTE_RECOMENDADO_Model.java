package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author omar.corona
 *
 */
public class CLIENTE_RECOMENDADO_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private DISTRIBUIDOR_Model distribuidor = null;	
	
	private EMPRESA_Model empresa = null;
	
	private String businessPartner = null;	
	
	private String nucleoCliente = null;	
	
	private String nombreRegion = null;	
	
	private String numSucursal = null;
	
	private String nombreSucursal = null;	
	
	private String promotor = null;
	
	private CONVENIO_Model convenio = null;
	
	private String numeroCliente = null;
	
	private String numeroSolicitud = null;
	
	private String nombre1 = null;
	
	private String nombre2 = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private String RFC = null;
	
	private String montoCredito = null;
	
	private String descuento = null;
	
	private String plazoCredito = null;
	
	private Date fechaInicioSolicitud = null;
	
	private Date fechaCompra = null;
	
	private String incidencia = null;

	private REGION_Model region = null;	
	
	private SUCURSAL_Model sucursal = null;	
	
	
	
	public CLIENTE_RECOMENDADO_Model() {
		super();
	}

	
	
	/**
	 * @return the distribuidor
	 */
	public DISTRIBUIDOR_Model getDistribuidor() {
		return distribuidor;
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
	 * @return the nombreRegion
	 */
	public String getNombreRegion() {
		return nombreRegion;
	}



	/**
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}



	public String getNumSucursal() {
		return numSucursal;
	}



	public void setNumSucursal(String numSucursal) {
		this.numSucursal = numSucursal;
	}



	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}



	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}



	/**
	 * @return the promotor
	 */
	public String getPromotor() {
		return promotor;
	}



	/**
	 * @param promotor the promotor to set
	 */
	public void setPromotor(String promotor) {
		this.promotor = promotor;
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
	 * @return the numeroCliente
	 */
	public String getNumeroCliente() {
		return numeroCliente;
	}



	/**
	 * @param numeroCliente the numeroCliente to set
	 */
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
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
	 * @return the montoCredito
	 */
	public String getMontoCredito() {
		return montoCredito;
	}



	/**
	 * @param montoCredito the montoCredito to set
	 */
	public void setMontoCredito(String montoCredito) {
		this.montoCredito = montoCredito;
	}



	/**
	 * @return the descuento
	 */
	public String getDescuento() {
		return descuento;
	}



	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}



	/**
	 * @return the plazoCredito
	 */
	public String getPlazoCredito() {
		return plazoCredito;
	}



	/**
	 * @param plazoCredito the plazoCredito to set
	 */
	public void setPlazoCredito(String plazoCredito) {
		this.plazoCredito = plazoCredito;
	}



	/**
	 * @return the fechaInicioSolicitud
	 */
	public Date getFechaInicioSolicitud() {
		return fechaInicioSolicitud;
	}



	/**
	 * @param fechaInicioSolicitud the fechaInicioSolicitud to set
	 */
	public void setFechaInicioSolicitud(Date fechaInicioSolicitud) {
		this.fechaInicioSolicitud = fechaInicioSolicitud;
	}



	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}



	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	/**
	 * @return the incidencia
	 */
	public String getIncidencia() {
		return incidencia;
	}



	/**
	 * @param incidencia the incidencia to set
	 */
	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}



	/**
	 * @param distribuidor the distribuidor to set
	 */
	public void setDistribuidor(DISTRIBUIDOR_Model distribuidor) {
		this.distribuidor = distribuidor;
	}



	/**
	 * @return the region
	 */
	public REGION_Model getRegion() {
		return region;
	}



	/**
	 * @param region the region to set
	 */
	public void setRegion(REGION_Model region) {
		this.region = region;
	}



	/**
	 * @return the sucursal
	 */
	public SUCURSAL_Model getSucursal() {
		return sucursal;
	}



	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(SUCURSAL_Model sucursal) {
		this.sucursal = sucursal;
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



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
