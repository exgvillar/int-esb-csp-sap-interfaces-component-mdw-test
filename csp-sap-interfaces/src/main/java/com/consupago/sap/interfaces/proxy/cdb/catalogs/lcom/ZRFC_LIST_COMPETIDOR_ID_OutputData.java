/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs.lcom;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_LIST_COMPETIDOR_ID_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4913157282670769838L;

	private String businessPartnerId = null;
	
	private String nameOrg1 = null;
	
	private String nameOrg2 = null;
	
	private String nameOrg3 = null;
	
	private String nameOrg4 = null;
		
	private String pago = null;
	
	private String frecuencia = null;
		
	/**
	 * 
	 */
	public ZRFC_LIST_COMPETIDOR_ID_OutputData() {
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
	 * @return the nameOrg1
	 */
	public String getNameOrg1() {
		return nameOrg1;
	}




	/**
	 * @param nameOrg1 the nameOrg1 to set
	 */
	public void setNameOrg1(String nameOrg1) {
		this.nameOrg1 = nameOrg1;
	}




	/**
	 * @return the nameOrg2
	 */
	public String getNameOrg2() {
		return nameOrg2;
	}




	/**
	 * @param nameOrg2 the nameOrg2 to set
	 */
	public void setNameOrg2(String nameOrg2) {
		this.nameOrg2 = nameOrg2;
	}




	/**
	 * @return the nameOrg3
	 */
	public String getNameOrg3() {
		return nameOrg3;
	}




	/**
	 * @param nameOrg3 the nameOrg3 to set
	 */
	public void setNameOrg3(String nameOrg3) {
		this.nameOrg3 = nameOrg3;
	}




	/**
	 * @return the nameOrg4
	 */
	public String getNameOrg4() {
		return nameOrg4;
	}




	/**
	 * @param nameOrg4 the nameOrg4 to set
	 */
	public void setNameOrg4(String nameOrg4) {
		this.nameOrg4 = nameOrg4;
	}




	/**
	 * @return the pago
	 */
	public String getPago() {
		return pago;
	}




	/**
	 * @param pago the pago to set
	 */
	public void setPago(String pago) {
		this.pago = pago;
	}




	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}




	/**
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
