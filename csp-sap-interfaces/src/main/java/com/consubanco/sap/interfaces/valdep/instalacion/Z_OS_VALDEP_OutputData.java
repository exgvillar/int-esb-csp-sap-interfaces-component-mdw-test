package com.consubanco.sap.interfaces.valdep.instalacion;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Z_OS_VALDEP_OutputData implements Serializable {

	private static final long serialVersionUID = -8063565020647711888L;
	private String zIdOs;
	private String zEstatusOs;
	private ArrayList<Z_OS_MONTOS_OutputData> arrMontos;
	private ArrayList<Z_OS_INTERLOCUTORES_OutPutData> arrInterlocutores;
	private ArrayList<Z_OS_FECHAS_OutputData> arrFechas;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getzIdOs() {
		return zIdOs;
	}

	public void setzIdOs(String zIdOs) {
		this.zIdOs = zIdOs;
	}

	public String getzEstatusOs() {
		return zEstatusOs;
	}

	public void setzEstatusOs(String zEstatusOs) {
		this.zEstatusOs = zEstatusOs;
	}

	public ArrayList<Z_OS_MONTOS_OutputData> getArrMontos() {
		return arrMontos;
	}

	public void setArrMontos(ArrayList<Z_OS_MONTOS_OutputData> arrMontos) {
		this.arrMontos = arrMontos;
	}

	public ArrayList<Z_OS_INTERLOCUTORES_OutPutData> getArrInterlocutores() {
		return arrInterlocutores;
	}

	public void setArrInterlocutores(
			ArrayList<Z_OS_INTERLOCUTORES_OutPutData> arrInterlocutores) {
		this.arrInterlocutores = arrInterlocutores;
	}

	public ArrayList<Z_OS_FECHAS_OutputData> getArrFechas() {
		return arrFechas;
	}

	public void setArrFechas(ArrayList<Z_OS_FECHAS_OutputData> arrFechas) {
		this.arrFechas = arrFechas;
	}

}
