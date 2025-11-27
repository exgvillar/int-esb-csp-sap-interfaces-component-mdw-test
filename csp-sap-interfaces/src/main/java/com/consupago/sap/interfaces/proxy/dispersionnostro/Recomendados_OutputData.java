/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author jcontreras
 *
 */
public class Recomendados_OutputData implements Serializable {
	private static final long serialVersionUID = -7061442809677224319L;
	private String canal;
	private String estatus;
	private String estatusDesc;
	private String ordenServicioId;
	private String tipoOperacion;
	private String channelSource;

	

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}



	public String getCanal() {
		return canal;
	}



	public void setCanal(String canal) {
		this.canal = canal;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public String getEstatusDesc() {
		return estatusDesc;
	}



	public void setEstatusDesc(String estatusDesc) {
		this.estatusDesc = estatusDesc;
	}



	public String getOrdenServicioId() {
		return ordenServicioId;
	}



	public void setOrdenServicioId(String ordenServicioId) {
		this.ordenServicioId = ordenServicioId;
	}



	public String getTipoOperacion() {
		return tipoOperacion;
	}



	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}



	public String getChannelSource() {
		return channelSource;
	}



	public void setChannelSource(String channelSource) {
		this.channelSource = channelSource;
	}

}
