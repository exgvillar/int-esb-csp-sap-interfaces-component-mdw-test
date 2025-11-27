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
public class ZRFC_PUESTO_BP_X_SUC_OutputData implements Serializable,
		IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3261006710737850681L;

	private String puesto = null;
	
	private String businessPartnerId = null;
	
			
	/**
	 * 
	 */
	public ZRFC_PUESTO_BP_X_SUC_OutputData() {
		super();
	}

	
	



	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}






	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}






	/**
	 * @return the businessPartnerId
	 */
	public String getBusinessPartnerId() {
		return businessPartnerId;
	}






	/**
	 * @param businessPartnerId the businessPartnerId to set
	 */
	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
