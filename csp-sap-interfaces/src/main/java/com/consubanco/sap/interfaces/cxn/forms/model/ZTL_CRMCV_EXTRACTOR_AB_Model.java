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
public class ZTL_CRMCV_EXTRACTOR_AB_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8820984487934293448L;
	
	private String solicitudId = null;
	
	private String empresaId = null;
	
	private String convenioId = null;
	
	private ArrayList<ZTL_CRMCV_DOCS_AF_Model> documentsList = null;
	
	/**
	 * 
	 */
	public ZTL_CRMCV_EXTRACTOR_AB_Model() {
		super();
	}

	
	


	/**
	 * @return the solicitudId
	 */
	public String getSolicitudId() {
		return solicitudId;
	}





	/**
	 * @param solicitudId the solicitudId to set
	 */
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}





	/**
	 * @return the empresaId
	 */
	public String getEmpresaId() {
		return empresaId;
	}





	/**
	 * @param empresaId the empresaId to set
	 */
	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}





	/**
	 * @return the convenioId
	 */
	public String getConvenioId() {
		return convenioId;
	}





	/**
	 * @param convenioId the convenioId to set
	 */
	public void setConvenioId(String convenioId) {
		this.convenioId = convenioId;
	}





	/**
	 * @return the documentsList
	 */
	public ArrayList<ZTL_CRMCV_DOCS_AF_Model> getDocumentsList() {
		return documentsList;
	}





	/**
	 * @param documentsList the documentsList to set
	 */
	public void setDocumentsList(ArrayList<ZTL_CRMCV_DOCS_AF_Model> documentsList) {
		this.documentsList = documentsList;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
