/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.commons.model.GenericModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCSB_E002_BUSCABP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String bpId = null;

	private String clientId = null;

	private String bpRolId = null;

	private String groupId = null;

	private String funtionInterlocutorId = null;

	private String rfc = null;

	private String curp = null;

	private String name1 = null;

	private String name2 = null;

	private String lastname1 = null;

	private String lastname2 = null;

	private String nameCompany = null;

	private Date dateBirth = null;

	private String placeBirth = null;

	private String countryBirthId = null;

	private String countryBirthDesc = null;

	private String nationalityId = null;

	private String nationalityDesc = null;

	private String maritalStatusId = null;

	private String maritalStatusDesc = null;

	private String email = null;

	private String legalEntity = null;

	private String gender = null;

	private String levelStudiesId = null;

	private String levelStudiesDesc = null;

	private Date dateCreate = null;

	private String FIEL = null;

	private String residenceCountry = null;

	private String identificationType = null;

	private String identificationNumber = null;

	private String identificationType2 = null;

	private String identificationNumber2 = null;

	private String assignedCountryIdentificationNumber = null;

	private String numDependientesEconomicos = null;

	private String edadesDependientesEconomicos = null;

	private String numHabitantesHogar = null;

	private boolean isLocked = false;

	private String phone = null;

	private boolean isUIFList = false;

	private String idRegimenFiscal = null;

	private String descRegimenFiscal = null;

	private boolean isClient = false;
	
	private boolean isPromotorNFO = false;
	
	private GenericModel customerType = null;
	private String employeeNumber = null;

	
	/**
	 * 
	 */
	public ZCRMCSB_E002_BUSCABP_OutputData() {
		super();
	}

	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}

	/**
	 * @param bpId
	 *            the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the bpRolId
	 */
	public String getBpRolId() {
		return bpRolId;
	}

	/**
	 * @param bpRolId
	 *            the bpRolId to set
	 */
	public void setBpRolId(String bpRolId) {
		this.bpRolId = bpRolId;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the funtionInterlocutorId
	 */
	public String getFuntionInterlocutorId() {
		return funtionInterlocutorId;
	}

	/**
	 * @param funtionInterlocutorId
	 *            the funtionInterlocutorId to set
	 */
	public void setFuntionInterlocutorId(String funtionInterlocutorId) {
		this.funtionInterlocutorId = funtionInterlocutorId;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * @param name1
	 *            the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * @param name2
	 *            the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * @return the lastname1
	 */
	public String getLastname1() {
		return lastname1;
	}

	/**
	 * @param lastname1
	 *            the lastname1 to set
	 */
	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}

	/**
	 * @return the lastname2
	 */
	public String getLastname2() {
		return lastname2;
	}

	/**
	 * @param lastname2
	 *            the lastname2 to set
	 */
	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}

	/**
	 * @return the nameCompany
	 */
	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * @param nameCompany
	 *            the nameCompany to set
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	/**
	 * @return the dateBirth
	 */
	public Date getDateBirth() {
		return dateBirth;
	}

	/**
	 * @param dateBirth
	 *            the dateBirth to set
	 */
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	/**
	 * @return the placeBirth
	 */
	public String getPlaceBirth() {
		return placeBirth;
	}

	/**
	 * @param placeBirth
	 *            the placeBirth to set
	 */
	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}

	/**
	 * @return the countryBirthId
	 */
	public String getCountryBirthId() {
		return countryBirthId;
	}

	/**
	 * @param countryBirthId
	 *            the countryBirthId to set
	 */
	public void setCountryBirthId(String countryBirthId) {
		this.countryBirthId = countryBirthId;
	}

	/**
	 * @return the countryBirthDesc
	 */
	public String getCountryBirthDesc() {
		return countryBirthDesc;
	}

	/**
	 * @param countryBirthDesc
	 *            the countryBirthDesc to set
	 */
	public void setCountryBirthDesc(String countryBirthDesc) {
		this.countryBirthDesc = countryBirthDesc;
	}

	/**
	 * @return the nationalityId
	 */
	public String getNationalityId() {
		return nationalityId;
	}

	/**
	 * @param nationalityId
	 *            the nationalityId to set
	 */
	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	/**
	 * @return the nationalityDesc
	 */
	public String getNationalityDesc() {
		return nationalityDesc;
	}

	/**
	 * @param nationalityDesc
	 *            the nationalityDesc to set
	 */
	public void setNationalityDesc(String nationalityDesc) {
		this.nationalityDesc = nationalityDesc;
	}

	/**
	 * @return the maritalStatusId
	 */
	public String getMaritalStatusId() {
		return maritalStatusId;
	}

	/**
	 * @param maritalStatusId
	 *            the maritalStatusId to set
	 */
	public void setMaritalStatusId(String maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	/**
	 * @return the maritalStatusDesc
	 */
	public String getMaritalStatusDesc() {
		return maritalStatusDesc;
	}

	/**
	 * @param maritalStatusDesc
	 *            the maritalStatusDesc to set
	 */
	public void setMaritalStatusDesc(String maritalStatusDesc) {
		this.maritalStatusDesc = maritalStatusDesc;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the legalEntity
	 */
	public String getLegalEntity() {
		return legalEntity;
	}

	/**
	 * @param legalEntity
	 *            the legalEntity to set
	 */
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the levelStudiesId
	 */
	public String getLevelStudiesId() {
		return levelStudiesId;
	}

	/**
	 * @param levelStudiesId
	 *            the levelStudiesId to set
	 */
	public void setLevelStudiesId(String levelStudiesId) {
		this.levelStudiesId = levelStudiesId;
	}

	/**
	 * @return the levelStudiesDesc
	 */
	public String getLevelStudiesDesc() {
		return levelStudiesDesc;
	}

	/**
	 * @param levelStudiesDesc
	 *            the levelStudiesDesc to set
	 */
	public void setLevelStudiesDesc(String levelStudiesDesc) {
		this.levelStudiesDesc = levelStudiesDesc;
	}

	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}

	/**
	 * @param dateCreate
	 *            the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the fIEL
	 */
	public String getFIEL() {
		return FIEL;
	}

	/**
	 * @param fIEL
	 *            the fIEL to set
	 */
	public void setFIEL(String fIEL) {
		FIEL = fIEL;
	}

	/**
	 * @return the residenceCountry
	 */
	public String getResidenceCountry() {
		return residenceCountry;
	}

	/**
	 * @param residenceCountry
	 *            the residenceCountry to set
	 */
	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	/**
	 * @return the identificationType
	 */
	public String getIdentificationType() {
		return identificationType;
	}

	/**
	 * @param identificationType
	 *            the identificationType to set
	 */
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * @return the identificationNumber
	 */
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	/**
	 * @param identificationNumber
	 *            the identificationNumber to set
	 */
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	/**
	 * @return the identificationType2
	 */
	public String getIdentificationType2() {
		return identificationType2;
	}

	/**
	 * @param identificationType2
	 *            the identificationType2 to set
	 */
	public void setIdentificationType2(String identificationType2) {
		this.identificationType2 = identificationType2;
	}

	/**
	 * @return the identificationNumber2
	 */
	public String getIdentificationNumber2() {
		return identificationNumber2;
	}

	/**
	 * @param identificationNumber2
	 *            the identificationNumber2 to set
	 */
	public void setIdentificationNumber2(String identificationNumber2) {
		this.identificationNumber2 = identificationNumber2;
	}

	/**
	 * @return the assignedCountryIdentificationNumber
	 */
	public String getAssignedCountryIdentificationNumber() {
		return assignedCountryIdentificationNumber;
	}

	/**
	 * @param assignedCountryIdentificationNumber
	 *            the assignedCountryIdentificationNumber to set
	 */
	public void setAssignedCountryIdentificationNumber(String assignedCountryIdentificationNumber) {
		this.assignedCountryIdentificationNumber = assignedCountryIdentificationNumber;
	}

	/**
	 * @return the numDependientesEconomicos
	 */
	public String getNumDependientesEconomicos() {
		return numDependientesEconomicos;
	}

	/**
	 * @param numDependientesEconomicos
	 *            the numDependientesEconomicos to set
	 */
	public void setNumDependientesEconomicos(String numDependientesEconomicos) {
		this.numDependientesEconomicos = numDependientesEconomicos;
	}

	/**
	 * @return the edadesDependientesEconomicos
	 */
	public String getEdadesDependientesEconomicos() {
		return edadesDependientesEconomicos;
	}

	/**
	 * @param edadesDependientesEconomicos
	 *            the edadesDependientesEconomicos to set
	 */
	public void setEdadesDependientesEconomicos(String edadesDependientesEconomicos) {
		this.edadesDependientesEconomicos = edadesDependientesEconomicos;
	}

	/**
	 * @return the numHabitantesHogar
	 */
	public String getNumHabitantesHogar() {
		return numHabitantesHogar;
	}

	/**
	 * @param numHabitantesHogar
	 *            the numHabitantesHogar to set
	 */
	public void setNumHabitantesHogar(String numHabitantesHogar) {
		this.numHabitantesHogar = numHabitantesHogar;
	}

	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}

	/**
	 * @param isLocked
	 *            the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isUIFList() {
		return isUIFList;
	}

	public void setUIFList(boolean isUIFList) {
		this.isUIFList = isUIFList;
	}

	/**
	 * @return the idRegimenFiscal
	 */
	public String getIdRegimenFiscal() {
		return idRegimenFiscal;
	}

	/**
	 * @param idRegimenFiscal
	 *            the idRegimenFiscal to set
	 */
	public void setIdRegimenFiscal(String idRegimenFiscal) {
		this.idRegimenFiscal = idRegimenFiscal;
	}

	/**
	 * @return the descRegimenFiscal
	 */
	public String getDescRegimenFiscal() {
		return descRegimenFiscal;
	}

	/**
	 * @param descRegimenFiscal
	 *            the descRegimenFiscal to set
	 */
	public void setDescRegimenFiscal(String descRegimenFiscal) {
		this.descRegimenFiscal = descRegimenFiscal;
	}
	
	/**
	 * @return the isClient
	 */
	public boolean isClient() {
		return isClient;
	}

	/**
	 * @param isClient the isClient to set
	 */
	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}
	
	/**
	 * @return the isPromotorNFO
	 */
	public boolean isPromotorNFO() {
		return isPromotorNFO;
	}

	/**
	 * @param isPromotorNFO the isPromotorNFO to set
	 */
	public void setPromotorNFO(boolean isPromotorNFO) {
		this.isPromotorNFO = isPromotorNFO;
	}

	/**
	 * @return the customerType
	 */
	public GenericModel getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(GenericModel customerType) {
		this.customerType = customerType;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
}
