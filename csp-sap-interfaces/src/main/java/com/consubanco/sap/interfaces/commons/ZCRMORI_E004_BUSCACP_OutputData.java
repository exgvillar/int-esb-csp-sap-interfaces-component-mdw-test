/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_E004_BUSCACP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String zipCode = null;
	
	private String suburb = null; //asentamiento/colonia
	
	private String settlementTypeId = null; 
	
	private String settlementTypeDesc = null;
	
	private String townshipId = null; //delegación/municipio
	
	private String townshipDesc = null;
	
	private String cityId = null; 
	
	private String cityDesc = null;
	
	private String stateId = null; 
	
	private String stateDesc = null;
	
	private String office = null; 
	
	private String zone = null;
	
	private String stateCRM = null;
	
	
	
	/**
	 * 
	 */
	public ZCRMORI_E004_BUSCACP_OutputData() {
		super();
	}

	
	
	
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}




	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}




	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}




	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}




	/**
	 * @return the settlementTypeId
	 */
	public String getSettlementTypeId() {
		return settlementTypeId;
	}




	/**
	 * @param settlementTypeId the settlementTypeId to set
	 */
	public void setSettlementTypeId(String settlementTypeId) {
		this.settlementTypeId = settlementTypeId;
	}




	/**
	 * @return the settlementTypeDesc
	 */
	public String getSettlementTypeDesc() {
		return settlementTypeDesc;
	}




	/**
	 * @param settlementTypeDesc the settlementTypeDesc to set
	 */
	public void setSettlementTypeDesc(String settlementTypeDesc) {
		this.settlementTypeDesc = settlementTypeDesc;
	}




	/**
	 * @return the townshipId
	 */
	public String getTownshipId() {
		return townshipId;
	}




	/**
	 * @param townshipId the townshipId to set
	 */
	public void setTownshipId(String townshipId) {
		this.townshipId = townshipId;
	}




	/**
	 * @return the townshipDesc
	 */
	public String getTownshipDesc() {
		return townshipDesc;
	}




	/**
	 * @param townshipDesc the townshipDesc to set
	 */
	public void setTownshipDesc(String townshipDesc) {
		this.townshipDesc = townshipDesc;
	}




	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}




	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}




	/**
	 * @return the cityDesc
	 */
	public String getCityDesc() {
		return cityDesc;
	}




	/**
	 * @param cityDesc the cityDesc to set
	 */
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}




	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}




	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}




	/**
	 * @return the stateDesc
	 */
	public String getStateDesc() {
		return stateDesc;
	}




	/**
	 * @param stateDesc the stateDesc to set
	 */
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}




	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}




	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}




	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}




	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}




	/**
	 * @return the stateCRM
	 */
	public String getStateCRM() {
		return stateCRM;
	}




	/**
	 * @param stateCRM the stateCRM to set
	 */
	public void setStateCRM(String stateCRM) {
		this.stateCRM = stateCRM;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
