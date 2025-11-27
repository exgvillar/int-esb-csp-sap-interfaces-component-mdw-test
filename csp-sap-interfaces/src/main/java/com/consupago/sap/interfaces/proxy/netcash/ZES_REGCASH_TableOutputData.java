/**
 * 
 */
package com.consupago.sap.interfaces.proxy.netcash;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZES_REGCASH_TableOutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 412675718692266751L;

	private String idSolicitud = null;
	
	private String bancoABM = null;
	
	private String clabe = null;
	
	private double montoMaximoDispersar = 0;
	
	private String nombre1 = null;
	
	private String nombre2 = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private String rfc = null;
	
	
	
	/**
* 
*/
	public ZES_REGCASH_TableOutputData() {
		super();
	}

	
	


	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}





	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}





	/**
	 * @return the bancoABM
	 */
	public String getBancoABM() {
		return bancoABM;
	}





	/**
	 * @param bancoABM the bancoABM to set
	 */
	public void setBancoABM(String bancoABM) {
		this.bancoABM = bancoABM;
	}





	/**
	 * @return the clabe
	 */
	public String getClabe() {
		return clabe;
	}





	/**
	 * @param clabe the clabe to set
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}





	/**
	 * @return the montoMaximoDispersar
	 */
	public double getMontoMaximoDispersar() {
		return montoMaximoDispersar;
	}





	/**
	 * @param montoMaximoDispersar the montoMaximoDispersar to set
	 */
	public void setMontoMaximoDispersar(double montoMaximoDispersar) {
		this.montoMaximoDispersar = montoMaximoDispersar;
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





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
