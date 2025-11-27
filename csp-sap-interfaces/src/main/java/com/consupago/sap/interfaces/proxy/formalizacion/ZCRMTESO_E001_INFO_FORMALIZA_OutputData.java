/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMTESO_E001_INFO_FORMALIZA_OutputData implements Serializable,
		IProxyOutputData {
	private static final long serialVersionUID = 5738991323551765268L;

	private String applicationId;
	private String requestId;

	private Credit credit;
	private ArrayList<Credit> arrCredit;

	// private Customizables customizables;
	private ArrayList<Customizables> arrCustomizables;

	private Comission comission;
	private ArrayList<Comission> arrComissions;

	private CreditIcbs creditIcbs;

	private Insurance insurance;
	private ArrayList<Insurance> arrInsurance;

	private Customer customer;

	private Employment employment;

	private Address address;
	private ArrayList<Address> arrAddress;

	private Contact contact;
	private ArrayList<Contact> arrContact;

	private Reference reference;
	private ArrayList<Reference> arrReference;

	private ArrayList<Credit> arrSubstitution;
	
	private ValidacionDependencia validacionDependencia;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.DEFAULT_STYLE);
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public ArrayList<Credit> getArrCredit() {
		return arrCredit;
	}

	public void setArrCredit(ArrayList<Credit> arrCredit) {
		this.arrCredit = arrCredit;
	}

	public ArrayList<Customizables> getArrCustomizables() {
		return arrCustomizables;
	}

	public void setArrCustomizables(ArrayList<Customizables> arrCustomizables) {
		this.arrCustomizables = arrCustomizables;
	}

	public Comission getComission() {
		return comission;
	}

	public void setComission(Comission comission) {
		this.comission = comission;
	}

	public ArrayList<Comission> getArrComissions() {
		return arrComissions;
	}

	public void setArrComissions(ArrayList<Comission> arrComissions) {
		this.arrComissions = arrComissions;
	}

	public CreditIcbs getCreditIcbs() {
		return creditIcbs;
	}

	public void setCreditIcbs(CreditIcbs creditIcbs) {
		this.creditIcbs = creditIcbs;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public ArrayList<Insurance> getArrInsurance() {
		return arrInsurance;
	}

	public void setArrInsurance(ArrayList<Insurance> arrInsurance) {
		this.arrInsurance = arrInsurance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<Address> getArrAddress() {
		return arrAddress;
	}

	public void setArrAddress(ArrayList<Address> arrAddress) {
		this.arrAddress = arrAddress;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ArrayList<Contact> getArrContact() {
		return arrContact;
	}

	public void setArrContact(ArrayList<Contact> arrContact) {
		this.arrContact = arrContact;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public ArrayList<Reference> getArrReference() {
		return arrReference;
	}

	public void setArrReference(ArrayList<Reference> arrReference) {
		this.arrReference = arrReference;
	}

	public ArrayList<Credit> getArrSubstitution() {
		return arrSubstitution;
	}

	public void setArrSubstitution(ArrayList<Credit> arrSubstitution) {
		this.arrSubstitution = arrSubstitution;
	}

	public ValidacionDependencia getValidacionDependencia() {
		return validacionDependencia;
	}

	public void setValidacionDependencia(ValidacionDependencia validacionDependencia) {
		this.validacionDependencia = validacionDependencia;
	}

}
