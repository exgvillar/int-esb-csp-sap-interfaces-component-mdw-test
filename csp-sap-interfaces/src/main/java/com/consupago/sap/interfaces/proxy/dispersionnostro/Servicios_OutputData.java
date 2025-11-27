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
public class Servicios_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String concepto;
	private String estatus;
	private String fechaAprobacion;
	private String fechaCreacion;
	private String fechaEmision;
	private String fechaVigencia;
	private String idCompetidor;
	private String importeLiquidacion;
	private String nombreCompetidor;
	private String numeroCuenta;
	private String idOrdenServicio;
	private String referenciaPago;
	private String tipoPago;
	private String tipo;



	public String getConcepto() {
		return concepto;
	}



	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getFechaAprobacion() {
		return fechaAprobacion;
	}



	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}



	public String getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public String getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public String getFechaVigencia() {
		return fechaVigencia;
	}



	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}



	public String getIdCompetidor() {
		return idCompetidor;
	}



	public void setIdCompetidor(String idCompetidor) {
		this.idCompetidor = idCompetidor;
	}



	public String getImporteLiquidacion() {
		return importeLiquidacion;
	}



	public void setImporteLiquidacion(String importeLiquidacion) {
		this.importeLiquidacion = importeLiquidacion;
	}



	public String getNombreCompetidor() {
		return nombreCompetidor;
	}



	public void setNombreCompetidor(String nombreCompetidor) {
		this.nombreCompetidor = nombreCompetidor;
	}



	public String getNumeroCuenta() {
		return numeroCuenta;
	}



	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}



	public String getIdOrdenServicio() {
		return idOrdenServicio;
	}



	public void setIdOrdenServicio(String idOrdenServicio) {
		this.idOrdenServicio = idOrdenServicio;
	}



	public String getReferenciaPago() {
		return referenciaPago;
	}



	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}



	public String getTipoPago() {
		return tipoPago;
	}



	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
