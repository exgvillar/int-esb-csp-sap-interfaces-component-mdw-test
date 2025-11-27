package com.consubanco.sap.interfaces.common.survey;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_ANSWER_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_QUESTION_Model;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P102_GET_QUEST_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P102_GET_QUEST_ProxyImpl.class );
	
	public ZCRMORI_P102_GET_QUEST_ProxyImpl() {
		super();		
	}

	public ZTE_SURVEY_Model executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ZTE_SURVEY_Model surveyOutput = new ZTE_SURVEY_Model();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P102_GET_QUEST" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P102_GET_QUEST not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			
			function.execute(destination);
			
			JCoTable tableQuestion = function.getExportParameterList().getTable("E_QUESTIONARIO");
			log.info( "" +  tableQuestion.toString() );
			ArrayList<ZTL_QUESTION_Model> _questionList = new ArrayList<ZTL_QUESTION_Model>();
			
			for (int i = 0; i < tableQuestion.getNumRows(); i++, tableQuestion.nextRow() ) {
				ZTL_QUESTION_Model question = new ZTL_QUESTION_Model();
				question.setNumberQuestion( tableQuestion.getString("NUMPRE") );
				question.setDescription( tableQuestion.getString("DESCRIP") );
				question.setComponentType( tableQuestion.getString("TIPO_RESP") );
				
				JCoTable tableAnswer = tableQuestion.getTable("ANSWERS");
				ArrayList<ZTL_ANSWER_Model> _answersList = new ArrayList<ZTL_ANSWER_Model>();
				for (int j = 0; j < tableAnswer.getNumRows(); j++, tableAnswer.nextRow() ) {
					ZTL_ANSWER_Model answer = new ZTL_ANSWER_Model();
					answer.setDescription( tableAnswer.getString("DESCRIP") );
					answer.setComponentType( tableAnswer.getString("TIPO_RESP") );
					answer.setFreeText( StringUtils.trimToEmpty(tableAnswer.getString("FREE_TEXT") ) );
					answer.setId( tableAnswer.getString("GUID_RESP") );
					answer.setValueId( tableAnswer.getString("GUID_VALO") );
					
					question.setId( tableAnswer.getString("GUID_PREG") );
					
					_answersList.add( answer );
				}
				question.setAnswers( _answersList );
				
				if( tableQuestion.getString("TYPE_REC").equals( "Question" ) )
					_questionList.add( question );
			}
			surveyOutput.setQuestions( _questionList );
			
			JCoStructure data = function.getExportParameterList().getStructure("E_IDSURVEY");
			surveyOutput.setId( StringUtils.trimToEmpty( data.getString("SURVEYID") ) );
			surveyOutput.setTextInfo( StringUtils.trimToEmpty( data.getString("SURVEYID_INFO_TEXT") ) );
			surveyOutput.setVersion( StringUtils.trimToEmpty( data.getString("SURVEYVERSION") ) );
			surveyOutput.setMasterLenguage( StringUtils.trimToEmpty( data.getString("SURVEY_MASTERLANGUAGE") ) );
			surveyOutput.setLanguage( StringUtils.trimToEmpty( data.getString("SURVEY_LANGUAGE") ) );
			surveyOutput.setApplicationId( StringUtils.trimToEmpty( data.getString("APPLICATIONID") ) );
			surveyOutput.setValueGuid( StringUtils.trimToEmpty( data.getString("VALUEGUID") ) );
			surveyOutput.setValueVersion( StringUtils.trimToEmpty( data.getString("VALUEVERSION") ) );
			surveyOutput.setValueVersionInfoText( StringUtils.trimToEmpty( data.getString("VALUEVERSION_INFO_TEXT") ) );
			surveyOutput.setValueXml( StringUtils.trimToEmpty( data.getString("VALUEXML") ) );
			surveyOutput.setMust( StringUtils.trimToEmpty( data.getString("MUST") ) );
			surveyOutput.setNotChangeable( StringUtils.trimToEmpty( data.getString("NOT_CHANGEABLE") ) );
			surveyOutput.setCreatedAt( StringUtils.trimToEmpty( data.getString("CREATED_AT") ) );
			surveyOutput.setCreatedBy( StringUtils.trimToEmpty( data.getString("CREATED_BY") ) );
			surveyOutput.setModifiedAt( StringUtils.trimToEmpty( data.getString("MODIFIED_AT") ) );
			surveyOutput.setModifiedBy( StringUtils.trimToEmpty( data.getString("MODIFIED_BY") ) );
			surveyOutput.setProcessMode( StringUtils.trimToEmpty( data.getString("SURVEY_PROCESS_MODE") ) );
			surveyOutput.setProcessText( StringUtils.trimToEmpty( data.getString("SURVEY_PROCESS_MODE_TEXT") ) );
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P102_GET_QUEST" , e);
			throw e;
		} finally {
			
		}
		
		return( surveyOutput );
	}
	
}
