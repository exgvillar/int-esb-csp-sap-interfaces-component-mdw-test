package com.consubanco.sap.interfaces.bpm.externalPortal.model;

public class ZESCRMORI_E052_E_DOCUMENTO_Model {
	
	private String doctoId;
	private String doctoNombre;
	private String doctoIdPortal;
	
	public ZESCRMORI_E052_E_DOCUMENTO_Model() {
		super();
	}

	public ZESCRMORI_E052_E_DOCUMENTO_Model(String doctoId, String doctoNombre,
			String doctoIdPortal) {
		super();
		this.doctoId = doctoId;
		this.doctoNombre = doctoNombre;
		this.doctoIdPortal = doctoIdPortal;
	}
	
	/**
	 * @return the doctoId
	 */
	public String getDoctoId() {
		return doctoId;
	}
	/**
	 * @param doctoId the doctoId to set
	 */
	public void setDoctoId(String doctoId) {
		this.doctoId = doctoId;
	}
	/**
	 * @return the doctoNombre
	 */
	public String getDoctoNombre() {
		return doctoNombre;
	}
	/**
	 * @param doctoNombre the doctoNombre to set
	 */
	public void setDoctoNombre(String doctoNombre) {
		this.doctoNombre = doctoNombre;
	}
	/**
	 * @return the doctoIdPortal
	 */
	public String getDoctoIdPortal() {
		return doctoIdPortal;
	}
	/**
	 * @param doctoIdPortal the doctoIdPortal to set
	 */
	public void setDoctoIdPortal(String doctoIdPortal) {
		this.doctoIdPortal = doctoIdPortal;
	}

	@Override
	public String toString() {
		return "ZESCRMORI_E052_E_DOCUMENTO_Model [doctoId=" + doctoId
				+ ", doctoNombre=" + doctoNombre + ", doctoIdPortal="
				+ doctoIdPortal + "]";
	}
}
