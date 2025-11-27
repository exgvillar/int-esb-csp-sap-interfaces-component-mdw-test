package com.consubanco.sap.interfaces.valdep.instalacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Z_OS_INTERLOCUTORES_OutPutData implements Serializable {
	private String zSolicitante;
	private String zNombreSolicitante;
	private String zEmpleadoResp;
	private String zNombreEmpResp;

	public String getzSolicitante() {
		return zSolicitante;
	}

	public void setzSolicitante(String zSolicitante) {
		this.zSolicitante = zSolicitante;
	}

	public String getzNombreSolicitante() {
		return zNombreSolicitante;
	}

	public void setzNombreSolicitante(String zNombreSolicitante) {
		this.zNombreSolicitante = zNombreSolicitante;
	}

	public String getzEmpleadoResp() {
		return zEmpleadoResp;
	}

	public void setzEmpleadoResp(String zEmpleadoResp) {
		this.zEmpleadoResp = zEmpleadoResp;
	}

	public String getzNombreEmpResp() {
		return zNombreEmpResp;
	}

	public void setzNombreEmpResp(String zNombreEmpResp) {
		this.zNombreEmpResp = zNombreEmpResp;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
