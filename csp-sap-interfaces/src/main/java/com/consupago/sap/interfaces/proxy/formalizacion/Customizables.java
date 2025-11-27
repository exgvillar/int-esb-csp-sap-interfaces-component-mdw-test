package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class Customizables  implements Serializable {
	private static final long serialVersionUID = 5664395209520806427L;
	private String customfieldValue;
	private String customfieldKey;
	private String customconvenioCrm;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getCustomfieldValue() {
		return customfieldValue;
	}

	public void setCustomfieldValue(String customfieldValue) {
		this.customfieldValue = customfieldValue;
	}

	public String getCustomfieldKey() {
		return customfieldKey;
	}

	public void setCustomfieldKey(String customfieldKey) {
		this.customfieldKey = customfieldKey;
	}

	public String getCustomconvenioCrm() {
		return customconvenioCrm;
	}

	public void setCustomconvenioCrm(String customconvenioCrm) {
		this.customconvenioCrm = customconvenioCrm;
	}

}
