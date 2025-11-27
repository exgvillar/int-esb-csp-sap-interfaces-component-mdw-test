package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author omar.corona
 *
 */
public class ORDEN_SERVICIO_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String numeroOrdenServicio = null;

	private String bpRefiere = null;
	
	private String bpReferido = null;
	
	private double montoPago = 0;
	
	private String bpEmpleadoResponsable = null;
	
	private String solClienteReferido = null;
	
	private String solClienteRefiere = null;

	private String tipoSolicitudCredito = null;
		
	private Date fechaAprobacion = null;
	
	private String observaciones = null;
	
	private String ocurrenciasPago = null;

	private String canalOrigen = null;
	
	private String referenciaPago = null;
	
	private String motivo = null;
	
	private ArrayList<String> motivos = null;

	private CLIENTE_RECOMENDADO_Model clienteRecomendado = null;
	
	private CLIENTE_REFIERE_Model clienteRefiere = null;
	
	private String estatus = null;
	
	
	public ORDEN_SERVICIO_Model() {
		super();
	}



	/**
	 * @return the numeroOrdenServicio
	 */
	public String getNumeroOrdenServicio() {
		return numeroOrdenServicio;
	}



	/**
	 * @param numeroOrdenServicio the numeroOrdenServicio to set
	 */
	public void setNumeroOrdenServicio(String numeroOrdenServicio) {
		this.numeroOrdenServicio = numeroOrdenServicio;
	}



	/**
	 * @return the bpRefiere
	 */
	public String getBpRefiere() {
		return bpRefiere;
	}



	/**
	 * @param bpRefiere the bpRefiere to set
	 */
	public void setBpRefiere(String bpRefiere) {
		this.bpRefiere = bpRefiere;
	}



	/**
	 * @return the bpReferido
	 */
	public String getBpReferido() {
		return bpReferido;
	}



	/**
	 * @param bpReferido the bpReferido to set
	 */
	public void setBpReferido(String bpReferido) {
		this.bpReferido = bpReferido;
	}




	/**
	 * @return the montoPago
	 */
	public double getMontoPago() {
		return montoPago;
	}



	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}



	/**
	 * @return the bpEmpleadoResponsable
	 */
	public String getBpEmpleadoResponsable() {
		return bpEmpleadoResponsable;
	}



	/**
	 * @param bpEmpleadoResponsable the bpEmpleadoResponsable to set
	 */
	public void setBpEmpleadoResponsable(String bpEmpleadoResponsable) {
		this.bpEmpleadoResponsable = bpEmpleadoResponsable;
	}



	/**
	 * @return the solClienteReferido
	 */
	public String getSolClienteReferido() {
		return solClienteReferido;
	}



	/**
	 * @param solClienteReferido the solClienteReferido to set
	 */
	public void setSolClienteReferido(String solClienteReferido) {
		this.solClienteReferido = solClienteReferido;
	}


	/**
	 * @return the solClienteRefiere
	 */
	public String getSolClienteRefiere() {
		return solClienteRefiere;
	}



	/**
	 * @param solClienteRefiere the solClienteRefiere to set
	 */
	public void setSolClienteRefiere(String solClienteRefiere) {
		this.solClienteRefiere = solClienteRefiere;
	}



	/**
	 * @return the fechaAprobacion
	 */
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}



	/**
	 * @param fechaAprobacion the fechaAprobacion to set
	 */
	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}



	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}



	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	/**
	 * @return the ocurrenciasPago
	 */
	public String getOcurrenciasPago() {
		return ocurrenciasPago;
	}



	/**
	 * @param ocurrenciasPago the ocurrenciasPago to set
	 */
	public void setOcurrenciasPago(String ocurrenciasPago) {
		this.ocurrenciasPago = ocurrenciasPago;
	}



	/**
	 * @return the motivos
	 */
	public ArrayList<String> getMotivos() {
		return motivos;
	}



	/**
	 * @param motivos the motivos to set
	 */
	public void setMotivos(ArrayList<String> motivos) {
		this.motivos = motivos;
	}



	/**
	 * @return the clienteRecomendado
	 */
	public CLIENTE_RECOMENDADO_Model getClienteRecomendado() {
		return clienteRecomendado;
	}



	/**
	 * @param clienteRecomendado the clienteRecomendado to set
	 */
	public void setClienteRecomendado(CLIENTE_RECOMENDADO_Model clienteRecomendado) {
		this.clienteRecomendado = clienteRecomendado;
	}



	/**
	 * @return the clienteRefiere
	 */
	public CLIENTE_REFIERE_Model getClienteRefiere() {
		return clienteRefiere;
	}



	/**
	 * @param clienteRefiere the clienteRefiere to set
	 */
	public void setClienteRefiere(CLIENTE_REFIERE_Model clienteRefiere) {
		this.clienteRefiere = clienteRefiere;
	}



	/**
	 * @return the canalOrigen
	 */
	public String getCanalOrigen() {
		return canalOrigen;
	}



	/**
	 * @param canalOrigen the canalOrigen to set
	 */
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}



	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}



	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	/**
	 * @return the tipoSolicitudCredito
	 */
	public String getTipoSolicitudCredito() {
		return tipoSolicitudCredito;
	}



	/**
	 * @param tipoSolicitudCredito the tipoSolicitudCredito to set
	 */
	public void setTipoSolicitudCredito(String tipoSolicitudCredito) {
		this.tipoSolicitudCredito = tipoSolicitudCredito;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}



	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
