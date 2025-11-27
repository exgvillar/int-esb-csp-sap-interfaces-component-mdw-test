/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class TE_EMPLEADO_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2514238959760079532L;

	private String idEmpleado = null;
	
	private String siglaSucursal = null;
	

	/**
* 
*/
	public TE_EMPLEADO_SUCURSAL_OutputData() {
		super();
	}

	
	
	
	


	/**
	 * @return the idEmpleado
	 */
	public String getIdEmpleado() {
		return idEmpleado;
	}







	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
