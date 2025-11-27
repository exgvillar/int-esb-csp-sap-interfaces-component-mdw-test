/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_EMPLEADO_NIVEL_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private ArrayList<TE_EMPLEADO_SUCURSAL_OutputData> tablaEmpleadoSucursal = null;
	
	private ArrayList<TE_EMPLEADO_TOTAL_OutputData> tablaEmpleadoTotal = null;
	
	
	
	/**
* 
*/
	public ZCRM_EMPLEADO_NIVEL_OutputData() {
		super();
	}

	
	


	/**
	 * @return the tablaEmpleadoSucursal
	 */
	public ArrayList<TE_EMPLEADO_SUCURSAL_OutputData> getTablaEmpleadoSucursal() {
		return tablaEmpleadoSucursal;
	}





	/**
	 * @param tablaEmpleadoSucursal the tablaEmpleadoSucursal to set
	 */
	public void setTablaEmpleadoSucursal(
			ArrayList<TE_EMPLEADO_SUCURSAL_OutputData> tablaEmpleadoSucursal) {
		this.tablaEmpleadoSucursal = tablaEmpleadoSucursal;
	}





	/**
	 * @return the tablaEmpleadoTotal
	 */
	public ArrayList<TE_EMPLEADO_TOTAL_OutputData> getTablaEmpleadoTotal() {
		return tablaEmpleadoTotal;
	}





	/**
	 * @param tablaEmpleadoTotal the tablaEmpleadoTotal to set
	 */
	public void setTablaEmpleadoTotal(
			ArrayList<TE_EMPLEADO_TOTAL_OutputData> tablaEmpleadoTotal) {
		this.tablaEmpleadoTotal = tablaEmpleadoTotal;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
