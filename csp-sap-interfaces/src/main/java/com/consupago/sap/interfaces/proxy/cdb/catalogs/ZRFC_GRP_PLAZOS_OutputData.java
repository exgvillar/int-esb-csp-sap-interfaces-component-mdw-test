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
public class ZRFC_GRP_PLAZOS_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2759111103498228051L;

	private String priceGroup = null;
	
	private String description = null;
	
	
	
	/**
	 * 
	 */
	public ZRFC_GRP_PLAZOS_OutputData() {
		super();
	}

	

	/**
	 * @return the priceGroup
	 */
	public String getPriceGroup() {
		return priceGroup;
	}



	/**
	 * @param priceGroup the priceGroup to set
	 */
	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
