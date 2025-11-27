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
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E103_READ_PBRMS_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_E103_READ_PBRMS_ProxyImpl.class );
	
	public ZCRMORI_E103_READ_PBRMS_ProxyImpl() {
		super();		
	}

	public ZTE_SURVEY_Model executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ZTE_SURVEY_Model surveyOutput = new ZTE_SURVEY_Model();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E103_READ_PBRMS" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E103_READ_PBRMS not found in SAP.");
			
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
			
			JCoTable tableQuestion = function.getExportParameterList().getTable("ET_BRMS");
			log.info( "" +  tableQuestion.toString() );
			ArrayList<ZTL_QUESTION_Model> _questionList = new ArrayList<ZTL_QUESTION_Model>();
			
			for (int i = 0; i < tableQuestion.getNumRows(); i++, tableQuestion.nextRow() ) {
				ZTL_QUESTION_Model question = new ZTL_QUESTION_Model();
				question.setNumberQuestion( tableQuestion.getString("NUMPRE") );
				question.setDescription( tableQuestion.getString("PREGUNTA") );
				question.setCoinType( tableQuestion.getString("MONEDA") );
				question.setQuestionKey( tableQuestion.getString("KPRBMS") );
				 
				surveyOutput.setApplicationId( tableQuestion.getString("NUMDOC") );
				surveyOutput.setBpId( tableQuestion.getString("BP_ID") );
				surveyOutput.setId( tableQuestion.getString("GUID_SRVY") );
				
				JCoTable tableAnswer = tableQuestion.getTable("RESPUESTAS");
				ArrayList<ZTL_ANSWER_Model> _answersList = new ArrayList<ZTL_ANSWER_Model>();
				for (int j = 0; j < tableAnswer.getNumRows(); j++, tableAnswer.nextRow() ) {
					ZTL_ANSWER_Model answer = new ZTL_ANSWER_Model();
					answer.setId( tableAnswer.getString("GUID_RESP") );
					answer.setValueId( tableAnswer.getString("GUID_VALO") );
					answer.setDescription( tableAnswer.getString("RESPUESTA") );
					answer.setMinValue( tableAnswer.getDouble("VAL_LOW") );
					answer.setMaxValue( tableAnswer.getDouble("VAL_HIGH") );
					answer.setAnswerKey( tableAnswer.getString("KPBRMS") );
					
					question.setId( tableAnswer.getString("GUID_PREG") );
					_answersList.add( answer );
				}
				question.setAnswers( _answersList );
		
				_questionList.add( question );
			}
			surveyOutput.setQuestions( _questionList );
			
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E103_READ_PBRMS" , e);
			throw e;
		} finally {
			
		}
		
		return( surveyOutput );
	}
	
}
