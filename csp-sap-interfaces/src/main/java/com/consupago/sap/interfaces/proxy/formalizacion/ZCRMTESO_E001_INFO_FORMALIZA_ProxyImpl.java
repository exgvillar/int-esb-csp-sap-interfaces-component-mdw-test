package com.consupago.sap.interfaces.proxy.formalizacion;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author jcontreras
 * Llamada al JCO que devuelve la informacion necesaria para inyectar al WS de Formalizacion 
 * de las solicitudes.
 * 
 */
public class ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMTESO_E001_INFO_FORMALIZA";
	
	public ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl() {
		super();		
	}

	public ZCRMTESO_E001_INFO_FORMALIZA_OutputData executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ZCRMTESO_E001_INFO_FORMALIZA_OutputData output = new ZCRMTESO_E001_INFO_FORMALIZA_OutputData();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			JCoTable tableInput = function.getImportParameterList().getTable("I_SOLICITUD");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			
			while( iterRecord.hasNext() ) {
				tableInput.appendRow();
				ArrayList<ProxyInputParameter> recordParam = (ArrayList<ProxyInputParameter>) iterRecord.next();
				Iterator<ProxyInputParameter> iterRecorParam = recordParam.iterator();
				while (iterRecorParam.hasNext()) {
					ProxyInputParameter inputParam = (ProxyInputParameter) iterRecorParam.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
						
					} else {
						if( inputParam.getType().equals("java.util.Date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}
				}
			}
//			log.info("input : " +  tableInput.toString() );
			function.execute(destination);
			JCoStructure rootEstructura = function.getExportParameterList().getStructure("E_DATA");
			output.setApplicationId(rootEstructura.getString("APPLICATION_ID"));
			output.setRequestId(rootEstructura.getString("REQUEST_ID"));
			
			// recupero los elementos padre de las estruturas iniciales...
			JCoTable tabcreditBO = rootEstructura.getTable("CREDIT_BO");
			// estrutura base de los creditos ...
			JCoStructure estCreditInfoBO = tabcreditBO.getStructure("CREDIT_INFO_BO");
			
			//recupero los valores devueltos en la estructura para el credito ...
			JCoStructure estCredit = estCreditInfoBO.getStructure("CREDIT");
			Credit creditobj = new Credit();
			creditobj.setVatrate(estCredit.getString("VATRATE") );
			creditobj.setTotalTaxAmt(estCredit.getString("TOTAL_TAX_AMT") );
			creditobj.setTotalPrincipalAmt(estCredit.getString("TOTAL_PRINCIPAL_AMT") );
			creditobj.setTotalPaymentsNbr(estCredit.getString("TOTAL_PAYMENTS_NBR") );
			creditobj.setTotalInterestAmt(estCredit.getString("TOTAL_INTEREST_AMT") );
			creditobj.setTaxPaymentAmt(estCredit.getString("TAX_PAYMENT_AMT") );
			creditobj.setSubstitutionAmt(estCredit.getString("SUBSTITUTION_AMT") );
			creditobj.setRegionCrm(estCredit.getString("REGION_CRM") );
			creditobj.setReferenceNbr(estCredit.getString("REFERENCE_NBR") );
			creditobj.setPromoterCrm(estCredit.getString("PROMOTER_CRM") );
			creditobj.setProductCrm(estCredit.getString("PRODUCT_CRM") );
			creditobj.setPrincipalPaymentAmt(estCredit.getString("PRINCIPAL_PAYMENT_AMT") );
			creditobj.setPayrollNbr(estCredit.getString("PAYROLL_NBR") );
			creditobj.setPaymentUnitCrm(estCredit.getString("PAYMENT_UNIT_CRM") );
			creditobj.setPaymentFrequencyCrm(estCredit.getString("PAYMENT_FREQUENCY_CRM") );
			creditobj.setPayerNbr(estCredit.getString("PAYER_NBR") );
			creditobj.setOldCreditCrm(estCredit.getString("OLD_CREDIT_CRM") );
			creditobj.setInterestRatePct(estCredit.getString("INTEREST_RATE_PCT") );
			creditobj.setInterestPaymentAmt(estCredit.getString("INTEREST_PAYMENT_AMT") );
			creditobj.setFundingDt(estCredit.getString("FUNDING_DT") );
			creditobj.setFundingAmt(estCredit.getString("FUNDING_AMT") );
			creditobj.setFormalizationDt(estCredit.getString("FORMALIZATION_DT") );
			creditobj.setFirstPaymentExpectedDt(estCredit.getString("FIRST_PAYMENT_EXPECTED_DT") );
			creditobj.setFieldReference3(estCredit.getString("FIELD_REFERENCE3") );
			creditobj.setFieldReference2(estCredit.getString("FIELD_REFERENCE2") );
			creditobj.setFieldReference1(estCredit.getString("FIELD_REFERENCE1") );
			creditobj.setEmployeeTypeDesc(estCredit.getString("EMPLOYEE_TYPE_DESC") );
			creditobj.setDistribuidorCrm(estCredit.getString("DISTRIBUIDOR_CRM") );
			creditobj.setDisbursementDt(estCredit.getString("DISBURSEMENT_DT") );
			creditobj.setDependenciaCrm(estCredit.getString("DEPENDENCIA_CRM") );
			creditobj.setCreditCrm(estCredit.getString("CREDIT_CRM") );
			creditobj.setCompanyCd(estCredit.getString("COMPANY_CD") );
			creditobj.setBudgetNbr(estCredit.getString("BUDGET_NBR") );
			creditobj.setBranchCrm(estCredit.getString("BRANCH_CRM") );
			creditobj.setBankReferenceNbr(estCredit.getString("BANK_REFERENCE_NBR") );
			creditobj.setAccountSpreadMethodCrm(estCredit.getString("ACCOUNT_SPREAD_METHOD_CRM") );
			creditobj.setAccounId(estCredit.getString("ACCOUN_ID") );
			creditobj.setCat(estCredit.getString("CAT") );
			creditobj.setIntercompania(estCredit.getString("INTERCOMPANIA") );
			creditobj.setAutoservicio(estCredit.getString("AUTOSERVICIO") );
			
			output.setCredit(creditobj);
			
			// obtengo la estructura para los customizables
			JCoTable tabCustomizable = estCreditInfoBO.getStructure("CUSTOMIZABLE_INFO_BO").getTable("CUSTOMIZABLE");
			ArrayList<Customizables> arrCustomizables = new ArrayList<Customizables>();
			for (int i = 0; i < tabCustomizable.getNumRows(); i++, tabCustomizable.nextRow() ) {
				Customizables customizables = new Customizables();
				customizables.setCustomfieldValue(StringUtils.trimToEmpty(tabCustomizable.getString("FIELD_VALUE")) );
				customizables.setCustomfieldKey( StringUtils.trimToEmpty(tabCustomizable.getString("FIELD_KEY")) );
				customizables.setCustomconvenioCrm(tabCustomizable.getString("CONVENIO_CRM") );
				arrCustomizables.add(customizables);
			}
			output.setArrCustomizables(arrCustomizables);
			

			// obtengo la estructura de las comisiones
			JCoTable tabComission = estCreditInfoBO.getStructure("COMISSION_INFO_BO").getTable("COMISSION");
			ArrayList<Comission> arrComission = new ArrayList<Comission>();
			for (int i = 0; i < tabComission.getNumRows(); i++, tabComission.nextRow() ) {
				Comission comision = new Comission();
				comision.setComisioncommissionName(tabComission.getString("COMMISSION_NAME") );
				comision.setComisionisDeferred( ( StringUtils.trimToNull( tabComission.getString("IS_DEFERRED") ) != null)?"true":"false" );
				comision.setComisioncommissionAmount(tabComission.getDouble("COMMISSION_AMOUNT") );
				comision.setComisioncommissionDate(tabComission.getDate("COMMISSION_DATE") );
				comision.setComisioncommissionCurrencyName(tabComission.getString("COMMISSION_CURRENCY_NAME") );
				arrComission.add(comision);
			}
			output.setArrComissions(arrComission);

			//obtengo la estructura para credit icbs
			JCoStructure estCreditICBS = estCreditInfoBO.getStructure("CREDIT_ICBS");
			CreditIcbs credicbstobj = new CreditIcbs();
			credicbstobj.setIcbsproductIcbs(estCreditICBS.getInt("PRODUCT_ICBS") );
			credicbstobj.setIcbsoperationType(estCreditICBS.getString("OPERATION_TYPE") );
			credicbstobj.setIcbsbankName(estCreditICBS.getString("BANK_NAME") );
			
			output.setCreditIcbs(credicbstobj);
			
			//obtengo la estructura de insurance.
			JCoTable tabInsurance = estCreditInfoBO.getStructure("INSURANCE_INFO_BO").getTable("INSURANCE");
			ArrayList<Insurance> arrInsurance = new ArrayList<Insurance>();
			for (int i = 0; i < tabInsurance.getNumRows(); i++, tabInsurance.nextRow() ) {
				Insurance insurance = new Insurance();
				insurance.setInsuranceinsuranceAmt(tabInsurance.getString("INSURANCE_AMT") );
				insurance.setInsuranceproductId(tabInsurance.getString("PRODUCT_ID") );
				insurance.setInsuranceproductNm(tabInsurance.getString("PRODUCT_NM") );
				insurance.setInsuranceproductCategory(tabInsurance.getString("PRODUCT_CATEGORY") );
				arrInsurance.add(insurance);
			}
			output.setArrInsurance(arrInsurance);

			//obtengo la estructura de Validacion de dependencia
			JCoStructure tabValidaDepe = estCreditInfoBO.getStructure("VALIDACION_DEPENDENCIA_BO");
			ValidacionDependencia validacionDependencia = new ValidacionDependencia();
			validacionDependencia.setValDepFechaReserva(tabValidaDepe.getString("FECHA_RESERVA"));
			validacionDependencia.setValDepFolio(tabValidaDepe.getString("FOLIO"));
			output.setValidacionDependencia(validacionDependencia);
			
			
			//obtengo la estrutura de customer
			JCoStructure estCustomerInfoBO = tabcreditBO.getStructure("CUSTOMER_INFO_BO");
			JCoStructure estCustomer = estCustomerInfoBO.getStructure("CUSTOMER");
			Customer customerObj = new Customer();
			
			customerObj.setCustomerrfc(estCustomer.getString("RFC") );
			customerObj.setCustomerpaternalNm(estCustomer.getString("PATERNAL_NM") );
			customerObj.setCustomermiddleNm(estCustomer.getString("MIDDLE_NM") );
			customerObj.setCustomermaternalNm(estCustomer.getString("MATERNAL_NM") );
			customerObj.setCustomermaritalStatus(estCustomer.getString("MARITAL_STATUS") );
			customerObj.setCustomeridentificationType(estCustomer.getString("IDENTIFICATION_TYPE") );
			customerObj.setCustomeridentificationNbr(estCustomer.getString("IDENTIFICATION_NBR") );
			customerObj.setCustomerife(estCustomer.getString("IFE") );
			customerObj.setCustomergender(estCustomer.getString("GENDER") );
			customerObj.setCustomerfirstNm(estCustomer.getString("FIRST_NM") );
			customerObj.setCustomercustomerCrm(estCustomer.getString("CUSTOMER_CRM") );
			customerObj.setCustomercurp(estCustomer.getString("CURP") );
			customerObj.setCustomerbirthDt(estCustomer.getString("BIRTH_DT") );
			
			output.setCustomer(customerObj);
			
			//obtengo la estructura de empleo
			JCoStructure estEmployment = estCustomerInfoBO.getStructure("EMPLOYMENT_INFO_BO").getStructure("EMPLOYMENT");
			Employment employment = new Employment();
			
			employment.setEmploymentpuestoNm(estEmployment.getString("PUESTO_NM") );
			employment.setEmploymentpuestoCrm(estEmployment.getString("PUESTO_CRM") );
			employment.setEmploymentpositionNm(estEmployment.getString("POSITION_NM") );
			employment.setEmploymentnetIncome(estEmployment.getString("NET_INCOME") );
			employment.setEmploymenthiringDt(estEmployment.getString("HIRING_DT") );
			employment.setEmploymentgrossIncome(estEmployment.getString("GROSS_INCOME") );
			employment.setEmploymentcompanyNm(estEmployment.getString("COMPANY_NM") );
			
			output.setEmployment(employment);
			
			
			//obtengo la estrutura de Address 
			JCoTable tabAddress = estCustomerInfoBO.getStructure("ADDRESS_INFO_BO").getTable("ADDRESS");
			ArrayList<Address> arrAddress = new ArrayList<Address>();
			for (int i = 0; i < tabAddress.getNumRows(); i++, tabAddress.nextRow() ) {
				Address address = new Address();
				address.setAddressstreet(tabAddress.getString("STREET") );
				address.setAddressstateCrm(tabAddress.getString("STATE_CRM") );
				address.setAddresspostalCode(tabAddress.getString("POSTAL_CODE") );
				address.setAddressmunicipio(tabAddress.getString("MUNICIPIO") );
				address.setAddressinternalNbr(tabAddress.getString("INTERNAL_NBR") );
				address.setAddressexternalNbr(tabAddress.getString("EXTERNAL_NBR") );
				address.setAddresscolonia(tabAddress.getString("COLONIA") );
				address.setAddressciudad(tabAddress.getString("CIUDAD") );
				address.setAddressaddressTypeNm(tabAddress.getString("ADDRESS_TYPE_NM") );

				arrAddress.add(address);
			}
			output.setArrAddress(arrAddress);
			
			//obtengo la estructura de contact
			JCoTable tabContact = estCustomerInfoBO.getStructure("CONTACT_INFO_BO").getTable("CONTACT");
			ArrayList<Contact> arrContact = new ArrayList<Contact>();
			for (int i = 0; i < tabContact.getNumRows(); i++, tabContact.nextRow() ) {
				Contact contact = new Contact();
				contact.setContactcontactTypeNm(tabContact.getString("CONTACT_TYPE_NM") );
				contact.setContactcontactNbr(tabContact.getString("CONTACT_NBR") );
				contact.setContactcontactExt(tabContact.getString("CONTACT_EXT") );

				arrContact.add(contact);
			}
			output.setArrContact(arrContact);
			
			//obtengo la estructura de Reference
			JCoTable tabReference = estCustomerInfoBO.getStructure("REFERENCES_INFO_BO").getTable("REFERENCE");
			ArrayList<Reference> arrReference = new ArrayList<Reference>();
			for (int i = 0; i < tabReference.getNumRows(); i++, tabReference.nextRow() ) {
				Reference reference = new Reference();
				reference.setRefrfc(tabReference.getString("RFC") );
				reference.setRefpersonalRelationTypeNm(tabReference.getString("PERSONAL_RELATION_TYPE_NM") );
				reference.setRefpersonalRelationCrm(tabReference.getString("PERSONAL_RELATION_CRM") );
				reference.setRefpaternalNm(tabReference.getString("PATERNAL_NM") );
				reference.setRefmiddleNm(tabReference.getString("MIDDLE_NM") );
				reference.setRefmaternalNm(tabReference.getString("MATERNAL_NM") );
				reference.setRefmaritalStatus(tabReference.getString("MARITAL_STATUS") );
				reference.setRefife(tabReference.getString("IFE") );
				reference.setRefgender(tabReference.getString("GENDER") );
				reference.setReffirstNm(tabReference.getString("FIRST_NM") );
				reference.setRefcurp(tabReference.getString("CURP") );
				reference.setRefbirthDt(tabReference.getString("BIRTH_DT") );
				// obtengo los datos de contacto de las referencias
				ArrayList<Contact> contactRef = new ArrayList<Contact>();
				JCoTable tabContactRef = tabReference.getTable("CONTACT_INFO_BO");
				for(int j= 0;j<tabContactRef.getNumRows(); j++, tabContactRef.nextRow() ){
					Contact contact = new Contact();
					contact.setContactcontactTypeNm( tabContactRef.getString("CONTACT_TYPE_NM") );
					contact.setContactcontactNbr( tabContactRef.getString("CONTACT_NBR") );
					contact.setContactcontactExt( tabContactRef.getString("CONTACT_EXT") );
					contactRef.add(contact);
				}
				reference.setArrContact(contactRef);
				arrReference.add(reference);
			}
			output.setArrReference(arrReference);

			JCoStructure estSubstitutionInfoBO = tabcreditBO.getStructure("SUBSTITUTION_INFO_BO");

			
			
			//obtengo la estructura de substitution
			JCoTable tabSubstitution = estSubstitutionInfoBO.getTable("CREDIT");
			ArrayList<Credit> arrSubstitution = new ArrayList<Credit>();
			for (int i = 0; i < tabSubstitution.getNumRows(); i++, tabSubstitution.nextRow() ) {
				Credit credit = new Credit();
				credit.setSubstitutionAmt(tabSubstitution.getString("SUBSTITUTION_AMT") );
				credit.setOldCreditCrm(tabSubstitution.getString("OLD_CREDIT_CRM") );
				arrSubstitution.add(credit);
			}
			output.setArrSubstitution(arrSubstitution);
			

			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
//		log.info("output : " +  output.toString() );
		return( output );
	}
	
}
