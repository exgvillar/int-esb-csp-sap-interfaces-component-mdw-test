/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_PUESTOS_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private String siglaSucursal = null;
	
	private String puesto = null;
	
	private int contador = 0;
	
	/**
* 
*/
	public ZCRM_PUESTOS_SUCURSAL_OutputData() {
		super();
	}

	


	/**
	 * @return the siglaSucursal
	 */
	public String getSiglaSucursal() {
		return siglaSucursal;
	}




	/**
	 * @param siglaSucursal the siglaSucursal to set
	 */
	public void setSiglaSucursal(String siglaSucursal) {
		this.siglaSucursal = siglaSucursal;
	}




	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}




	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}




	/**
	 * @return the contador
	 */
	public int getContador() {
		return contador;
	}




	/**
	 * @param contador the contador to set
	 */
	public void setContador(int contador) {
		this.contador = contador;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
