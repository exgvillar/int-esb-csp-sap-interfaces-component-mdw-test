/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_SUCURSAL_COMISION_OutputData implements Serializable,
		IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6411003107585036547L;

	private String siglaSucursal = null;
	
	private String nombreSucursal = null;

	
	/**
* 
*/
	public ZCRM_SUCURSAL_COMISION_OutputData() {
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




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
