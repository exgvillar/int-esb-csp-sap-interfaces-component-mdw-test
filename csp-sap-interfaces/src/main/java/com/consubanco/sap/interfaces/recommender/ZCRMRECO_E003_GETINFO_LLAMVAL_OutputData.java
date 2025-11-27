/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recommender.model.ZESCRMRECO_E003_Recommended;
import com.consubanco.sap.interfaces.recommender.model.ZESCRMRECO_E003_Recommender;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class ZCRMRECO_E003_GETINFO_LLAMVAL_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	private ZESCRMRECO_E003_Recommended recomendado;
	private ZESCRMRECO_E003_Recommender recomendador;

	/**
	 * @return the recomendado
	 */
	public ZESCRMRECO_E003_Recommended getRecomendado() {
		return recomendado;
	}

	/**
	 * @param recomendado
	 *            the recomendado to set
	 */
	public void setRecomendado(ZESCRMRECO_E003_Recommended recomendado) {
		this.recomendado = recomendado;
	}

	/**
	 * @return the recomendador
	 */
	public ZESCRMRECO_E003_Recommender getRecomendador() {
		return recomendador;
	}

	/**
	 * @param recomendador
	 *            the recomendador to set
	 */
	public void setRecomendador(ZESCRMRECO_E003_Recommender recomendador) {
		this.recomendador = recomendador;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
