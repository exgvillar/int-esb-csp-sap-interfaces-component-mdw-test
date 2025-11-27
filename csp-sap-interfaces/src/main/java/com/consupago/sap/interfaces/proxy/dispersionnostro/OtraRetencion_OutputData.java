/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class OtraRetencion_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7823811196517899184L;

	private String idOtraRetencion = null;
	
	private String concepto = null;
	
	private String nombreBeneficiario = null;
	
	private String rfcBeneficiario = null;
	
	private String cpBeneficiario = null;
	
	private String bancoId = null;
	
	private String bancoDesc = null;
	
	private String clabe = null;
	
	private String referencia = null;
	
	private String estatusId = null;
	
	private String estatusDesc = null;
	
	private double importeRetener = 0;
	
	private double porcentajeRetener = 0;
	
	private Date fechaUltEstatus = null;
	
	
	

	/**
	 * @return the idOtraRetencion
	 */
	public String getIdOtraRetencion() {
		return idOtraRetencion;
	}




	/**
	 * @param idOtraRetencion the idOtraRetencion to set
	 */
	public void setIdOtraRetencion(String idOtraRetencion) {
		this.idOtraRetencion = idOtraRetencion;
	}

	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * @return the nombreBeneficiario
	 */
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}




	/**
	 * @param nombreBeneficiario the nombreBeneficiario to set
	 */
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}




	/**
	 * @return the rfcBeneficiario
	 */
	public String getRfcBeneficiario() {
		return rfcBeneficiario;
	}




	/**
	 * @param rfcBeneficiario the rfcBeneficiario to set
	 */
	public void setRfcBeneficiario(String rfcBeneficiario) {
		this.rfcBeneficiario = rfcBeneficiario;
	}




	/**
	 * @return the cpBeneficiario
	 */
	public String getCpBeneficiario() {
		return cpBeneficiario;
	}




	/**
	 * @param cpBeneficiario the cpBeneficiario to set
	 */
	public void setCpBeneficiario(String cpBeneficiario) {
		this.cpBeneficiario = cpBeneficiario;
	}




	/**
	 * @return the bancoId
	 */
	public String getBancoId() {
		return bancoId;
	}




	/**
	 * @param bancoId the bancoId to set
	 */
	public void setBancoId(String bancoId) {
		this.bancoId = bancoId;
	}




	/**
	 * @return the bancoDesc
	 */
	public String getBancoDesc() {
		return bancoDesc;
	}




	/**
	 * @param bancoDesc the bancoDesc to set
	 */
	public void setBancoDesc(String bancoDesc) {
		this.bancoDesc = bancoDesc;
	}




	/**
	 * @return the clabe
	 */
	public String getClabe() {
		return clabe;
	}




	/**
	 * @param clabe the clabe to set
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}




	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}




	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the estatusId
	 */
	public String getEstatusId() {
		return estatusId;
	}




	/**
	 * @param estatusId the estatusId to set
	 */
	public void setEstatusId(String estatusId) {
		this.estatusId = estatusId;
	}




	/**
	 * @return the estatusDesc
	 */
	public String getEstatusDesc() {
		return estatusDesc;
	}




	/**
	 * @param estatusDesc the estatusDesc to set
	 */
	public void setEstatusDesc(String estatusDesc) {
		this.estatusDesc = estatusDesc;
	}




	/**
	 * @return the importeRetener
	 */
	public double getImporteRetener() {
		return importeRetener;
	}




	/**
	 * @param importeRetener the importeRetener to set
	 */
	public void setImporteRetener(double importeRetener) {
		this.importeRetener = importeRetener;
	}




	/**
	 * @return the porcentajeRetener
	 */
	public double getPorcentajeRetener() {
		return porcentajeRetener;
	}




	/**
	 * @param porcentajeRetener the porcentajeRetener to set
	 */
	public void setPorcentajeRetener(double porcentajeRetener) {
		this.porcentajeRetener = porcentajeRetener;
	}




	/**
	 * @return the fechaUltEstatus
	 */
	public Date getFechaUltEstatus() {
		return fechaUltEstatus;
	}




	/**
	 * @param fechaUltEstatus the fechaUltEstatus to set
	 */
	public void setFechaUltEstatus(Date fechaUltEstatus) {
		this.fechaUltEstatus = fechaUltEstatus;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
