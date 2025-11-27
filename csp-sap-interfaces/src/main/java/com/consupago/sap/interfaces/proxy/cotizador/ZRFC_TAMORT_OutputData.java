/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_TAMORT_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private double montoDescuento = 0;
	
	private String tasaInteres = null;
	
	private String tasaInteresAnual = null;
	
	private double CAT = 0;
	
	private double montoApagar = 0;
	
	private double comisionPorApertura = 0;
	
	private double comisionPorAperturaPorc = 0;
	
	private ArrayList<ZTL_TAMORT_OutputData> amortizationTable = null;
	
	private String message = null;
	
	/**
* 
*/
	public ZRFC_TAMORT_OutputData() {
		super();
	}

	


	


	/**
	 * @return the montoDescuento
	 */
	public double getMontoDescuento() {
		return montoDescuento;
	}







	/**
	 * @param montoDescuento the montoDescuento to set
	 */
	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}







	/**
	 * @return the tasaInteres
	 */
	public String getTasaInteres() {
		return tasaInteres;
	}







	/**
	 * @param tasaInteres the tasaInteres to set
	 */
	public void setTasaInteres(String tasaInteres) {
		this.tasaInteres = tasaInteres;
	}







	/**
	 * @return the cAT
	 */
	public double getCAT() {
		return CAT;
	}







	/**
	 * @param cAT the cAT to set
	 */
	public void setCAT(double cAT) {
		CAT = cAT;
	}



	





	/**
	 * @return the amortizationTable
	 */
	public ArrayList<ZTL_TAMORT_OutputData> getAmortizationTable() {
		return amortizationTable;
	}







	/**
	 * @param amortizationTable the amortizationTable to set
	 */
	public void setAmortizationTable(
			ArrayList<ZTL_TAMORT_OutputData> amortizationTable) {
		this.amortizationTable = amortizationTable;
	}



	



	/**
	 * @return the tasaInteresAnual
	 */
	public String getTasaInteresAnual() {
		return tasaInteresAnual;
	}







	/**
	 * @param tasaInteresAnual the tasaInteresAnual to set
	 */
	public void setTasaInteresAnual(String tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
	}







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}







	/**
	 * @return the montoApagar
	 */
	public double getMontoApagar() {
		return montoApagar;
	}







	/**
	 * @param montoApagar the montoApagar to set
	 */
	public void setMontoApagar(double montoApagar) {
		this.montoApagar = montoApagar;
	}







	/**
	 * @return the comisionPorApertura
	 */
	public double getComisionPorApertura() {
		return comisionPorApertura;
	}







	/**
	 * @param comisionPorApertura the comisionPorApertura to set
	 */
	public void setComisionPorApertura(double comisionPorApertura) {
		this.comisionPorApertura = comisionPorApertura;
	}







	/**
	 * @return the comisionPorAperturaPorc
	 */
	public double getComisionPorAperturaPorc() {
		return comisionPorAperturaPorc;
	}







	/**
	 * @param comisionPorAperturaPorc the comisionPorAperturaPorc to set
	 */
	public void setComisionPorAperturaPorc(double comisionPorAperturaPorc) {
		this.comisionPorAperturaPorc = comisionPorAperturaPorc;
	}







	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}







	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
