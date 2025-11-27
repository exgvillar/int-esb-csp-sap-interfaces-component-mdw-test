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
public class ZRFC_PROMO_X_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3782086802587832845L;

	private String promotorBPId = null;
	
	private String promotorName = null;
	
			
	/**
	 * 
	 */
	public ZRFC_PROMO_X_SUCURSAL_OutputData() {
		super();
	}

	


	/**
	 * @return the promotorBPId
	 */
	public String getPromotorBPId() {
		return promotorBPId;
	}




	/**
	 * @param promotorBPId the promotorBPId to set
	 */
	public void setPromotorBPId(String promotorBPId) {
		this.promotorBPId = promotorBPId;
	}




	/**
	 * @return the promotorName
	 */
	public String getPromotorName() {
		return promotorName;
	}




	/**
	 * @param promotorName the promotorName to set
	 */
	public void setPromotorName(String promotorName) {
		this.promotorName = promotorName;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
