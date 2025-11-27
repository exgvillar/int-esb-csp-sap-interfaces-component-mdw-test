package com.consubanco.sap.interfaces.common.survey;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_ANSWER_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_QUESTION_Model;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P103_PUT_QUEST_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P103_PUT_QUEST_ProxyImpl.class );
	
	public ZCRMORI_P103_PUT_QUEST_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, String folioApplication, String documentType, String customerId, ZTE_SURVEY_Model surveyInputParams ) throws Exception {
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P103_PUT_QUEST" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P103_PUT_QUEST not found in SAP.");
			
			function = ft.getFunction();
	
			if( surveyInputParams != null ) {
				function.getImportParameterList().setValue("I_SOLICITUD", folioApplication );
				function.getImportParameterList().setValue("I_TIPDOC", documentType );
				function.getImportParameterList().setValue("I_BP", customerId );

				JCoTable questionsTable = function.getImportParameterList().getTable("I_QUESTIONARIO");
				if( surveyInputParams.getQuestions() != null ){
					Iterator<ZTL_QUESTION_Model> i = surveyInputParams.getQuestions().iterator();
					while( i.hasNext() ){
						ZTL_QUESTION_Model _question = (ZTL_QUESTION_Model)i.next();
						questionsTable.appendRow();
						questionsTable.setValue( "NUMPRE", _question.getNumberQuestion() );
						questionsTable.setValue( "TYPE_REC", "Question" );
						questionsTable.setValue( "DESCRIP", _question.getDescription() );
						questionsTable.setValue( "TIPO_RESP", _question.getComponentType() );
						
						JCoTable answersTable = questionsTable.getTable("ANSWERS");
						if( _question.getAnswers() != null ){
							Iterator<ZTL_ANSWER_Model> it = _question.getAnswers().iterator();
							while( it.hasNext() ){
								ZTL_ANSWER_Model _answer = (ZTL_ANSWER_Model)it.next();
								answersTable.appendRow();
								answersTable.setValue( "DESCRIP", _answer.getDescription() );
								answersTable.setValue( "SELECTION", _answer.isSelection() ? "X" : "" );
								answersTable.setValue( "TIPO_RESP", _answer.getComponentType() );
								answersTable.setValue( "FREE_TEXT", _answer.getFreeText() );
								answersTable.setValue( "GUID_PREG", _question.getId() );
								answersTable.setValue( "GUID_RESP", _answer.getId() );
								answersTable.setValue( "GUID_VALO", _answer.getValueId() );
								
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
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P103_PUT_QUEST :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return;
	}
	
}
