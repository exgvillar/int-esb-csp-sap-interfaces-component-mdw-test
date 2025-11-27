/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZTL_TAMORT_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private int numeroPago = 0;
	
	private double capital = 0;
	
	private double interes = 0;
	
	private double iva = 0;
	
	private double amortizacion = 0;
	
	private double pago = 0;
	
	
	/**
* 
*/
	public ZTL_TAMORT_OutputData() {
		super();
	}

	
	


	/**
	 * @return the numeroPago
	 */
	public int getNumeroPago() {
		return numeroPago;
	}





	/**
	 * @param numeroPago the numeroPago to set
	 */
	public void setNumeroPago(int numeroPago) {
		this.numeroPago = numeroPago;
	}





	/**
	 * @return the capital
	 */
	public double getCapital() {
		return capital;
	}





	/**
	 * @param capital the capital to set
	 */
	public void setCapital(double capital) {
		this.capital = capital;
	}





	/**
	 * @return the interes
	 */
	public double getInteres() {
		return interes;
	}





	/**
	 * @param interes the interes to set
	 */
	public void setInteres(double interes) {
		this.interes = interes;
	}





	/**
	 * @return the iva
	 */
	public double getIva() {
		return iva;
	}





	/**
	 * @param iva the iva to set
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}





	/**
	 * @return the amortizacion
	 */
	public double getAmortizacion() {
		return amortizacion;
	}





	/**
	 * @param amortizacion the amortizacion to set
	 */
	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}





	/**
	 * @return the pago
	 */
	public double getPago() {
		return pago;
	}





	/**
	 * @param pago the pago to set
	 */
	public void setPago(double pago) {
		this.pago = pago;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
