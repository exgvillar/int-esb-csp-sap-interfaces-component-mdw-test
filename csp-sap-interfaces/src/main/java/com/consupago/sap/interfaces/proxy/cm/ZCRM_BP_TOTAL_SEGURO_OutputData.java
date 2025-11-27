/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_BP_TOTAL_SEGURO_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private int numeroSolicitudesConSeguro = 0;
	
	private double montoSolicitudesConSeguro = 0;

	private int numeroSolicitudesCompradas = 0;
	
	private double montoSolicitudesCompradas = 0;

	/**
* 
*/
	public ZCRM_BP_TOTAL_SEGURO_OutputData() {
		super();
	}

	
	

	/**
	 * @return the numeroSolicitudesConSeguro
	 */
	public int getNumeroSolicitudesConSeguro() {
		return numeroSolicitudesConSeguro;
	}




	/**
	 * @param numeroSolicitudesConSeguro the numeroSolicitudesConSeguro to set
	 */
	public void setNumeroSolicitudesConSeguro(int numeroSolicitudesConSeguro) {
		this.numeroSolicitudesConSeguro = numeroSolicitudesConSeguro;
	}




	/**
	 * @return the montoSolicitudesConSeguro
	 */
	public double getMontoSolicitudesConSeguro() {
		return montoSolicitudesConSeguro;
	}




	/**
	 * @param montoSolicitudesConSeguro the montoSolicitudesConSeguro to set
	 */
	public void setMontoSolicitudesConSeguro(double montoSolicitudesConSeguro) {
		this.montoSolicitudesConSeguro = montoSolicitudesConSeguro;
	}

	


	/**
	 * @return the numeroSolicitudesCompradas
	 */
	public int getNumeroSolicitudesCompradas() {
		return numeroSolicitudesCompradas;
	}




	/**
	 * @param numeroSolicitudesCompradas the numeroSolicitudesCompradas to set
	 */
	public void setNumeroSolicitudesCompradas(int numeroSolicitudesCompradas) {
		this.numeroSolicitudesCompradas = numeroSolicitudesCompradas;
	}




	/**
	 * @return the montoSolicitudesCompradas
	 */
	public double getMontoSolicitudesCompradas() {
		return montoSolicitudesCompradas;
	}




	/**
	 * @param montoSolicitudesCompradas the montoSolicitudesCompradas to set
	 */
	public void setMontoSolicitudesCompradas(double montoSolicitudesCompradas) {
		this.montoSolicitudesCompradas = montoSolicitudesCompradas;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
