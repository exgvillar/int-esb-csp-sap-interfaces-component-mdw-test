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
public class ZRFC_BP_X_USUARIO_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8153413843042941014L;

	private String businessPartnerId = null;
	
	private String businessPartnerName = null;
	
	private String cellPhone = null;
	
	/**
	 * 
	 */
	public ZRFC_BP_X_USUARIO_OutputData() {
		super();
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

	/**
	 * @return the businessPartnerName
	 */
	public String getBusinessPartnerName() {
		return businessPartnerName;
	}

	/**
	 * @param businessPartnerName the businessPartnerName to set
	 */
	public void setBusinessPartnerName(String businessPartnerName) {
		this.businessPartnerName = businessPartnerName;
	}

	
	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
