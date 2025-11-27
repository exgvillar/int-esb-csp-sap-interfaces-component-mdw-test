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
public class OrganizacionCuentas_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3414218338895486082L;
	
	private String secuencia;
	private String idBanco;
	private String numeroCuenta;
	private String tipoCuenta;
	private String nombreEmpresa;
	private String cuentaDispersadora;
	private String banco;
	private String clabe;
	
	
	




	public String getSecuencia() {
		return secuencia;
	}







	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}







	public String getIdBanco() {
		return idBanco;
	}







	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}







	public String getNumeroCuenta() {
		return numeroCuenta;
	}







	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}







	public String getTipoCuenta() {
		return tipoCuenta;
	}







	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}







	public String getNombreEmpresa() {
		return nombreEmpresa;
	}







	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}







	public String getCuentaDispersadora() {
		return cuentaDispersadora;
	}







	public void setCuentaDispersadora(String cuentaDispersadora) {
		this.cuentaDispersadora = cuentaDispersadora;
	}







	public String getBanco() {
		return banco;
	}







	public void setBanco(String banco) {
		this.banco = banco;
	}







	public String getClabe() {
		return clabe;
	}







	public void setClabe(String clabe) {
		this.clabe = clabe;
	}







	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
