/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class SeguroDeudor_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7823811196517899184L;

	private String ordenServicioId = null;
	
	private boolean seguroTercero = false;
	
	private String bpSeguro = null;
	
	private String razonSocialSeguro = null;
	
	private String rfcSeguro = null;
	
	private double valorUnitario = 0;
	
	private String vigencia = null;
	
	private String bancoId = null;
	
	private String bancoDesc = null;
	
	private String cuenta = null;
	
	private String clabe = null;
	
	private String estatusId = null;
	
	private String estatusDesc = null;
	
	private String fechaUltEstatus = null;
	
	private double montoSeguroDeudor = 0;
	
	
	
	/**
	 * @return the ordenServicioId
	 */
	public String getOrdenServicioId() {
		return ordenServicioId;
	}



	/**
	 * @param ordenServicioId the ordenServicioId to set
	 */
	public void setOrdenServicioId(String ordenServicioId) {
		this.ordenServicioId = ordenServicioId;
	}



	/**
	 * @return the seguroTercero
	 */
	public boolean isSeguroTercero() {
		return seguroTercero;
	}



	/**
	 * @param seguroTercero the seguroTercero to set
	 */
	public void setSeguroTercero(boolean seguroTercero) {
		this.seguroTercero = seguroTercero;
	}



	/**
	 * @return the bpSeguro
	 */
	public String getBpSeguro() {
		return bpSeguro;
	}



	/**
	 * @param bpSeguro the bpSeguro to set
	 */
	public void setBpSeguro(String bpSeguro) {
		this.bpSeguro = bpSeguro;
	}



	/**
	 * @return the razonSocialSeguro
	 */
	public String getRazonSocialSeguro() {
		return razonSocialSeguro;
	}



	/**
	 * @param razonSocialSeguro the razonSocialSeguro to set
	 */
	public void setRazonSocialSeguro(String razonSocialSeguro) {
		this.razonSocialSeguro = razonSocialSeguro;
	}



	/**
	 * @return the rfcSeguro
	 */
	public String getRfcSeguro() {
		return rfcSeguro;
	}



	/**
	 * @param rfcSeguro the rfcSeguro to set
	 */
	public void setRfcSeguro(String rfcSeguro) {
		this.rfcSeguro = rfcSeguro;
	}



	/**
	 * @return the valorUnitario
	 */
	public double getValorUnitario() {
		return valorUnitario;
	}



	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}



	/**
	 * @return the vigencia
	 */
	public String getVigencia() {
		return vigencia;
	}



	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
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
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}



	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
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
	 * @return the fechaUltEstatus
	 */
	public String getFechaUltEstatus() {
		return fechaUltEstatus;
	}



	/**
	 * @param fechaUltEstatus the fechaUltEstatus to set
	 */
	public void setFechaUltEstatus(String fechaUltEstatus) {
		this.fechaUltEstatus = fechaUltEstatus;
	}



	/**
	 * @return the montoSeguroDeudor
	 */
	public double getMontoSeguroDeudor() {
		return montoSeguroDeudor;
	}



	/**
	 * @param montoSeguroDeudor the montoSeguroDeudor to set
	 */
	public void setMontoSeguroDeudor(double montoSeguroDeudor) {
		this.montoSeguroDeudor = montoSeguroDeudor;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
