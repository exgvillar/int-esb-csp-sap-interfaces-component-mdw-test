package com.consubanco.sap.interfaces.common.survey;

import java.util.ArrayList;
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
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoRuntimeException;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E103_READ_PBRMS1_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_E103_READ_PBRMS1_ProxyImpl.class );
	private static final String RFC = "ZCRMORI_E103_READ_PBRMS1";
	
	public ZCRMORI_E103_READ_PBRMS1_ProxyImpl() {
		super();		
	}
	
	public ZTE_SURVEY_Model executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws RFCNotFoundException, RFCExecutionException, ComponentException {
		
		ZTE_SURVEY_Model surveyOutput = new ZTE_SURVEY_Model();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate(RFC);
			if (ft == null)
				throw new RFCNotFoundException(RFC + " not found in SAP.");
			
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
			
			String message = StringUtils.trimToEmpty(function.getExportParameterList().getString("E_MESSAGE"));
			message = message.equals("")?"Message not obtained from RFC: " + RFC: message;
			boolean success = StringUtils.trimToEmpty(function.getExportParameterList().getString("E_SUCCESS")).equalsIgnoreCase("X");
			
			if (!success) throw new RFCExecutionException("Error during RFC execution: " + RFC + ". Reason: " + message);
			JCoTable tableQuestion = function.getExportParameterList().getTable("ET_BRMS");
			log.info("tableQuestion: " + tableQuestion);
			ArrayList<ZTL_QUESTION_Model> questionList = new ArrayList<ZTL_QUESTION_Model>();
			
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
				log.info("tableAnswer: " + tableAnswer);
				ArrayList<ZTL_ANSWER_Model> answersList = new ArrayList<ZTL_ANSWER_Model>();
				for (int j = 0; j < tableAnswer.getNumRows(); j++, tableAnswer.nextRow() ) {
					ZTL_ANSWER_Model answer = new ZTL_ANSWER_Model();
					answer.setId( tableAnswer.getString("GUID_RESP") );
					answer.setValueId( tableAnswer.getString("GUID_VALO") );
					answer.setDescription( tableAnswer.getString("RESPUESTA") );
					answer.setMinValue( tableAnswer.getDouble("VAL_LOW") );
					answer.setMaxValue( tableAnswer.getDouble("VAL_HIGH") );
					answer.setAnswerKey( tableAnswer.getString("KPBRMS") );
					
					question.setId( tableAnswer.getString("GUID_PREG") );
					answersList.add( answer );
				}
				question.setAnswers( answersList );
		
				questionList.add( question );
			}
			surveyOutput.setQuestions( questionList );
			
			
	
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
		
		return( surveyOutput );
	}
}
