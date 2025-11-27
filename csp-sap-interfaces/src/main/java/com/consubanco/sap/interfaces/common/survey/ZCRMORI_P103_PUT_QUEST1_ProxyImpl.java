package com.consubanco.sap.interfaces.common.survey;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_ANSWER_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_QUESTION_Model;
import com.consubanco.sap.interfaces.exceptions.ComponentException;
import com.consubanco.sap.interfaces.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.exceptions.RFCNotFoundException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoRuntimeException;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P103_PUT_QUEST1_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMORI_P103_PUT_QUEST1_ProxyImpl.class);
	private static final String RFC = "ZCRMORI_P103_PUT_QUEST1";
	
	public void executeRemoteFunction( JCoDestination destination, String customerBp, ZTE_SURVEY_Model surveyInputParams ) throws RFCNotFoundException, RFCExecutionException, ComponentException {
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate(RFC);
			if (ft == null)
				throw new RFCNotFoundException(RFC + " not found in SAP.");
			
			function = ft.getFunction();
	
			if( surveyInputParams != null ) {
				function.getImportParameterList().setValue("I_BP", customerBp );

				JCoTable questionsTable = function.getImportParameterList().getTable("I_QUESTIONARIO");
				if( surveyInputParams.getQuestions() != null ){
					Iterator<ZTL_QUESTION_Model> i = surveyInputParams.getQuestions().iterator();
					while( i.hasNext() ){
						ZTL_QUESTION_Model question = (ZTL_QUESTION_Model)i.next();
						questionsTable.appendRow();
						questionsTable.setValue( "NUMPRE", question.getNumberQuestion() );
						questionsTable.setValue( "TYPE_REC", "Quesion" );
						questionsTable.setValue( "DESCRIP", question.getDescription() );
						questionsTable.setValue( "TIPO_RESP", question.getComponentType() );
						
						JCoTable answersTable = questionsTable.getTable("ANSWERS");
						if( question.getAnswers() != null ){
							Iterator<ZTL_ANSWER_Model> it = question.getAnswers().iterator();
							while( it.hasNext() ){
								ZTL_ANSWER_Model answer = (ZTL_ANSWER_Model)it.next();
								answersTable.appendRow();
								answersTable.setValue( "DESCRIP", answer.getDescription() );
								answersTable.setValue( "SELECTION", answer.isSelection() ? "X" : "" );
								answersTable.setValue( "TIPO_RESP", answer.getComponentType() );
								answersTable.setValue( "FREE_TEXT", answer.getFreeText() );
								answersTable.setValue( "GUID_PREG", question.getId() );
								answersTable.setValue( "GUID_RESP", answer.getId() );
								answersTable.setValue( "GUID_VALO", answer.getValueId() );
								
							}//while answer
							questionsTable.setValue("ANSWERS", answersTable);
						}
					}//while questions
				}
				
				JCoStructure surveyStructure = function.getImportParameterList().getStructure("I_IDSURVEY");
				surveyStructure.setValue( "SURVEYID", surveyInputParams.getId() );
				surveyStructure.setValue( "SURVEYID_INFO_TEXT", surveyInputParams.getTextInfo() );
				surveyStructure.setValue( "SURVEYVERSION", surveyInputParams.getVersion() );
				surveyStructure.setValue( "SURVEY_MASTERLANGUAGE", surveyInputParams.getMasterLenguage() );
				surveyStructure.setValue( "SURVEY_LANGUAGE", surveyInputParams.getLanguage() );
				surveyStructure.setValue( "APPLICATIONID", surveyInputParams.getApplicationId() );
				surveyStructure.setValue( "VALUEGUID", surveyInputParams.getValueGuid() );
				surveyStructure.setValue( "VALUEVERSION", surveyInputParams.getValueVersion() );
				surveyStructure.setValue( "VALUEVERSION_INFO_TEXT", surveyInputParams.getValueVersionInfoText() );
				surveyStructure.setValue( "VALUEXML", surveyInputParams.getValueXml() );
				surveyStructure.setValue( "MUST", surveyInputParams.getMust() );
				surveyStructure.setValue( "NOT_CHANGEABLE", surveyInputParams.getNotChangeable() );
				surveyStructure.setValue( "CREATED_AT", surveyInputParams.getCreatedAt() );
				surveyStructure.setValue( "CREATED_BY", surveyInputParams.getCreatedBy() );
				surveyStructure.setValue( "MODIFIED_AT", surveyInputParams.getModifiedAt() );
				surveyStructure.setValue( "MODIFIED_BY", surveyInputParams.getModifiedBy() );
				surveyStructure.setValue( "SURVEY_PROCESS_MODE", surveyInputParams.getProcessMode() );
				surveyStructure.setValue( "SURVEY_PROCESS_MODE_TEXT", surveyInputParams.getProcessText() );
				
			}
						
			function.execute(destination);
			String message = StringUtils.trimToEmpty(function.getExportParameterList().getString("E_MESSAGE"));
			message = message.equals("")?"Message not obtained from RFC: " + RFC: message;
			boolean success = StringUtils.trimToEmpty(function.getExportParameterList().getString("E_SUCCESS")).equalsIgnoreCase("X");
			
			if (!success) throw new RFCExecutionException("Error during RFC execution: " + RFC + ". Reason: " + message);
	
		} catch (JCoException e) {
			log.error("Exception executing function " + RFC + " - " + e + " - ");
			throw new RFCExecutionException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (JCoRuntimeException e) {
			log.error("Exception executing function " + RFC + " - " + e + " - ");
			throw new RFCExecutionException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (RuntimeException e) {
			log.error("Logic Exception: " + e);
			throw new ComponentException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
	
	
}
