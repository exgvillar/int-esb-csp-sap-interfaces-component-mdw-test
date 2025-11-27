/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.externalPortal.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author juribes
 *
 */
public class ZCRMORI_E050_GETCONFPORTAL_Model {

	private String id;
	private String nombre;
	private String user;
	private String password;
	private String url;
	private String ficha;
	private String nomina;
	private String idDoctoAnexo;
	private String claveDcto;
	private List<ZESCRMORI_E052_ZDINAMICOS_Model> fields;
	private List<ZESCRMORI_E052_E_DOCUMENTO_Model> documents;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the ficha
	 */
	public String getFicha() {
		return ficha;
	}

	/**
	 * @param ficha
	 *            the ficha to set
	 */
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	/**
	 * @return the nomina
	 */
	public String getNomina() {
		return nomina;
	}

	/**
	 * @param nomina
	 *            the nomina to set
	 */
	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	/**
	 * @return the idDoctoAnexo
	 */
	public String getIdDoctoAnexo() {
		return idDoctoAnexo;
	}

	/**
	 * @param idDoctoAnexo
	 *            the idDoctoAnexo to set
	 */
	public void setIdDoctoAnexo(String idDoctoAnexo) {
		this.idDoctoAnexo = idDoctoAnexo;
	}

	/**
	 * @return the claveDcto
	 */
	public String getClaveDcto() {
		return claveDcto;
	}

	/**
	 * @param claveDcto
	 *            the claveDcto to set
	 */
	public void setClaveDcto(String claveDcto) {
		this.claveDcto = claveDcto;
	}

	/**
	 * @return the fields
	 */
	public List<ZESCRMORI_E052_ZDINAMICOS_Model> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(List<ZESCRMORI_E052_ZDINAMICOS_Model> fields) {
		this.fields = fields;
	}

	/**
	 * @return the documents
	 */
	public List<ZESCRMORI_E052_E_DOCUMENTO_Model> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<ZESCRMORI_E052_E_DOCUMENTO_Model> documents) {
		this.documents = documents;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
