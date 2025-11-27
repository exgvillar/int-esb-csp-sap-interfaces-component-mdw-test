package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author
 * Llamada al JCO que ejecuta la formalizacion de GEM.
 * de las solicitudes.
 * 
 */
public class ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMDWH_E001_INFO_SOLICITUD";
	
	public ZCRMDWH_E001_INFO_SOLICITUD_ProxyImpl() {
		super();		
	}

	public ZCRMDWH_E001_INFO_SOLICITUD_OutputData executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ZCRMDWH_E001_INFO_SOLICITUD_OutputData data = new ZCRMDWH_E001_INFO_SOLICITUD_OutputData();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
				throw new RuntimeException(RFC_NAME + " not found in SAP.");

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
			
			JCoTable dataTableClienteCuentas = function.getExportParameterList().getTable("ET_CLIENTE_CUENTAS");
//			log.info("" + dataTableClienteCuentas.toString());			
			ArrayList<CuentasClientes_OutputData> cuentaList = new ArrayList<CuentasClientes_OutputData>();
			for (int i = 0; i < dataTableClienteCuentas.getNumRows(); i++, dataTableClienteCuentas.nextRow()) {		
				CuentasClientes_OutputData cuentaClientes = new CuentasClientes_OutputData();				
				cuentaClientes.setBanco(dataTableClienteCuentas.getString("CLIENOMBREBANCO"));	
				cuentaClientes.setClabe(dataTableClienteCuentas.getString("CLIECLABE"));	
				cuentaClientes.setCuentaDispersadora(dataTableClienteCuentas.getString("CLIECUENTADISPERSORA"));	
				cuentaClientes.setIdCliente(dataTableClienteCuentas.getString("CLIEIDSECUENCIAL"));
				cuentaClientes.setIdBanco(dataTableClienteCuentas.getString("CLIEIDDEBANCO"));	
				cuentaClientes.setNumeroCuenta(dataTableClienteCuentas.getString("CLIENUMERODECUENTA"));	
				cuentaClientes.setTipoCuenta(dataTableClienteCuentas.getString("CLIETIPODECUENTA"));				
				cuentaList.add( cuentaClientes );		
			}
			data.setCuentaClienteList(cuentaList);		
			
			JCoTable dataTableIncidencia = function.getExportParameterList().getTable("ET_INCIDENCIAS");
//			log.info("" + dataTableIncidencia.toString());
			ArrayList<Incidencias_OutputData> incidenciaList = new ArrayList<Incidencias_OutputData>();
			for (int i = 0; i < dataTableIncidencia.getNumRows(); i++, dataTableIncidencia.nextRow()) {		
				Incidencias_OutputData incidencia = new Incidencias_OutputData();				
				incidencia.setConsecutivo(dataTableIncidencia.getString("CONSECUTIVO"));	
				incidencia.setContadorVueltas(dataTableIncidencia.getString("CONTADORVUELTAS"));
				incidencia.setEstatusCRM(dataTableIncidencia.getString("ESTATUSCRM"));				
				incidencia.setFechaCreacion(dataTableIncidencia.getString("FECHACREACION"));
				incidencia.setFechaModificacion(dataTableIncidencia.getString("FECHAMODIFICACION"));
				if(dataTableIncidencia.getString("FLAGRESUELTO")!=null && dataTableIncidencia.getString("FLAGRESUELTO").compareToIgnoreCase("1")==0){
					incidencia.setFlagResuelto(true);
				}else{
					incidencia.setFlagResuelto(false);
				}
												
				incidencia.setIdCausa(dataTableIncidencia.getString("IDCAUSA"));
				incidencia.setIdMotivo(dataTableIncidencia.getString("IDMOTIVO"));
				incidencia.setMensajeRechazo1(dataTableIncidencia.getString("MSGRECHAZO1"));
				incidencia.setMensajeRechazo2(dataTableIncidencia.getString("MSGRECHAZO2"));
				incidenciaList.add( incidencia );		
			}
			data.setIncidenciaList(incidenciaList);	
			
			
			JCoTable dataTableOrganizacionCuentas = function.getExportParameterList().getTable("ET_ORGANIZACION_CUENTAS");
//			log.info("" + dataTableOrganizacionCuentas.toString());			
			ArrayList<OrganizacionCuentas_OutputData> organizacionCuentaList = new ArrayList<OrganizacionCuentas_OutputData>();
			for (int i = 0; i < dataTableOrganizacionCuentas.getNumRows(); i++, dataTableOrganizacionCuentas.nextRow()) {		
				OrganizacionCuentas_OutputData organizacionCuentas = new OrganizacionCuentas_OutputData();				
				organizacionCuentas.setBanco(dataTableOrganizacionCuentas.getString("NOMBREBANCO"));	
				organizacionCuentas.setClabe(dataTableOrganizacionCuentas.getString("CLABE"));	
				organizacionCuentas.setCuentaDispersadora(dataTableOrganizacionCuentas.getString("CUENTADISPERSORA"));	
				organizacionCuentas.setSecuencia(dataTableOrganizacionCuentas.getString("IDSECUENCIAL"));
				organizacionCuentas.setIdBanco(dataTableOrganizacionCuentas.getString("IDDEBANCO"));	
				organizacionCuentas.setNumeroCuenta(dataTableOrganizacionCuentas.getString("NUMERODECUENTA"));	
				organizacionCuentas.setTipoCuenta(dataTableOrganizacionCuentas.getString("TIPODECUENTA"));	
				organizacionCuentas.setNombreEmpresa(dataTableOrganizacionCuentas.getString("NOMBREEMPRESA"));						
				organizacionCuentaList.add( organizacionCuentas );		
			}
			data.setOrganizacionCuentaList(organizacionCuentaList);		
			
			
			
			JCoTable dataTableServicio = function.getExportParameterList().getTable("ET_OSERVICIO");
//			log.info("" + dataTableOrganizacionCuentas.toString());			
			ArrayList<Servicios_OutputData> servicioList = new ArrayList<Servicios_OutputData>();
			for (int i = 0; i < dataTableServicio.getNumRows(); i++, dataTableServicio.nextRow()) {		
				Servicios_OutputData servicio = new Servicios_OutputData();				
				servicio.setConcepto(dataTableServicio.getString("CONCEPTO"));	
				servicio.setEstatus(dataTableServicio.getString("ESTATUS"));	
				servicio.setFechaAprobacion(dataTableServicio.getString("FECHAAPROBACION"));
				servicio.setFechaCreacion(dataTableServicio.getString("FECHACREACION"));
				servicio.setFechaEmision(dataTableServicio.getString("FECHAEMISION"));
				servicio.setFechaVigencia(dataTableServicio.getString("FECHAVIGENCIA"));
				servicio.setIdCompetidor(dataTableServicio.getString("IDSAPCPMPETIDOR"));
				servicio.setImporteLiquidacion(dataTableServicio.getString("IMPORTELIQUIDACION"));
				servicio.setNombreCompetidor(dataTableServicio.getString("NOMBRECOMPETIDOR"));
				servicio.setNumeroCuenta(dataTableServicio.getString("NUMCUENTA"));
				servicio.setIdOrdenServicio(dataTableServicio.getString("ORDENSERVICIOID"));
				servicio.setReferenciaPago(dataTableServicio.getString("REFERENCIAPAGO"));
				servicio.setTipoPago(dataTableServicio.getString("TIPOPAGO"));
				try {
					servicio.setTipo( dataTableServicio.getString("TIPO"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				servicioList.add( servicio );		
			}
			data.setServicioList(servicioList);		
			
			try {
				JCoTable dataTableRecomendados = function.getExportParameterList().getTable("ET_OSERVICIO_R");
				ArrayList<Recomendados_OutputData> recomendadosList = new ArrayList<Recomendados_OutputData>();
				for (int i = 0; i < dataTableRecomendados.getNumRows(); i++, dataTableRecomendados.nextRow()) {		
					Recomendados_OutputData servicio = new Recomendados_OutputData();				
					servicio.setCanal(dataTableRecomendados.getString("CANAL"));	
					servicio.setEstatus(dataTableRecomendados.getString("ESTATUS"));	
					servicio.setEstatusDesc(dataTableRecomendados.getString("ESTATUS_DESC"));
					servicio.setOrdenServicioId( dataTableRecomendados.getString("ORDENSERVICIOID"));
					servicio.setTipoOperacion( dataTableRecomendados.getString("TIPOOPERACION"));
//				servicio.setChannelSource(dataTableRecomendados.getString(""));
					recomendadosList.add( servicio );		
				}
				data.setRecomendadosList(recomendadosList);	
			} catch (Exception e) {}
			
			JCoTable dataTableTracking = function.getExportParameterList().getTable("ET_TRACKING");
//			log.info("" + dataTableOrganizacionCuentas.toString());			
			 ArrayList<Tracking_OutputData> trackingList = new ArrayList<Tracking_OutputData>();
			for (int i = 0; i < dataTableTracking.getNumRows(); i++, dataTableTracking.nextRow()) {		
				Tracking_OutputData traking = new Tracking_OutputData();				
				traking.setEstatus(dataTableTracking.getString("SAPSTATUS"));
				traking.setHoraFinal(dataTableTracking.getString("ENDDTHOURID"));
				traking.setMinutoFinal(dataTableTracking.getString("ENDDTTIMEID"));
				traking.setHoraInicial(dataTableTracking.getString("BEGINDTHOURID"));
				traking.setMinutoInicial(dataTableTracking.getString("BEGINDTTIMEID"));				
				traking.setNumero(dataTableTracking.getString("NUMBER"));
				traking.setUser(dataTableTracking.getString("USER"));
				trackingList.add( traking );		
			}
			data.setTrackingList(trackingList);	
			

			try {
				// se coloca la extraccion de la tabla en un TRY para poder ejecutar en cualquier 
				// ambiente y evitar que truene para prod, ya que aun no esta el cambio liberado en.
				JCoTable dataTableInterlocutores = function.getExportParameterList().getTable("E_INTERLOCUTORES");
				ArrayList<Interlocutores_OutputData> interlocList = new ArrayList<Interlocutores_OutputData>();
				for (int i = 0; i < dataTableInterlocutores.getNumRows(); i++, dataTableInterlocutores.nextRow()) {		
					Interlocutores_OutputData interloc = new Interlocutores_OutputData();
					interloc.setInterlocFuncId ( dataTableInterlocutores.getString("ID_FUNC_INTER") );
					interloc.setInterlocFuncDesc( dataTableInterlocutores.getString("DESC_FUNC_INTER") );
					interloc.setInterlocBPId( dataTableInterlocutores.getString("ID_BP") );
					interloc.setInterlocNom1( dataTableInterlocutores.getString("NOMBRE1") );
					interloc.setInterlocNom2( dataTableInterlocutores.getString("NOMBRE2") );
					interloc.setInterlocApPat( dataTableInterlocutores.getString("APE_PAT") );
					interloc.setInterlocApMat( dataTableInterlocutores.getString("APE_MAT") );
					interloc.setInterlocEstat( dataTableInterlocutores.getString("ESTATUS") );
					interlocList.add( interloc );		
				}
				data.setInterlocutoresList(interlocList);
			} catch (Exception e) {
			}
			
			
			JCoStructure rootEstructura = function.getExportParameterList().getStructure("E_SOLICITUD");
			Solicitud_OutputData solicitud = new Solicitud_OutputData();
			solicitud.setApplication(rootEstructura.getString("APPLICATION"));  // 1
			solicitud.setApplicationAmt(rootEstructura.getString("APPLICATIONAMT"));
			solicitud.setApplicationTimeId(rootEstructura.getString("APPLICATIONDTTIMEID"));
			solicitud.setAppliedAmt(rootEstructura.getString("APPLIEDAMT"));
			solicitud.setApproveAmt(rootEstructura.getString("APPROVEDAMT"));
			solicitud.setBankReference(rootEstructura.getString("BANKREFERENCE"));
			solicitud.setCallCenterArrivalHourId(rootEstructura.getString("CALLCENTERARRIVALDTHOURID"));
			solicitud.setCallCenterArrivalTimeId(rootEstructura.getString("CALLCENTERARRIVALDTTIMEID"));
			solicitud.setChargeAmt(rootEstructura.getString("CHARGEDAMT"));
			solicitud.setCommissionAmt(rootEstructura.getString("COMMISSIONAMT")); // 10
			solicitud.setCurrency(rootEstructura.getString("CURRENCY"));
			solicitud.setDisbursementAmt(rootEstructura.getString("DISBURSEMENTAMT"));
			solicitud.setDisbursementClient(rootEstructura.getString("DISBURSEMENTCLIENT"));
			solicitud.setDisbursementTimeId(rootEstructura.getString("DISBURSEMENTDTTIMEID"));
			solicitud.setDisbursementHourId(rootEstructura.getString("DISBURSEMNETDTHOURID"));
			solicitud.setDiscountAmt(rootEstructura.getString("DISCOUNTAMT"));
			solicitud.setInsuranceAmt(rootEstructura.getString("INSURANCEAMT"));
			solicitud.setOriginationApplicationBnr(rootEstructura.getString("ORIGINATIONAPPLICATIONNBR"));
			solicitud.setOriginationChannelImn(rootEstructura.getString("ORIGINATIONCHANNELINM"));
			solicitud.setOriginationDocumentNbr(rootEstructura.getString("ORIGINATIONDOCUMENTNBR")); //20
			solicitud.setOriginationOperationNbr(rootEstructura.getString("ORIGINATIONOPERATIONNBR"));
			solicitud.setOwnerId(rootEstructura.getString("OWNERID"));
			solicitud.setPaymentCapacityAmt(rootEstructura.getString("PAYMENTCAPACITYAMT"));
			solicitud.setPaymentFrecuency(rootEstructura.getString("PAYMENTFRECUENCY"));
			solicitud.setPaymentsNbr(rootEstructura.getString("PAYMENTSNBR"));
			solicitud.setPrincipalDisbCommissionAmt(rootEstructura.getString("PRINCIPALDISBCOMMISSIONSAMT"));
			solicitud.setPurchasedHourId(rootEstructura.getString("PURCHASEDTHOURID"));
			solicitud.setPurchasedTimeId(rootEstructura.getString("PURCHASEDTTIMEID"));
			solicitud.setQualityCallHourId(rootEstructura.getString("QUALITYCALLDTHOURID"));
			solicitud.setQualityCallTimeId(rootEstructura.getString("QUALITYCALLDTTIMEID")); //30			
			solicitud.setQualityResponse(rootEstructura.getString("QUALITYRESPONSE"));
			solicitud.setRegisterHourId(rootEstructura.getString("REGISTERDTHOURID"));
			solicitud.setRegisterTimeId(rootEstructura.getString("REGISTERDTTIMEID"));
			solicitud.setRejectionsNbr(rootEstructura.getString("REJECTIONSNBR"));
			solicitud.setReprocessingNbr(rootEstructura.getString("REPROCESSINGNBR"));
			solicitud.setResolvedDtHourId(rootEstructura.getString("RESOLVEDDTHOURID"));
			solicitud.setResolvedDtTimeId(rootEstructura.getString("RESOLVEDDTTIMEID"));
			solicitud.setAnalystId(rootEstructura.getString("SAPANALYSTID"));
			solicitud.setApplicationId(rootEstructura.getString("SAPAPPLICATIONID"));
			solicitud.setBankId(rootEstructura.getString("SAPBANKID")); //40
			solicitud.setBranchId(rootEstructura.getString("SAPBRANCHID"));
			solicitud.setCapturistaId(rootEstructura.getString("SAPCAPTURISTAID"));
			solicitud.setClientId(rootEstructura.getString("SAPCLIENTID"));
			solicitud.setDependenciaId(rootEstructura.getString("SAPDEPENDENCIAID"));
			solicitud.setDisbursementChannelId(rootEstructura.getString("SAPDISBURSEMENTCHANNELID"));
			solicitud.setDistributorId(rootEstructura.getString("SAPDISTRIBUTORID"));
			solicitud.setProductId(rootEstructura.getString("SAPPRODUCTOID"));
			solicitud.setProgramId(rootEstructura.getString("SAPPROGRAMID"));
			solicitud.setPromoterId(rootEstructura.getString("SAPPROMOTERID"));
			solicitud.setRamoId(rootEstructura.getString("SAPRAMOID")); //50
			solicitud.setRegionId(rootEstructura.getString("SAPREGIONID"));
			solicitud.setStatusId(rootEstructura.getString("SAPSTATUSID"));
			solicitud.setSubStatusId(rootEstructura.getString("SAPSUBSTATUSID"));
			solicitud.setAuthorizerId(rootEstructura.getString("SAPAUTHORIZERID"));
			solicitud.setControlDeskId(rootEstructura.getString("SAPCONTROLDESKID"));
			solicitud.setSelfServiceCommissionAmt(rootEstructura.getString("SELFSERVICECOMMISSIONSAMT"));
			solicitud.setSpecialPromotion(rootEstructura.getString("SPECIALPROMOTION"));
			solicitud.setSpecialPromotionAmt(rootEstructura.getString("SPECIALPROMOTIONAMT"));
			solicitud.setStatusFinalDtHourId(rootEstructura.getString("STATUSFINALDTHOURID"));
			solicitud.setStatusFinalDtTimeId(rootEstructura.getString("STATUSFINALDTTIMEID")); //60
			solicitud.setTaxDisbcommissionAmt(rootEstructura.getString("TAXDISBCOMMISSIONAMT"));
			solicitud.setWithHoldingAmt(rootEstructura.getString("WITHOLDINGAMT"));
			solicitud.setWithHoldingCompetitor(rootEstructura.getString("WITHOLDINGCOMPETITOR"));
			solicitud.setWithHoldingIssste(rootEstructura.getString("WITHOLDINGISSSTE"));
			solicitud.setWithHoldingInterCompanyAmt(rootEstructura.getString("WITHOLDINGINTERCOMPANYAMT"));
			try {
				// se colocan estos campos que aun no estan en prod para podere ejecutar el jco en cualquier ambiente.
				solicitud.setStatusDesc(rootEstructura.getString("SAPSTATUSDESC"));
				solicitud.setDocumentType(rootEstructura.getString("SAPPROCESSTYPE"));
				solicitud.setOportunitySF(rootEstructura.getString("OPPORTUNITY_SF"));
				solicitud.setCanalOrigenDesc(rootEstructura.getString("CANAL_ORIGEN"));
				solicitud.setCanalOrigenId(rootEstructura.getString("DESC_CANAL"));
				solicitud.setBloqueoPagonLinea(rootEstructura.getString("BLOQUEARPAGODIS"));
			} catch (Exception e) {
				// TODO: handle exception
			}
								
			data.setSolicitud(solicitud);
			
			
			JCoStructure rootCliente = function.getExportParameterList().getStructure("E_CLIENTE");
			SolicitudCliente_OutputData solicitudCliente = new SolicitudCliente_OutputData();
			solicitudCliente.setCodigoPostal(rootCliente.getString("CODIGOPOSTAL"));
			solicitudCliente.setFirstNm(rootCliente.getString("FIRSTNM"));
			solicitudCliente.setMaternalNm(rootCliente.getString("MATERNALNM"));
			solicitudCliente.setMunicipality(rootCliente.getString("MUNICIPALITY"));
			solicitudCliente.setOrganizationBorrowerNbr(rootCliente.getString("ORIGINATIONBORROWERNBR"));
			solicitudCliente.setPaternalNM(rootCliente.getString("PATERNALNM"));
			solicitudCliente.setRfc(rootCliente.getString("RFC"));
			solicitudCliente.setClientId(rootCliente.getString("SAPCLIENTID"));
			solicitudCliente.setSecondNM(rootCliente.getString("SECONDNM"));
			solicitudCliente.setStateId(rootCliente.getString("STATEID"));
			solicitudCliente.setTipoCliente(rootCliente.getString("TIPOCLIENTE"));
			solicitudCliente.setClabe(rootCliente.getString("CLABE"));
			data.setSolicitudCliente(solicitudCliente);
			
			
			JCoStructure rootPromotor = function.getExportParameterList().getStructure("E_PROMOTOR");
			Promotor_OutputData promotor = new Promotor_OutputData();
			promotor.setEmployeeCd(rootPromotor.getString("EMPLOYEECD"));
			promotor.setEmployeeNM(rootPromotor.getString("EMPLOYEENM"));
			promotor.setEmployeeRole(rootPromotor.getString("EMPLOYEEROLE"));	
			promotor.setEmployeeId(rootPromotor.getString("SAPEMPLOYEEID"));
			try {
				promotor.setBloquearPagoLinea(rootPromotor.getString("BLOQUEARPAGOLIN"));
				promotor.setIdTipoPromotor(rootPromotor.getString("IDTIPOPROMOTOR") );
				promotor.setTipoPromotor(rootPromotor.getString("TIPOPROMOTOR"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			data.setPromotor(promotor);			
			
			JCoStructure SolicitudOrg = function.getExportParameterList().getStructure("E_ORGANIZACION");
			SolicitudOrganizacion_OutputData solicitudOrganizacion = new SolicitudOrganizacion_OutputData();
			solicitudOrganizacion.setCtaEmpresarial(SolicitudOrg.getString("CTAEMPRESARIAL"));
			solicitudOrganizacion.setOwnerDesc(SolicitudOrg.getString("OWNERDESC"));
			solicitudOrganizacion.setOwnerId(SolicitudOrg.getString("OWNERID"));
			solicitudOrganizacion.setOwnerSigla(SolicitudOrg.getString("OWNERSIGLA"));
			solicitudOrganizacion.setBranchDesc(SolicitudOrg.getString("SAPBRANCHDESC"));
			solicitudOrganizacion.setBranchId(SolicitudOrg.getString("SAPBRANCHID"));
			solicitudOrganizacion.setBranchSigla(SolicitudOrg.getString("SAPBRANCHSIGLA"));
			solicitudOrganizacion.setDistributorDesc(SolicitudOrg.getString("SAPDISTRIBUTORDESC"));
			solicitudOrganizacion.setDistributorId(SolicitudOrg.getString("SAPDISTRIBUTORID"));
			solicitudOrganizacion.setDistributorSigla(SolicitudOrg.getString("SAPDISTRIBUTORSIGLA"));
			solicitudOrganizacion.setOwnerRfc(SolicitudOrg.getString("OWNERRFC"));
			try {
				solicitudOrganizacion.setDispersionH2h(SolicitudOrg.getString("DISPERSION_H2H"));
				solicitudOrganizacion.setBranchidBP( SolicitudOrg.getString("SAPBRANCHIDBP"));
				solicitudOrganizacion.setBranchEntFederativa( SolicitudOrg.getString("SAPBRANCH_STATE_ID"));
			} catch (Exception e) {
			}
			data.setSolicitudOrganizacion(solicitudOrganizacion);
			
			JCoStructure convenioStru = function.getExportParameterList().getStructure("E_CONVENIO");
			Convenio_OutputData convenio = new Convenio_OutputData();
			convenio.setCategoria(convenioStru.getString("CONVENIOCATEGORIA"));
			convenio.setDescripcion(convenioStru.getString("CONVENIODESC"));
			convenio.setId(convenioStru.getString("CONVENIOID"));
			
			JCoStructure bundleStru = convenioStru.getStructure("BUNDLE");
			Bundle_OutputData bundle = new Bundle_OutputData();
			bundle.setCategoria(bundleStru.getString("BUNDLECATEGORIA"));
			bundle.setDescripcion(bundleStru.getString("BUNDLEDESC"));
			bundle.setId(bundleStru.getString("BUNDLEID"));
			
			JCoStructure productoStru = bundleStru.getStructure("PRODUCTO");
			Producto_OutputData producto = new Producto_OutputData();
			producto.setCategoria(productoStru.getString("PRODUCTOCATEGORIA"));
			producto.setComisAperImp(productoStru.getString("PRODUCTOCOMISAPERIMP"));
			producto.setComisAperCiento(productoStru.getString("PRODUCTOCOMISAPERTCIENTO"));
			producto.setDescripcion(productoStru.getString("PRODUCTODESC"));
			producto.setId(productoStru.getString("PRODUCTOID"));
			producto.setMontoMax(productoStru.getString("PRODUCTOMTOMAX"));
			producto.setMontoMin(productoStru.getString("PRODUCTOMTOMIN"));
			producto.setFlagAutenticaCc( productoStru.getString("FLAG_AUTENTICA_CC"));
			bundle.setProducto(producto);
			convenio.setBundle(bundle);			
			data.setConvenio(convenio);
			
			JCoStructure atrOriginacionStru = function.getExportParameterList().getStructure("E_ATR_ORIGINACION");
			AtributosOriginacion_OutputData atributosOriginacion = new AtributosOriginacion_OutputData();
			atributosOriginacion.setCnca(atrOriginacionStru.getString("CNCA"));
			atributosOriginacion.setCredNvo(atrOriginacionStru.getString("CREDNVO"));
			atributosOriginacion.setInterCompania(atrOriginacionStru.getString("INTERCOMPANIA"));
			atributosOriginacion.setLcom(atrOriginacionStru.getString("LCOM"));
			atributosOriginacion.setNumDisposicion(atrOriginacionStru.getString("NUMDISPOSICION"));
			atributosOriginacion.setSegundaDisp(atrOriginacionStru.getString("SEGUNDADISP"));			
			data.setAtributosOriginacion(atributosOriginacion);
			
			/*
			 * Mapear
			 * TODO:
			 * 
			 * E_CONDICIONES_PRECIO
			 */
			
			JCoStructure precioStru = function.getExportParameterList().getStructure("E_CONDICIONES_PRECIO");
			CondicionesPrecio_OutputData precio = new CondicionesPrecio_OutputData();
			precio.setAnticipoConaviPorcent(precioStru.getString("ANTICIPOCONAVIPORCENT"));
			precio.setBonifAutoServicio(precioStru.getString("BONIFAUTOSERVICIO"));
			precio.setCalculoCat(precioStru.getString("CALCULOCAT"));
			precio.setCapacidadBruta(precioStru.getString("CAPACIDADBRUTA"));
			precio.setCapacidadPago(precioStru.getString("CAPACIDADDEPAGO"));
			precio.setCapacidadPagoPorcent(precioStru.getString("CAPACIDADDEPAGOPORCENT"));
			precio.setCapital(precioStru.getString("CAPITAL"));
			precio.setCargoAperturaFijo(precioStru.getString("CARGOAPERTURAFIJO"));
			precio.setCargoAperturaPorcent(precioStru.getString("CARGOAPERTURAPORCENT"));
			precio.setCesionCodeka(precioStru.getString("CESIONCODEKA"));
			precio.setCnca(precioStru.getString("CNCA"));
			precio.setComisionDiferida(precioStru.getString("COMISIONDIFERIDA"));
			precio.setCreditoNetoAcum(precioStru.getString("CREDITONETOACUM"));
			precio.setCreditoSolicitado(precioStru.getString("CREDITOSOLICITADO"));
			precio.setDescuentoSeguro(precioStru.getString("DCTOPORSEGURO"));
			precio.setDescuentoNomina(precioStru.getString("DESCUENTOENNOMINA"));
			precio.setDispCompetidores(precioStru.getString("DISPCOMPETIDORES"));
			precio.setFeeServicioCodeka(precioStru.getString("FEESERVICIOCODEKA"));
			precio.setFrecuenciaPago(precioStru.getString("FRECUENCIADEPAGO"));
			precio.setGastosNotariales(precioStru.getString("GASTOSNOTARIALES"));
			precio.setInteres(precioStru.getString("INTERES"));
			precio.setIva(precioStru.getString("IVA"));
			precio.setIvaGastoAdmin2(precioStru.getString("IVADEGASTOSADMIN2"));
			precio.setIvaGastoAdmin3(precioStru.getString("IVADEGASTOSADMIN3"));
			precio.setIvaInteres(precioStru.getString("IVAINTERES"));
			precio.setLiqInterCompanias(precioStru.getString("LIQINTERCOMPANIAS"));
			precio.setPorcenTasaCodeka(precioStru.getString("PORCENTASACODEKA"));
			precio.setPorcentCesionCodeka(precioStru.getString("PORCENTCESIONCODEKA"));
			precio.setPorcentFeeServCodeka(precioStru.getString("PORCENTFEESERVCODEKA"));
			precio.setPorcentUtilizadoCP(precioStru.getString("PORCENTUTILIZADOENCP"));
			precio.setPromocionEfectivo(precioStru.getString("PROMOCIONEFECTIVO"));
			precio.setSolvencia(precioStru.getString("SOLVENCIA"));
			precio.setSubsidioConaviPorcent(precioStru.getString("SUBSIDIOCONAVIPORCENT"));
			precio.setTasa(precioStru.getString("TASA"));
			precio.setSeguroSaldoDeudor( precioStru.getString("SEGURODEUDOR") );
			
			data.setCondicionesPrecioOutputData(precio);
			
			//Seguro Deudor
			JCoTable dataTableSSD = function.getExportParameterList().getTable("ET_SEGURO_DEUDOR");
			ArrayList<SeguroDeudor_OutputData> seguroDeudorList = new ArrayList<SeguroDeudor_OutputData>();
			for (int i = 0; i < dataTableSSD.getNumRows(); i++, dataTableSSD.nextRow()) {		
				SeguroDeudor_OutputData ssd = new SeguroDeudor_OutputData();
				ssd.setOrdenServicioId( StringUtils.trimToEmpty( dataTableSSD.getString("ID_OPERACION") ) );
				ssd.setSeguroTercero( StringUtils.trimToEmpty( dataTableSSD.getString("SEGURO_TERCERO") ).equals("X") ? true : false );
				ssd.setBpSeguro( StringUtils.trimToEmpty( dataTableSSD.getString("PARTNER") ) );
				ssd.setRazonSocialSeguro( StringUtils.trimToEmpty( dataTableSSD.getString("RAZON_SOCIAL") ) );
				ssd.setRfcSeguro( StringUtils.trimToEmpty( dataTableSSD.getString("RFC_PARTNER") ) );
				ssd.setValorUnitario( dataTableSSD.getDouble("VALOR_UNITARIO") );
				ssd.setVigencia( StringUtils.trimToEmpty( dataTableSSD.getString("VIGENCIA") ) );
				ssd.setBancoId( StringUtils.trimToEmpty( dataTableSSD.getString("ID_BANCO") ) );
				ssd.setBancoDesc( StringUtils.trimToEmpty( dataTableSSD.getString("NOMBRE_BANCO") ) );
				ssd.setCuenta( StringUtils.trimToEmpty( dataTableSSD.getString("CUENTA") ) );
				ssd.setClabe( StringUtils.trimToEmpty( dataTableSSD.getString("CLABE") ) );
				ssd.setEstatusId( StringUtils.trimToEmpty( dataTableSSD.getString("ID_ESTATUS") ) );
				ssd.setEstatusDesc( StringUtils.trimToEmpty( dataTableSSD.getString("ESTATUS") ) );
				ssd.setFechaUltEstatus( StringUtils.trimToEmpty( dataTableSSD.getString("FECHA_ULTIMO_STST") ) );
				ssd.setMontoSeguroDeudor( dataTableSSD.getDouble("SEG_SAL_DEUDOR") );
				
				seguroDeudorList.add( ssd );		
			}
			data.setSeguroDeudorList( seguroDeudorList );
			
			//Otras Retenciones
			JCoTable dataTableORT = function.getExportParameterList().getTable("ET_OTRAS_RETENCIONES");
			ArrayList<OtraRetencion_OutputData> otroRetencionList = new ArrayList<OtraRetencion_OutputData>();
			for (int i = 0; i < dataTableORT.getNumRows(); i++, dataTableORT.nextRow()) {		
				OtraRetencion_OutputData ort = new OtraRetencion_OutputData();
				ort.setIdOtraRetencion( StringUtils.trimToEmpty( dataTableORT.getString("ZID_ORDSER") ) );
				ort.setConcepto( StringUtils.trimToEmpty( dataTableORT.getString("ZCONCEPTO") ) );
				ort.setNombreBeneficiario( StringUtils.trimToEmpty( dataTableORT.getString("ZBENEFICIARIO") ) );
				ort.setRfcBeneficiario( StringUtils.trimToEmpty( dataTableORT.getString("ZRFC_BENEF") ) );
				ort.setCpBeneficiario( StringUtils.trimToEmpty( dataTableORT.getString("ZCP_BENEF") ) );
				ort.setBancoId( StringUtils.trimToEmpty( dataTableORT.getString("ZCLAVE_BANCO") ) );
				ort.setBancoDesc( StringUtils.trimToEmpty( dataTableORT.getString("ZBANCO") ) );
				ort.setClabe( StringUtils.trimToEmpty( dataTableORT.getString("ZCLABE") ) );
				ort.setReferencia( StringUtils.trimToEmpty( dataTableORT.getString("ZREFERENCIA") ) );
				ort.setImporteRetener( dataTableORT.getDouble("ZIMPORTE_RET") );
				ort.setPorcentajeRetener( dataTableORT.getDouble("ZPORC_RET") );
				ort.setEstatusId( StringUtils.trimToEmpty( dataTableORT.getString("ZESTATUS_ID") ) );
				ort.setEstatusDesc( StringUtils.trimToEmpty( dataTableORT.getString("ZESTATUS_DESC") ) );
				ort.setFechaUltEstatus( dataTableORT.getDate("ZFECHAULTSTAT") );
				otroRetencionList.add( ort );		
			}
			data.setOtrasRetencionesList( otroRetencionList );
			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {

		}

		return( data );
	}
	
}
