/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_EMPLEADO_COMISION_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String businessPartnerId = null;
	
	private String siglaSucursal = null;
	
	private String nombreSucursal = null;
	
		
	/**
* 
*/
	public ZCRM_EMPLEADO_COMISION_SUCURSAL_OutputData() {
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
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}





	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}


	


	/**
	 * @return the businessPartnerId
	 */
	public String getBusinessPartnerId() {
		return businessPartnerId;
	}





	/**
	 * @param businessPartnerId the businessPartnerId to set
	 */
	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
