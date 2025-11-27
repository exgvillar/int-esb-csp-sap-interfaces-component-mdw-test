/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_BP_RELACIONES_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String bp = null;
	
	private String rfc = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastname1 = null;
	
	private String lastname2 = null;
 	
	
	
	/**
	 * 
	 */
	public ZFM_BP_RELACIONES_OutputData() {
		super();
	}

	
	
	/**
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}



	/**
	 * @param bp the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}

	


	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}



	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}



	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}



	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}



	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}



	/**
	 * @return the lastname1
	 */
	public String getLastname1() {
		return lastname1;
	}



	/**
	 * @param lastname1 the lastname1 to set
	 */
	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}



	/**
	 * @return the lastname2
	 */
	public String getLastname2() {
		return lastname2;
	}



	/**
	 * @param lastname2 the lastname2 to set
	 */
	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
