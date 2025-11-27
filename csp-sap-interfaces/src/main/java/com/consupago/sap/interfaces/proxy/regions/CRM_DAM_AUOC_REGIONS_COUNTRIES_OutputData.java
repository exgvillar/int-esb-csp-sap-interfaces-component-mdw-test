/**
 * 
 */
package com.consupago.sap.interfaces.proxy.regions;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class CRM_DAM_AUOC_REGIONS_COUNTRIES_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String mandante = null;
	
	private String claveIdioma = null;

	private String clavePais = null;
	
	private String denominacionPais = null;
	
	private String region = null;
	
	private String denominacion = null;
	
	
	/**
* 
*/
	public CRM_DAM_AUOC_REGIONS_COUNTRIES_OutputData() {
		super();
	}

	
	
	
	/**
	 * @return the mandante
	 */
	public String getMandante() {
		return mandante;
	}




	/**
	 * @param mandante the mandante to set
	 */
	public void setMandante(String mandante) {
		this.mandante = mandante;
	}




	/**
	 * @return the claveIdioma
	 */
	public String getClaveIdioma() {
		return claveIdioma;
	}




	/**
	 * @param claveIdioma the claveIdioma to set
	 */
	public void setClaveIdioma(String claveIdioma) {
		this.claveIdioma = claveIdioma;
	}




	/**
	 * @return the clavePais
	 */
	public String getClavePais() {
		return clavePais;
	}




	/**
	 * @param clavePais the clavePais to set
	 */
	public void setClavePais(String clavePais) {
		this.clavePais = clavePais;
	}




	/**
	 * @return the denominacionPais
	 */
	public String getDenominacionPais() {
		return denominacionPais;
	}




	/**
	 * @param denominacionPais the denominacionPais to set
	 */
	public void setDenominacionPais(String denominacionPais) {
		this.denominacionPais = denominacionPais;
	}




	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}




	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}




	/**
	 * @return the denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}




	/**
	 * @param denominacion the denominacion to set
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
