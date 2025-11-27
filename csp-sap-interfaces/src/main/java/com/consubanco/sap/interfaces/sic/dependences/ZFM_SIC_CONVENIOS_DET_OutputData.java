/**
 * 
 */
package com.consubanco.sap.interfaces.sic.dependences;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.sic.ZUT_ADDRESS_OutputData;
import com.consubanco.sap.interfaces.sic.ZUT_PERSON_OutputData;
import com.consubanco.sap.interfaces.sic.model.ZFM_SIC_CONVENIOS_MOVS_model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_SIC_CONVENIOS_DET_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String dependenceId = null;
	
	private String dependenceDesc = null;
	
	private String frecuency = null;

	private String frecuencyInstallation = null;
	
	private ArrayList<String> movementTypes = null;
	
	private String consolidationFileType = null;
	
	private ZUT_ADDRESS_OutputData address = null;
	
	private ArrayList<ZUT_PERSON_OutputData> persons = null;
	
	private ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes = null;
	
	
	/**
	 * 
	 */
	public ZFM_SIC_CONVENIOS_DET_OutputData() {
		super();
	}

	
	


	/**
	 * @return the dependenceId
	 */
	public String getDependenceId() {
		return dependenceId;
	}





	/**
	 * @param dependenceId the dependenceId to set
	 */
	public void setDependenceId(String dependenceId) {
		this.dependenceId = dependenceId;
	}





	/**
	 * @return the dependenceDesc
	 */
	public String getDependenceDesc() {
		return dependenceDesc;
	}





	/**
	 * @param dependenceDesc the dependenceDesc to set
	 */
	public void setDependenceDesc(String dependenceDesc) {
		this.dependenceDesc = dependenceDesc;
	}





	/**
	 * @return the frecuency
	 */
	public String getFrecuency() {
		return frecuency;
	}





	/**
	 * @param frecuency the frecuency to set
	 */
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}





	/**
	 * @return the frecuencyInstallation
	 */
	public String getFrecuencyInstallation() {
		return frecuencyInstallation;
	}





	/**
	 * @param frecuencyInstallation the frecuencyInstallation to set
	 */
	public void setFrecuencyInstallation(String frecuencyInstallation) {
		this.frecuencyInstallation = frecuencyInstallation;
	}





	/**
	 * @return the movementTypes
	 */
	public ArrayList<String> getMovementTypes() {
		return movementTypes;
	}





	/**
	 * @param movementTypes the movementTypes to set
	 */
	public void setMovementTypes(ArrayList<String> movementTypes) {
		this.movementTypes = movementTypes;
	}





	/**
	 * @return the consolidationFileType
	 */
	public String getConsolidationFileType() {
		return consolidationFileType;
	}





	/**
	 * @param consolidationFileType the consolidationFileType to set
	 */
	public void setConsolidationFileType(String consolidationFileType) {
		this.consolidationFileType = consolidationFileType;
	}


	


	/**
	 * @return the address
	 */
	public ZUT_ADDRESS_OutputData getAddress() {
		return address;
	}





	/**
	 * @param address the address to set
	 */
	public void setAddress(ZUT_ADDRESS_OutputData address) {
		this.address = address;
	}





	/**
	 * @return the persons
	 */
	public ArrayList<ZUT_PERSON_OutputData> getPersons() {
		return persons;
	}





	/**
	 * @param persons the persons to set
	 */
	public void setPersons(ArrayList<ZUT_PERSON_OutputData> persons) {
		this.persons = persons;
	}





	/**
	 * @return the attributes
	 */
	public ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> getAttributes() {
		return attributes;
	}





	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes) {
		this.attributes = attributes;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
