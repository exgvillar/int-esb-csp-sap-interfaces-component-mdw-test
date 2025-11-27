/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_SUCURSAL_TOTALES_OutputData implements Serializable,
		IProxyOutputData {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6605225208296243874L;

	private String estatus = "";
	
	private int numeroSolicitudes = 0;

	private double monto = 0;
	
	
	/**
* 
*/
	public ZCRM_SUCURSAL_TOTALES_OutputData() {
		super();
	}

	
	


	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}





	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}





	/**
	 * @return the numeroSolicitudes
	 */
	public int getNumeroSolicitudes() {
		return numeroSolicitudes;
	}





	/**
	 * @param numeroSolicitudes the numeroSolicitudes to set
	 */
	public void setNumeroSolicitudes(int numeroSolicitudes) {
		this.numeroSolicitudes = numeroSolicitudes;
	}





	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}





	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
