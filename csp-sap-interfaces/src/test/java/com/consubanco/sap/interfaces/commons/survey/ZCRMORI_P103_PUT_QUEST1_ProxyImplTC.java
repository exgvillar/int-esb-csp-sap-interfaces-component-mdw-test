package com.consubanco.sap.interfaces.commons.survey;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P103_PUT_QUEST1_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_ANSWER_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_QUESTION_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

import junit.framework.TestCase;

public class ZCRMORI_P103_PUT_QUEST1_ProxyImplTC extends TestCase{

	private JCoDestination destination;
	
	public ZCRMORI_P103_PUT_QUEST1_ProxyImplTC(String name) throws JCoException {
		super(name);
		CRMLocalConfigEnvironmentData.instance();
		destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	}

	public void testDestination( ) throws Exception {	
        
        ZCRMORI_P103_PUT_QUEST1_ProxyImpl proxy = new ZCRMORI_P103_PUT_QUEST1_ProxyImpl();
        
        ZTE_SURVEY_Model surveyInputParams = new ZTE_SURVEY_Model();
        
        ArrayList<ZTL_QUESTION_Model> questionsList = new ArrayList<ZTL_QUESTION_Model>();
        ZTL_QUESTION_Model question = new ZTL_QUESTION_Model();
        question.setId("q1");
        question.setNumberQuestion("0001");
        question.setDescription("¿Usted es una persona en situación de vulnerabilidad?");
        question.setComponentType("OB");
        
        ArrayList<ZTL_ANSWER_Model> answersList = new ArrayList<ZTL_ANSWER_Model>();
        ZTL_ANSWER_Model answer11 = new ZTL_ANSWER_Model();
        answer11.setDescription("Sí");
        answer11.setComponentType("OB");
        answer11.setSelection(true);
        answer11.setFreeText("");
        answer11.setId("a1");
        answer11.setValueId("id_005056b3009f1eeeb39dcb56ddfc4305");
        
        answersList.add( answer11 );
        
        ZTL_ANSWER_Model answer12 = new ZTL_ANSWER_Model();
        answer12.setDescription("No");
        answer12.setComponentType("OB");
        answer12.setSelection(true);
        answer12.setFreeText("");
        answer12.setId("a1");
        answer12.setValueId("id_005056b3009f1eeeb39dd84b46734305");
        
        answersList.add( answer12 );
        question.setAnswers( answersList );
        
        questionsList.add( question );
        
        ZTL_QUESTION_Model question2 = new ZTL_QUESTION_Model();
        question2.setId("id_005056b3009f1eefa1b6447b9ae5a311");
        question2.setNumberQuestion("0002");
        question2.setDescription("Declaro de forma libre y voluntaria que pertenezco a alguno de los\r\nsiguientes grupos de personas en situación de vulnerabilidad.");
        question2.setComponentType("CB");
       
        
        ArrayList<ZTL_ANSWER_Model> answersList2 = new ArrayList<ZTL_ANSWER_Model>();
        
        ZTL_ANSWER_Model answer21 = new ZTL_ANSWER_Model();
        answer21.setDescription("Adultos Mayores");
        answer21.setComponentType("CB");
        answer21.setSelection(true);
        answer21.setFreeText("");
        answer21.setId("id_005056b3009f1eefa1b648a7b357e311");
        answer21.setValueId("id_005056b3009f1eefa1b648a7b3584311");
        
        answersList2.add( answer21 );
        
        ZTL_ANSWER_Model answer22 = new ZTL_ANSWER_Model();
        answer22.setDescription("Personas con Discapacidad");
        answer22.setComponentType("CB");
        answer22.setSelection(true);
        answer22.setFreeText("");
        answer22.setId("id_005056b3009f1eefa1b648a7b357e311");
        answer22.setValueId("id_005056b3009f1eefa1b64bf3a4c7a311");
        
        answersList2.add( answer22 );
        
        ZTL_ANSWER_Model answer23 = new ZTL_ANSWER_Model();
        answer23.setDescription("Pertenezco a alguna etnia, pueblo o comunidad indígena");
        answer23.setComponentType("CB");
        answer23.setSelection(true);
        answer23.setFreeText("");
        answer23.setId("id_005056b3009f1eefa1b648a7b357e311");
        answer23.setValueId("id_005056b3009f1eefa1b64cd47307e311");
        
        answersList2.add( answer23 );
        
        ZTL_ANSWER_Model answer24 = new ZTL_ANSWER_Model();
        answer24.setDescription("Otro tipo de grupos");
        answer24.setComponentType("OP");
        answer24.setSelection(true);
        answer24.setFreeText("");
        answer24.setId("id_005056b3009f1eefa1b648a7b357e311");
        answer24.setValueId("id_005056b3009f1eefa1cd77aa0495a311");
        
        answersList2.add( answer24 );
        
        question2.setAnswers( answersList2 );
        
        questionsList.add( question2 );
        
        ArrayList<ZTL_ANSWER_Model> answersList3 = new ArrayList<ZTL_ANSWER_Model>();
        
        ZTL_QUESTION_Model question3 = new ZTL_QUESTION_Model();
        question3.setId("id_005056b3009f1eefb7bb579c16bc4313");
        question3.setNumberQuestion("0003");
        question3.setDescription("Otros");
        question3.setComponentType("CB");
        
        ZTL_ANSWER_Model answer31 = new ZTL_ANSWER_Model();
        answer31.setDescription("Soy Mujer embarazada");
        answer31.setComponentType("CB");
        answer31.setSelection(true);
        //answer31.setFreeText("");
        answer31.setId("id_005056b3009f1eefa1b65940745f2311");
        answer31.setValueId("id_005056b3009f1eefb7bb006725734313");
        
        answersList3.add( answer31 );
        
        ZTL_ANSWER_Model answer32 = new ZTL_ANSWER_Model();
        answer32.setDescription("Me considero del grupo LGBT o LGBTQ+");
        answer32.setComponentType("CB");
        answer32.setSelection(true);
        //answer32.setFreeText("");
        answer32.setId("id_005056b3009f1eefa1b65940745f2311");
        answer32.setValueId("id_005056b3009f1eefb7bb04fcdbfee313");
        
        answersList3.add( answer32 );
        
        ZTL_ANSWER_Model answer33 = new ZTL_ANSWER_Model();
        answer33.setDescription("Soy migrante");
        answer33.setComponentType("CB");
        answer33.setSelection(true);
        //answer33.setFreeText("");
        answer33.setId("id_005056b3009f1eefa1b65940745f2311");
        answer33.setValueId("id_005056b3009f1eefb7bb05daab2f6313");
        
        answersList3.add( answer33 );
        
        ZTL_ANSWER_Model answer34 = new ZTL_ANSWER_Model();
        answer34.setDescription("Soy jornalero o agricultor");
        answer34.setComponentType("CB");
        answer34.setSelection(true);
        //answer34.setFreeText("");
        answer34.setId("id_005056b3009f1eefa1b65940745f2311");
        answer34.setValueId("id_005056b3009f1eefb7bb06fbd6a9c313");
        
        answersList3.add( answer34 );
        
        question3.setAnswers(answersList3);
        questionsList.add( question3 );
        
        surveyInputParams.setQuestions( questionsList );
        
        surveyInputParams.setId("CUESTIONARIO PERSONA VULNERABLE");
        surveyInputParams.setTextInfo("");
        surveyInputParams.setVersion("0000000002");
        surveyInputParams.setMasterLenguage("");
        surveyInputParams.setLanguage("S");
        surveyInputParams.setApplicationId("CRM_SURVEY_ACTIVITY");
        surveyInputParams.setValueGuid("");
        surveyInputParams.setValueVersion("0000000001");
        surveyInputParams.setValueVersionInfoText("");
        surveyInputParams.setValueXml("");
        surveyInputParams.setMust("");
        surveyInputParams.setNotChangeable("");
        surveyInputParams.setCreatedAt("0");
        surveyInputParams.setCreatedBy("");
        surveyInputParams.setModifiedAt("0");
        surveyInputParams.setModifiedBy("");
        surveyInputParams.setProcessMode("");
        surveyInputParams.setProcessText("");
        
        proxy.executeRemoteFunction(destination, "0007131453", surveyInputParams );
        
	}
}
