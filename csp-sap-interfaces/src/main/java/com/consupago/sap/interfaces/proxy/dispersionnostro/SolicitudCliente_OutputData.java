/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class SolicitudCliente_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoPostal;
	private String firstNm;
	private String secondNM;
	private String maternalNm;
	private String paternalNM;
	private String municipality;
	private String organizationBorrowerNbr;

	private String rfc;
	private String clientId;
	private String stateId;
	private String tipoCliente;
	private String clabe;
	
	
	
	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getFirstNm() {
		return firstNm;
	}



	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}



	public String getSecondNM() {
		return secondNM;
	}



	public void setSecondNM(String secondNM) {
		this.secondNM = secondNM;
	}



	public String getMaternalNm() {
		return maternalNm;
	}



	public void setMaternalNm(String maternalNm) {
		this.maternalNm = maternalNm;
	}



	public String getPaternalNM() {
		return paternalNM;
	}



	public void setPaternalNM(String paternalNM) {
		this.paternalNM = paternalNM;
	}



	public String getMunicipality() {
		return municipality;
	}



	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}



	public String getOrganizationBorrowerNbr() {
		return organizationBorrowerNbr;
	}



	public void setOrganizationBorrowerNbr(String organizationBorrowerNbr) {
		this.organizationBorrowerNbr = organizationBorrowerNbr;
	}



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public String getClientId() {
		return clientId;
	}



	public void setClientId(String clientId) {
		this.clientId = clientId;
	}



	public String getStateId() {
		return stateId;
	}



	public void setStateId(String stateId) {
		this.stateId = stateId;
	}



	public String getTipoCliente() {
		return tipoCliente;
	}



	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}



	public String getClabe() {
		return clabe;
	}



	public void setClabe(String clabe) {
		this.clabe = clabe;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
