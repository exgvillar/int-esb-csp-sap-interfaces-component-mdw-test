/**
 * 
 */
package com.consubanco.sap.interfaces.commons.cub;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMCAP_E001_GETINFOFORCUB_OutputData implements Serializable, IProxyOutputData {
	private static final long serialVersionUID = 2539082200809553985L;
	private String message = "";
	private String idTask = "";
	private String customerBP = "";
	private String cellphone = "";
	private String verifiedCode = "";
	private String statusId = "";
	private String channel = "";
	private boolean success = false;
	private String name = "";
	private String lastName = "";
	private String lastName2 = "";
	private String birthday = "";
	private String gender = "";
	private String entdFed = "";
	private String country = "";
	private String nationality = "";
	private String curp = "";
	private String rfc = "";
	private String clavElect = "";
	private String fiel = "";
	private String ocupacion = "";
	private String street = "";
	private String col = "";
	private String state = "";
	private String postCode = "";
	private String numExt = "";
	private String numInt = "";
	private String municip = "";
	private String tel = "";
	private String mail = "";
	private String countryBirth = "";

	/**
	 * @return the countryBirth
	 */
	public String getCountryBirth() {
		return countryBirth;
	}

	/**
	 * @param countryBirth the countryBirth to set
	 */
	public void setCountryBirth(String countryBirth) {
		this.countryBirth = countryBirth;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
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
	 * @return the clavElect
	 */
	public String getClavElect() {
		return clavElect;
	}

	/**
	 * @param clavElect the clavElect to set
	 */
	public void setClavElect(String clavElect) {
		this.clavElect = clavElect;
	}

	/**
	 * @return the fiel
	 */
	public String getFiel() {
		return fiel;
	}

	/**
	 * @param fiel the fiel to set
	 */
	public void setFiel(String fiel) {
		this.fiel = fiel;
	}

	/**
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
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
	 * @return the col
	 */
	public String getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the numExt
	 */
	public String getNumExt() {
		return numExt;
	}

	/**
	 * @param numExt the numExt to set
	 */
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	/**
	 * @return the numInt
	 */
	public String getNumInt() {
		return numInt;
	}

	/**
	 * @param numInt the numInt to set
	 */
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}

	/**
	 * @return the municip
	 */
	public String getMunicip() {
		return municip;
	}

	/**
	 * @param municip the municip to set
	 */
	public void setMunicip(String municip) {
		this.municip = municip;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nameLast
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param nameLast the nameLast to set
	 */
	public void setLastName(String nameLast) {
		this.lastName = nameLast;
	}

	/**
	 * @return the nameLast2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param nameLast2 the nameLast2 to set
	 */
	public void setLastName2(String nameLast2) {
		this.lastName2 = nameLast2;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the entdFed
	 */
	public String getEntdFed() {
		return entdFed;
	}

	/**
	 * @param entdFed the entdFed to set
	 */
	public void setEntdFed(String entdFed) {
		this.entdFed = entdFed;
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
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the customerBP
	 */
	public String getCustomerBP() {
		return customerBP;
	}

	/**
	 * @param customerBP
	 *            the customerBP to set
	 */
	public void setCustomerBP(String customerBP) {
		this.customerBP = customerBP;
	}

	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone
	 *            the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the verifiedCode
	 */
	public String getVerifiedCode() {
		return verifiedCode;
	}

	/**
	 * @param verifiedCode
	 *            the verifiedCode to set
	 */
	public void setVerifiedCode(String verifiedCode) {
		this.verifiedCode = verifiedCode;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the idTask
	 */
	public String getIdTask() {
		return idTask;
	}

	/**
	 * @param idTask
	 *            the idTask to set
	 */
	public void setIdTask(String idTask) {
		this.idTask = idTask;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
