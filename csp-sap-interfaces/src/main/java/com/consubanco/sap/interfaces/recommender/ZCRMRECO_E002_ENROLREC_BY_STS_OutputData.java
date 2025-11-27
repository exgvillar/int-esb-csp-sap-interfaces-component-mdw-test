/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author Ing. Adrian Alejo
 * 
 */
public class ZCRMRECO_E002_ENROLREC_BY_STS_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String idTareaEnrol;
	private String idOrdenReco;
	private String bpReco;
	private String celular;
	private String codVerificador;
	private String processBpmId;

	/**
	 * @return the idTareaEnrol
	 */
	public String getIdTareaEnrol() {
		return idTareaEnrol;
	}

	/**
	 * @param idTareaEnrol
	 *            the idTareaEnrol to set
	 */
	public void setIdTareaEnrol(String idTareaEnrol) {
		this.idTareaEnrol = idTareaEnrol;
	}

	/**
	 * @return the idOrdenReco
	 */
	public String getIdOrdenReco() {
		return idOrdenReco;
	}

	/**
	 * @param idOrdenReco
	 *            the idOrdenReco to set
	 */
	public void setIdOrdenReco(String idOrdenReco) {
		this.idOrdenReco = idOrdenReco;
	}

	/**
	 * @return the bpReco
	 */
	public String getBpReco() {
		return bpReco;
	}

	/**
	 * @param bpReco
	 *            the bpReco to set
	 */
	public void setBpReco(String bpReco) {
		this.bpReco = bpReco;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the codVerificador
	 */
	public String getCodVerificador() {
		return codVerificador;
	}

	/**
	 * @param codVerificador
	 *            the codVerificador to set
	 */
	public void setCodVerificador(String codVerificador) {
		this.codVerificador = codVerificador;
	}

	/**
	 * @return the processBpmId
	 */
	public String getProcessBpmId() {
		return processBpmId;
	}

	/**
	 * @param processBpmId
	 *            the processBpmId to set
	 */
	public void setProcessBpmId(String processBpmId) {
		this.processBpmId = processBpmId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
