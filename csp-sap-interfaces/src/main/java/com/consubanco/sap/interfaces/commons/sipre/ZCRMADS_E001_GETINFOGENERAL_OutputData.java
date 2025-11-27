package com.consubanco.sap.interfaces.commons.sipre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.commons.sipre.model.E_SIPRE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMADS_E001_GETINFOGENERAL_OutputData implements Serializable, IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7739295216709907003L;
	private List<E_SIPRE_Model> tasksSipre = new ArrayList<E_SIPRE_Model>();	
	/**
	 * @return the tasksSipre
	 */
	public List<E_SIPRE_Model> getTasksSipre() {
		return tasksSipre;
	}
	/**
	 * @param tasksSipre the tasksSipre to set
	 */
	public void setTasksSipre(List<E_SIPRE_Model> tasksSipre) {
		this.tasksSipre = tasksSipre;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
