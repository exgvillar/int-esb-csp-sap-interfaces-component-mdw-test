package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_RECOMENDADO_Model;
import com.consubanco.sap.interfaces.recomendados.model.CLIENTE_REFIERE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_E000_BPMSTARTER_OutputData implements Serializable,
	IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String operationId = null;
	
	private Date creationDate = null;

	private String canalOrigen = null;
	
	private String canalOrigenDesc = null;
		
	private CLIENTE_RECOMENDADO_Model recomendado = null;
	
	private CLIENTE_REFIERE_Model refiere = null;
	
	
	
	public ZCRMRECO_E000_BPMSTARTER_OutputData() {
		super();
	}
	
	

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}



	/**
	 * @param operationId the operationId to set
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}



	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}



	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	/**
	 * @return the recomendado
	 */
	public CLIENTE_RECOMENDADO_Model getRecomendado() {
		return recomendado;
	}



	/**
	 * @param recomendado the recomendado to set
	 */
	public void setRecomendado(CLIENTE_RECOMENDADO_Model recomendado) {
		this.recomendado = recomendado;
	}



	/**
	 * @return the refiere
	 */
	public CLIENTE_REFIERE_Model getRefiere() {
		return refiere;
	}



	/**
	 * @param refiere the refiere to set
	 */
	public void setRefiere(CLIENTE_REFIERE_Model refiere) {
		this.refiere = refiere;
	}



	/**
	 * @return the canalOrigen
	 */
	public String getCanalOrigen() {
		return canalOrigen;
	}



	/**
	 * @param canalOrigen the canalOrigen to set
	 */
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}



	/**
	 * @return the canalOrigenDesc
	 */
	public String getCanalOrigenDesc() {
		return canalOrigenDesc;
	}



	/**
	 * @param canalOrigenDesc the canalOrigenDesc to set
	 */
	public void setCanalOrigenDesc(String canalOrigenDesc) {
		this.canalOrigenDesc = canalOrigenDesc;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
