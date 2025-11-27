/**
 * 
 */
package com.consupago.sap.interfaces.proxy;

import java.io.Serializable;
import java.util.ArrayList;



import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author ramon.becerra
 *
 */
public class ProxyInputParameterWithTable implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7666895722076799778L;

	
	private ArrayList<ProxyInputParameter> generalParam = null;
	
	private ArrayList<Object> recordParam = null;
	
	/**
	 * 
	 */
	public ProxyInputParameterWithTable() {
		super();
	}

	



	/**
	 * @return the generalParam
	 */
	public ArrayList<ProxyInputParameter> getGeneralParam() {
		return generalParam;
	}





	/**
	 * @param generalParam the generalParam to set
	 */
	public void setGeneralParam(ArrayList<ProxyInputParameter> generalParam) {
		this.generalParam = generalParam;
	}







	/**
	 * @return the recordParam
	 */
	public ArrayList<Object> getRecordParam() {
		return recordParam;
	}





	/**
	 * @param recordParam the recordParam to set
	 */
	public void setRecordParam(ArrayList<Object> recordParam) {
		this.recordParam = recordParam;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
