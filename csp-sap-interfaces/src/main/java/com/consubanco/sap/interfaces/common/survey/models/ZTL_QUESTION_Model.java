/**
 * 
 */
package com.consubanco.sap.interfaces.common.survey.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_QUESTION_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

		private String id = null;
		
		private String numberQuestion = null;
		
		private String level = null;
		
		private String description = null;
		
		private String componentType = null;
		
		private String coinType = null;
		
		private String questionKey = null;
		
		private ArrayList<ZTL_ANSWER_Model> answers = null; 
		
			      
	
	/**
	 * 
	 */
	public ZTL_QUESTION_Model() {
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
	 * @return the numberQuestion
	 */
	public String getNumberQuestion() {
		return numberQuestion;
	}




	/**
	 * @param numberQuestion the numberQuestion to set
	 */
	public void setNumberQuestion(String numberQuestion) {
		this.numberQuestion = numberQuestion;
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
	 * @return the answers
	 */
	public ArrayList<ZTL_ANSWER_Model> getAnswers() {
		return answers;
	}




	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(ArrayList<ZTL_ANSWER_Model> answers) {
		this.answers = answers;
	}




	/**
	 * @return the coinType
	 */
	public String getCoinType() {
		return coinType;
	}




	/**
	 * @param coinType the coinType to set
	 */
	public void setCoinType(String coinType) {
		this.coinType = coinType;
	}




	/**
	 * @return the questionKey
	 */
	public String getQuestionKey() {
		return questionKey;
	}




	/**
	 * @param questionKey the questionKey to set
	 */
	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
