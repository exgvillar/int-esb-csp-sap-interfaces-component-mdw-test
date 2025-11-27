/**
 * 
 */
package com.consubanco.sap.interfaces.valdep.instalacion;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData implements Serializable {

	private static final long serialVersionUID = 8438438631221439082L;
	private String zIdSolicitud;
	private String zEstatus;
	private ArrayList<Z_OS_VALDEP_OutputData> arrOsValDep;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getzIdSolicitud() {
		return zIdSolicitud;
	}

	public void setzIdSolicitud(String zIdSolicitud) {
		this.zIdSolicitud = zIdSolicitud;
	}

	public String getzEstatus() {
		return zEstatus;
	}

	public void setzEstatus(String zEstatus) {
		this.zEstatus = zEstatus;
	}

	public ArrayList<Z_OS_VALDEP_OutputData> getArrOsValDep() {
		return arrOsValDep;
	}

	public void setArrOsValDep(ArrayList<Z_OS_VALDEP_OutputData> arrOsValDep) {
		this.arrOsValDep = arrOsValDep;
	}

}
