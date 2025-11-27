/**
 * 
 */
package com.consubanco.sap.interfaces.cobranza.requests;

import java.io.Serializable;
import java.util.Date;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCOB_INFO_COMP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String siglaEmpresa = null;
	
	private String empresa = null;
	
	private String nss = null;
	
	private String numeroCuenta = null;
	
	private String solicitud = null;
	
	private Date fechaCreacionSolicitud = null;
	
	private String nombreCliente = null;
	
	private String numCompetidor = null;
	
	private String razonSocialCompetidor = null;
	
	private String nombreCortoCompetidor = null;
	
	private String nombreComercialCompetidor = null;
	
	private Date fechaEmisionCarta = null;
	
	private Date fechaVencimientoCarta = null;
	
	private Date fechaDispersionCompetidor = null;
	
	private String numCuentaCompetidor = null;
	
	private String referenciaCompetidor = null;
	
	private double montoCompetidor = 0;
	
	private Date fechaDispersion = null;
	
	private Date fechaCompra = null;
	
	private Date fechaInicioInstalacion = null;
	
	private String convenioId = null;

	private String convenio = null;
	 
	
	
	/**
	 * 
	 */
	public ZCRMCOB_INFO_COMP_OutputData() {
		super();
	}

	
	/**
	 * @return the siglaEmpresa
	 */
	public String getSiglaEmpresa() {
		return siglaEmpresa;
	}


	/**
	 * @param siglaEmpresa the siglaEmpresa to set
	 */
	public void setSiglaEmpresa(String siglaEmpresa) {
		this.siglaEmpresa = siglaEmpresa;
	}


	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}


	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}


	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}


	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}


	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}


	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	

	/**
	 * @return the fechaCreacionSolicitud
	 */
	public Date getFechaCreacionSolicitud() {
		return fechaCreacionSolicitud;
	}


	/**
	 * @param fechaCreacionSolicitud the fechaCreacionSolicitud to set
	 */
	public void setFechaCreacionSolicitud(Date fechaCreacionSolicitud) {
		this.fechaCreacionSolicitud = fechaCreacionSolicitud;
	}


	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}


	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	/**
	 * @return the numCompetidor
	 */
	public String getNumCompetidor() {
		return numCompetidor;
	}


	/**
	 * @param numCompetidor the numCompetidor to set
	 */
	public void setNumCompetidor(String numCompetidor) {
		this.numCompetidor = numCompetidor;
	}


	/**
	 * @return the razonSocialCompetidor
	 */
	public String getRazonSocialCompetidor() {
		return razonSocialCompetidor;
	}


	/**
	 * @param razonSocialCompetidor the razonSocialCompetidor to set
	 */
	public void setRazonSocialCompetidor(String razonSocialCompetidor) {
		this.razonSocialCompetidor = razonSocialCompetidor;
	}


	/**
	 * @return the nombreCortoCompetidor
	 */
	public String getNombreCortoCompetidor() {
		return nombreCortoCompetidor;
	}


	/**
	 * @param nombreCortoCompetidor the nombreCortoCompetidor to set
	 */
	public void setNombreCortoCompetidor(String nombreCortoCompetidor) {
		this.nombreCortoCompetidor = nombreCortoCompetidor;
	}


	/**
	 * @return the nombreComercialCompetidor
	 */
	public String getNombreComercialCompetidor() {
		return nombreComercialCompetidor;
	}


	/**
	 * @param nombreComercialCompetidor the nombreComercialCompetidor to set
	 */
	public void setNombreComercialCompetidor(String nombreComercialCompetidor) {
		this.nombreComercialCompetidor = nombreComercialCompetidor;
	}


	/**
	 * @return the fechaEmisionCarta
	 */
	public Date getFechaEmisionCarta() {
		return fechaEmisionCarta;
	}


	/**
	 * @param fechaEmisionCarta the fechaEmisionCarta to set
	 */
	public void setFechaEmisionCarta(Date fechaEmisionCarta) {
		this.fechaEmisionCarta = fechaEmisionCarta;
	}


	/**
	 * @return the fechaVencimientoCarta
	 */
	public Date getFechaVencimientoCarta() {
		return fechaVencimientoCarta;
	}


	/**
	 * @param fechaVencimientoCarta the fechaVencimientoCarta to set
	 */
	public void setFechaVencimientoCarta(Date fechaVencimientoCarta) {
		this.fechaVencimientoCarta = fechaVencimientoCarta;
	}


	/**
	 * @return the fechaDispersionCompetidor
	 */
	public Date getFechaDispersionCompetidor() {
		return fechaDispersionCompetidor;
	}


	/**
	 * @param fechaDispersionCompetidor the fechaDispersionCompetidor to set
	 */
	public void setFechaDispersionCompetidor(Date fechaDispersionCompetidor) {
		this.fechaDispersionCompetidor = fechaDispersionCompetidor;
	}


	/**
	 * @return the numCuentaCompetidor
	 */
	public String getNumCuentaCompetidor() {
		return numCuentaCompetidor;
	}


	/**
	 * @param numCuentaCompetidor the numCuentaCompetidor to set
	 */
	public void setNumCuentaCompetidor(String numCuentaCompetidor) {
		this.numCuentaCompetidor = numCuentaCompetidor;
	}


	/**
	 * @return the referenciaCompetidor
	 */
	public String getReferenciaCompetidor() {
		return referenciaCompetidor;
	}


	/**
	 * @param referenciaCompetidor the referenciaCompetidor to set
	 */
	public void setReferenciaCompetidor(String referenciaCompetidor) {
		this.referenciaCompetidor = referenciaCompetidor;
	}


	/**
	 * @return the montoCompetidor
	 */
	public double getMontoCompetidor() {
		return montoCompetidor;
	}


	/**
	 * @param montoCompetidor the montoCompetidor to set
	 */
	public void setMontoCompetidor(double montoCompetidor) {
		this.montoCompetidor = montoCompetidor;
	}


	/**
	 * @return the fechaDispersion
	 */
	public Date getFechaDispersion() {
		return fechaDispersion;
	}


	/**
	 * @param fechaDispersion the fechaDispersion to set
	 */
	public void setFechaDispersion(Date fechaDispersion) {
		this.fechaDispersion = fechaDispersion;
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
	 * @return the fechaInicioInstalacion
	 */
	public Date getFechaInicioInstalacion() {
		return fechaInicioInstalacion;
	}


	/**
	 * @param fechaInicioInstalacion the fechaInicioInstalacion to set
	 */
	public void setFechaInicioInstalacion(Date fechaInicioInstalacion) {
		this.fechaInicioInstalacion = fechaInicioInstalacion;
	}


	/**
	 * @return the convenioId
	 */
	public String getConvenioId() {
		return convenioId;
	}


	/**
	 * @param convenioId the convenioId to set
	 */
	public void setConvenioId(String convenioId) {
		this.convenioId = convenioId;
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


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
