/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.forms.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author rbecerra
 *
 */
public class ZTL_CRMCV_DOCS_AF_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8820984487934293448L;
	
	private int idDocumento = 0;
	
	private int order = 0;
	
	private String nombreDocumento = null;
	
	private String ruta = null;
	
	private String nombreTecnico = null;
	
	
	private ArrayList<ZTL_CRMCV_CAMPOS_AF_Model> fieldList = null;
	
	/**
	 * 
	 */
	public ZTL_CRMCV_DOCS_AF_Model() {
		super();
	}

	

	/**
	 * @return the idDocumento
	 */
	public int getIdDocumento() {
		return idDocumento;
	}



	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}



	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}



	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}



	/**
	 * @return the nombreDocumento
	 */
	public String getNombreDocumento() {
		return nombreDocumento;
	}



	/**
	 * @param nombreDocumento the nombreDocumento to set
	 */
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}



	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}



	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}



	/**
	 * @return the nombreTecnico
	 */
	public String getNombreTecnico() {
		return nombreTecnico;
	}



	/**
	 * @param nombreTecnico the nombreTecnico to set
	 */
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}



	/**
	 * @return the fieldList
	 */
	public ArrayList<ZTL_CRMCV_CAMPOS_AF_Model> getFieldList() {
		return fieldList;
	}



	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(ArrayList<ZTL_CRMCV_CAMPOS_AF_Model> fieldList) {
		this.fieldList = fieldList;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
