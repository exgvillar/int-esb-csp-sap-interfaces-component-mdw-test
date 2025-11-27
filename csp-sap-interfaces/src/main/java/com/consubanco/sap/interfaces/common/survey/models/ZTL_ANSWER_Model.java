/**
 * 
 */
package com.consubanco.sap.interfaces.common.survey.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_ANSWER_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

		private String id = null;
		
		private String level = null; 
		
		private String description = null;
	    
		private boolean selection = false;
		
		private String componentType = null;
	    
		private String freeText = null;
	    
		private double minValue = 0;
	    
		private double maxValue = 0;
	    
		private String valueId = null; 
		
		private String answerKey = null;
		
			      
	
	/**
	 * 
	 */
	public ZTL_ANSWER_Model() {
		super();
	}

	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}




	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}




	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}




	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}





	/**
	 * @return the selection
	 */
	public boolean isSelection() {
		return selection;
	}




	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}



	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}



	/**
	 * @param selection the selection to set
	 */
	public void setSelection(boolean selection) {
		this.selection = selection;
	}




	/**
	 * @return the freeText
	 */
	public String getFreeText() {
		return freeText;
	}




	/**
	 * @param freeText the freeText to set
	 */
	public void setFreeText(String freeText) {
		this.freeText = freeText;
	}




	/**
	 * @return the minValue
	 */
	public double getMinValue() {
		return minValue;
	}




	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}




	/**
	 * @return the maxValue
	 */
	public double getMaxValue() {
		return maxValue;
	}




	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}




	/**
	 * @return the valueId
	 */
	public String getValueId() {
		return valueId;
	}




	/**
	 * @param valueId the valueId to set
	 */
	public void setValueId(String valueId) {
		this.valueId = valueId;
	}




	/**
	 * @return the answerKey
	 */
	public String getAnswerKey() {
		return answerKey;
	}



	/**
	 * @param answerKey the answerKey to set
	 */
	public void setAnswerKey(String answerKey) {
		this.answerKey = answerKey;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
