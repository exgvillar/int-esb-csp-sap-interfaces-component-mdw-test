package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMTESO_P010_PROCESA600_OutputData implements Serializable,
		IProxyOutputData {

	private static final long serialVersionUID = -4797684756306809914L;
	private String sociedad;
	private String formaPago;
	private String codigoBanco;
	private String claveBanco;
	private String referencia;
	private String monto;
	private String numOrden;
	private String moneda;
	private String tipoBeneficiario;
	private String apPatertno;
	private String apMaterno;
	private String nombre;
	private String rfc;
	private String tipoIdentificacion;
	private String numIdentificacion;
	private String tipoSolicitud;
	private String numCliente;
	private String numSolicitud;
	private String fecSolicitud;
	private String conban;
	private String idSucursal;
	private String nomSucursal;
	private String idDistribuidor;
	private String nomDistribuidor;
	private String idConvenio;
	private String nomConvenio;
	private String confro;
	private String fecAutorizacion;
	private String impAutorizado;
	private String impDescuento;
	private String plazo;
	private String scm;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String sociedad) {
		this.sociedad = sociedad;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getClaveBanco() {
		return claveBanco;
	}

	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getTipoBeneficiario() {
		return tipoBeneficiario;
	}

	public void setTipoBeneficiario(String tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	public String getApPatertno() {
		return apPatertno;
	}

	public void setApPatertno(String apPatertno) {
		this.apPatertno = apPatertno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public String getNumSolicitud() {
		return numSolicitud;
	}

	public void setNumSolicitud(String numSolicitud) {
		this.numSolicitud = numSolicitud;
	}

	public String getFecSolicitud() {
		return fecSolicitud;
	}

	public void setFecSolicitud(String fecSolicitud) {
		this.fecSolicitud = fecSolicitud;
	}

	public String getConban() {
		return conban;
	}

	public void setConban(String conban) {
		this.conban = conban;
	}

	public String getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}

	public String getNomConvenio() {
		return nomConvenio;
	}

	public void setNomConvenio(String nomConvenio) {
		this.nomConvenio = nomConvenio;
	}

	public String getConfro() {
		return confro;
	}

	public void setConfro(String confro) {
		this.confro = confro;
	}

	public String getFecAutorizacion() {
		return fecAutorizacion;
	}

	public void setFecAutorizacion(String fecAutorizacion) {
		this.fecAutorizacion = fecAutorizacion;
	}

	public String getImpAutorizado() {
		return impAutorizado;
	}

	public void setImpAutorizado(String impAutorizado) {
		this.impAutorizado = impAutorizado;
	}

	public String getImpDescuento() {
		return impDescuento;
	}

	public void setImpDescuento(String impDescuento) {
		this.impDescuento = impDescuento;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getScm() {
		return scm;
	}

	public void setScm(String scm) {
		this.scm = scm;
	}

	public String getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(String idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public String getNomDistribuidor() {
		return nomDistribuidor;
	}

	public void setNomDistribuidor(String nomDistribuidor) {
		this.nomDistribuidor = nomDistribuidor;
	}

}
