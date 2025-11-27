/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_IVR_VALGET_PARTNER_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String idBussinesPartner = null;
	
	private String rfc = null;
	
	private String paternalName = null;
	
	private String maternalName = null;
	
	private String firstName = null;
	
	private String middleName = null;
	
	private Date birthDate = null;
	
	private String street = null;
	
	private String externalNumber = null;
	
	private String internalNumber = null;
	
	private String township = null;
	
	private String zipCode = null;
	
	private String city = null;
	
	private String country = null;
	
	private String numberPhone = null;
	
	private String numberCel = null;
	
	private String numberPhoneJob = null;
	
	private String siglaPosition = null;
	
	private String namePosition = null;
	
	private String siglaBranch = null;
	
	private String nameBranch = null;
	
	private ArrayList<TE_MESSAGE_OutputData> messages = null;
	
	
	
	
	/**
	 * 
	 */
	public ZRFC_IVR_VALGET_PARTNER_OutputData() {
		super();
	}

	
	/**
	 * @return the idBussinesPartner
	 */
	public String getIdBussinesPartner() {
		return idBussinesPartner;
	}



	/**
	 * @param idBussinesPartner the idBussinesPartner to set
	 */
	public void setIdBussinesPartner(String idBussinesPartner) {
		this.idBussinesPartner = idBussinesPartner;
	}




	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}




	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	/**
	 * @return the paternalName
	 */
	public String getPaternalName() {
		return paternalName;
	}





	/**
	 * @param paternalName the paternalName to set
	 */
	public void setPaternalName(String paternalName) {
		this.paternalName = paternalName;
	}





	/**
	 * @return the maternalName
	 */
	public String getMaternalName() {
		return maternalName;
	}




	/**
	 * @param maternalName the maternalName to set
	 */
	public void setMaternalName(String maternalName) {
		this.maternalName = maternalName;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}





	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}





	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}




	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}





	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}





	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}



	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}




	/**
	 * @return the externalNumber
	 */
	public String getExternalNumber() {
		return externalNumber;
	}



	/**
	 * @param externalNumber the externalNumber to set
	 */
	public void setExternalNumber(String externalNumber) {
		this.externalNumber = externalNumber;
	}




	/**
	 * @return the internalNumber
	 */
	public String getInternalNumber() {
		return internalNumber;
	}





	/**
	 * @param internalNumber the internalNumber to set
	 */
	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}




	/**
	 * @return the township
	 */
	public String getTownship() {
		return township;
	}





	/**
	 * @param township the township to set
	 */
	public void setTownship(String township) {
		this.township = township;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}




	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}




	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}



	/**
	 * @return the numberPhone
	 */
	public String getNumberPhone() {
		return numberPhone;
	}




	/**
	 * @param numberPhone the numberPhone to set
	 */
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}




	/**
	 * @return the numberCel
	 */
	public String getNumberCel() {
		return numberCel;
	}




	/**
	 * @param numberCel the numberCel to set
	 */
	public void setNumberCel(String numberCel) {
		this.numberCel = numberCel;
	}



	/**
	 * @return the numberPhoneJob
	 */
	public String getNumberPhoneJob() {
		return numberPhoneJob;
	}



	/**
	 * @param numberPhoneJob the numberPhoneJob to set
	 */
	public void setNumberPhoneJob(String numberPhoneJob) {
		this.numberPhoneJob = numberPhoneJob;
	}


	/**
	 * @return the siglaPosition
	 */
	public String getSiglaPosition() {
		return siglaPosition;
	}



	/**
	 * @param siglaPosition the siglaPosition to set
	 */
	public void setSiglaPosition(String siglaPosition) {
		this.siglaPosition = siglaPosition;
	}



	/**
	 * @return the namePosition
	 */
	public String getNamePosition() {
		return namePosition;
	}




	/**
	 * @param namePosition the namePosition to set
	 */
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}



	/**
	 * @return the siglaBranch
	 */
	public String getSiglaBranch() {
		return siglaBranch;
	}



	/**
	 * @param siglaBranch the siglaBranch to set
	 */
	public void setSiglaBranch(String siglaBranch) {
		this.siglaBranch = siglaBranch;
	}



	/**
	 * @return the nameBranch
	 */
	public String getNameBranch() {
		return nameBranch;
	}




	/**
	 * @param nameBranch the nameBranch to set
	 */
	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
	}




	/**
	 * @return the messages
	 */
	public ArrayList<TE_MESSAGE_OutputData> getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<TE_MESSAGE_OutputData> messages) {
		this.messages = messages;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
