/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cis;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_CIS_DATOS_ADDRESS_BP_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String tipoDireccion = null;
	
	private String calle = null;

	private String numeroExterior = null;
	
	private String numeroInterior = null;
	
	private String colonia = null;
	
	private String delegacionMunicipio = null;
	
	private String ciudad = null;
	
	private String estado = null;
	
	private String cp = null;
	
	
	/**
	* 
	*/
	public ZRFC_CIS_DATOS_ADDRESS_BP_OutputData() {
		super();
	}

	
	
	


	/**
	 * @return the tipoDireccion
	 */
	public String getTipoDireccion() {
		return tipoDireccion;
	}






	/**
	 * @param tipoDireccion the tipoDireccion to set
	 */
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}






	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}






	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}






	/**
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}






	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}






	/**
	 * @return the numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}






	/**
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}






	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}






	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}






	/**
	 * @return the delegacionMunicipio
	 */
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}






	/**
	 * @param delegacionMunicipio the delegacionMunicipio to set
	 */
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}






	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}






	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}






	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}






	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}






	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}






	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
