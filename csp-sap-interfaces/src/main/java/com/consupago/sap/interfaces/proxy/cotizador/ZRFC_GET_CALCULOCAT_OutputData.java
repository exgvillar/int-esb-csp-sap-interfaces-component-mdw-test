/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_GET_CALCULOCAT_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private double montoDescuento = 0;
	
	private String tasaInteres = null;
	
	private double CAT = 0;
	
	/**
* 
*/
	public ZRFC_GET_CALCULOCAT_OutputData() {
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







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
