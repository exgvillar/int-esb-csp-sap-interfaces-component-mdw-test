/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cis;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_CIS_DATOSBP_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String businessPartnerId = null;
	
	private String nombre1 = null;

	private String nombre2 = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private String rfc = null;
	
	private String telefonoCasa = null;
	
	private String telefonoDomicilio = null;
	
	private String email = null;
	
	private ArrayList<ZRFC_CIS_DATOS_ADDRESS_BP_OutputData> addressList = null;
	
	/**
* 
*/
	public ZRFC_CIS_DATOSBP_OutputData() {
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
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}





	/**
	 * @param nombre1 the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}





	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}





	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}





	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}





	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}





	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}





	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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
	 * @return the telefonoCasa
	 */
	public String getTelefonoCasa() {
		return telefonoCasa;
	}





	/**
	 * @param telefonoCasa the telefonoCasa to set
	 */
	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}





	/**
	 * @return the telefonoDomicilio
	 */
	public String getTelefonoDomicilio() {
		return telefonoDomicilio;
	}





	/**
	 * @param telefonoDomicilio the telefonoDomicilio to set
	 */
	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}





	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}





	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	


	/**
	 * @return the addressList
	 */
	public ArrayList<ZRFC_CIS_DATOS_ADDRESS_BP_OutputData> getAddressList() {
		return addressList;
	}





	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(
			ArrayList<ZRFC_CIS_DATOS_ADDRESS_BP_OutputData> addressList) {
		this.addressList = addressList;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
