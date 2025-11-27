/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_SMSLCOM_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private String clienteBusinessPartnerId = null;
	
	private String promotorBusinessPartnerId = null;
	
	private String folioSolicitudCRM = null;
	
	private String numeroCelularCliente = null;
	
	private String numeroCelularPromotor = null;
	
	private String empresaId = null;
	
	private String distribuidorId = null;
	
	private String sucursalId = null;
	
	private String nombreCompetidor = null;
	
	private double montoCompetidor = 0;
	
	
	
	/**
* 
*/
	public ZRFC_SMSLCOM_OutputData() {
		super();
	}

	

	/**
	 * @return the clienteBusinessPartnerId
	 */
	public String getClienteBusinessPartnerId() {
		return clienteBusinessPartnerId;
	}



	/**
	 * @param clienteBusinessPartnerId the clienteBusinessPartnerId to set
	 */
	public void setClienteBusinessPartnerId(String clienteBusinessPartnerId) {
		this.clienteBusinessPartnerId = clienteBusinessPartnerId;
	}



	/**
	 * @return the promotorBusinessPartnerId
	 */
	public String getPromotorBusinessPartnerId() {
		return promotorBusinessPartnerId;
	}



	/**
	 * @param promotorBusinessPartnerId the promotorBusinessPartnerId to set
	 */
	public void setPromotorBusinessPartnerId(String promotorBusinessPartnerId) {
		this.promotorBusinessPartnerId = promotorBusinessPartnerId;
	}



	/**
	 * @return the folioSolicitudCRM
	 */
	public String getFolioSolicitudCRM() {
		return folioSolicitudCRM;
	}



	/**
	 * @param folioSolicitudCRM the folioSolicitudCRM to set
	 */
	public void setFolioSolicitudCRM(String folioSolicitudCRM) {
		this.folioSolicitudCRM = folioSolicitudCRM;
	}



	/**
	 * @return the numeroCelularCliente
	 */
	public String getNumeroCelularCliente() {
		return numeroCelularCliente;
	}



	/**
	 * @param numeroCelularCliente the numeroCelularCliente to set
	 */
	public void setNumeroCelularCliente(String numeroCelularCliente) {
		this.numeroCelularCliente = numeroCelularCliente;
	}



	/**
	 * @return the numeroCelularPromotor
	 */
	public String getNumeroCelularPromotor() {
		return numeroCelularPromotor;
	}



	/**
	 * @param numeroCelularPromotor the numeroCelularPromotor to set
	 */
	public void setNumeroCelularPromotor(String numeroCelularPromotor) {
		this.numeroCelularPromotor = numeroCelularPromotor;
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
	 * @return the distribuidorId
	 */
	public String getDistribuidorId() {
		return distribuidorId;
	}



	/**
	 * @param distribuidorId the distribuidorId to set
	 */
	public void setDistribuidorId(String distribuidorId) {
		this.distribuidorId = distribuidorId;
	}



	/**
	 * @return the sucursalId
	 */
	public String getSucursalId() {
		return sucursalId;
	}



	/**
	 * @param sucursalId the sucursalId to set
	 */
	public void setSucursalId(String sucursalId) {
		this.sucursalId = sucursalId;
	}



	/**
	 * @return the nombreCompetidor
	 */
	public String getNombreCompetidor() {
		return nombreCompetidor;
	}



	/**
	 * @param nombreCompetidor the nombreCompetidor to set
	 */
	public void setNombreCompetidor(String nombreCompetidor) {
		this.nombreCompetidor = nombreCompetidor;
	}



	/**
	 * @return the montoCompetidor
	 */
	public double getMontoCompetidor() {
		return montoCompetidor;
	}



	/**
	 * @param montoCompetidor the montoCompetidor to set
	 */
	public void setMontoCompetidor(double montoCompetidor) {
		this.montoCompetidor = montoCompetidor;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
