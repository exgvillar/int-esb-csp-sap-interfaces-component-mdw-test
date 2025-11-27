/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_CONVE_X_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1682376463489343654L;

	private String convenioId = null;
	
	private String convenioShortText = null;
	
	private String idOrgVentas = null;
	
	private String orgVentasShortText = null;
	
	
	/**
	 * 
	 */
	public ZRFC_CONVE_X_SUCURSAL_OutputData() {
		super();
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
	 * @return the convenioShortText
	 */
	public String getConvenioShortText() {
		return convenioShortText;
	}



	/**
	 * @param convenioShortText the convenioShortText to set
	 */
	public void setConvenioShortText(String convenioShortText) {
		this.convenioShortText = convenioShortText;
	}



	/**
	 * @return the idOrgVentas
	 */
	public String getIdOrgVentas() {
		return idOrgVentas;
	}



	/**
	 * @param idOrgVentas the idOrgVentas to set
	 */
	public void setIdOrgVentas(String idOrgVentas) {
		this.idOrgVentas = idOrgVentas;
	}



	/**
	 * @return the orgVentasShortText
	 */
	public String getOrgVentasShortText() {
		return orgVentasShortText;
	}



	/**
	 * @param orgVentasShortText the orgVentasShortText to set
	 */
	public void setOrgVentasShortText(String orgVentasShortText) {
		this.orgVentasShortText = orgVentasShortText;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
