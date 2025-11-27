/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro.lcom;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class OrdenesServicios_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idOrdServ;
	private String status;
	private String descStatus;
	private String idCompetidor;
	private String nombre1;
	private String nombre2;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Date fechaUltimoDescuento;
	private String frecPago;
	private String descFrecPago;
	private String concepto;
	private double monto;
	private String idMetodoPago;
	private String desMetodoPago;
	private String pagsTrans;
	private String referencia;
	private String bancoCompet;
	private String cuentaBancaria;
	private String claveBanco;
	private String referenciaBancaria;
	private Date fechaAprobacion;
	private double montoDescuento;

	

	public String getIdOrdServ() {
		return idOrdServ;
	}



	public void setIdOrdServ(String idOrdServ) {
		this.idOrdServ = idOrdServ;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDescStatus() {
		return descStatus;
	}



	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}



	public String getIdCompetidor() {
		return idCompetidor;
	}



	public void setIdCompetidor(String idCompetidor) {
		this.idCompetidor = idCompetidor;
	}



	public String getNombre1() {
		return nombre1;
	}



	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}



	public String getNombre2() {
		return nombre2;
	}



	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}



	


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}



	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}



	public String getApellidoMaterno() {
		return apellidoMaterno;
	}



	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}



	public Date getFechaEmision() {
		return fechaEmision;
	}



	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}



	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}



	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}



	



	public Date getFechaUltimoDescuento() {
		return fechaUltimoDescuento;
	}



	public void setFechaUltimoDescuento(Date fechaUltimoDescuento) {
		this.fechaUltimoDescuento = fechaUltimoDescuento;
	}



	public String getFrecPago() {
		return frecPago;
	}



	public void setFrecPago(String frecPago) {
		this.frecPago = frecPago;
	}



	public String getDescFrecPago() {
		return descFrecPago;
	}



	public void setDescFrecPago(String descFrecPago) {
		this.descFrecPago = descFrecPago;
	}



	public String getConcepto() {
		return concepto;
	}



	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}



	public double getMonto() {
		return monto;
	}



	public void setMonto(double monto) {
		this.monto = monto;
	}



	public String getIdMetodoPago() {
		return idMetodoPago;
	}



	public void setIdMetodoPago(String idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}



	public String getDesMetodoPago() {
		return desMetodoPago;
	}



	public void setDesMetodoPago(String desMetodoPago) {
		this.desMetodoPago = desMetodoPago;
	}



	public String getPagsTrans() {
		return pagsTrans;
	}



	public void setPagsTrans(String pagsTrans) {
		this.pagsTrans = pagsTrans;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public String getBancoCompet() {
		return bancoCompet;
	}



	public void setBancoCompet(String bancoCompet) {
		this.bancoCompet = bancoCompet;
	}



	public String getCuentaBancaria() {
		return cuentaBancaria;
	}



	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}



	public String getClaveBanco() {
		return claveBanco;
	}



	public void setClaveBanco(String claveBanco) {
		this.claveBanco = claveBanco;
	}



	public String getReferenciaBancaria() {
		return referenciaBancaria;
	}



	public void setReferenciaBancaria(String referenciaBancaria) {
		this.referenciaBancaria = referenciaBancaria;
	}



	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}



	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}



	public double getMontoDescuento() {
		return montoDescuento;
	}



	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
