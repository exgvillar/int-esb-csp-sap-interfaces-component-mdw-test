/**
 * 
 */
package com.consupago.sap.interfaces.proxy.commons.utils;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.common.utils.ZGET_DISTRIBUIDOR_OutputData;
import com.consupago.sap.interfaces.proxy.common.utils.ZGET_DISTRIBUIDOR_ProxyImpl;
import com.consupago.sap.interfaces.proxy.common.utils.ZRFC_AUTORIZACION_ESPECIAL_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZRFC_AUTORIZACION_ESPECIAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_AUTORIZACION_ESPECIAL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_AUTORIZACION_ESPECIAL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_AUTORIZACION_ESPECIAL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_AUTORIZACION_ESPECIAL_ProxyImpl proxy = new ZRFC_AUTORIZACION_ESPECIAL_ProxyImpl();
        
        
        String[] arrInfo = 
        {"0050465035*0143360032", "0050465206*0143360032", "0050465683*0143360032", "0050465704*0143360032", "0050464957*0143360032", "0050465136*0143360032", "0050465237*0143360032", "0050465374*0143360032", "0050465451*0143360032", "0050465508*0143360032", "0050465525*0143360032", "0050465533*0143360032", "0050465559*0143360032", "0050465578*0143360032", "0050465579*0143360032", "0050465596*0143360032", "0050465641*0143360032", "0050465661*0143360032", "0050465675*0143360032", "0050465679*0143360032", "0050465757*0143360032", "0050465759*0143360032", "0050465775*0143360032", "0050465815*0143360032", "0050465827*0143360032", "0050465833*0143360032", "0050465840*0143360032", "0050465993*0143360032", "0050465997*0143360032", "0050465550*0155473098", "0050465613*0155473098", "0050465702*0155473098", "0050465719*0155473098", "0050466028*0155473098", "0050465514*0155473098", "0050464941*0155473098", "0050465515*0155473098", "0050465767*0155473098", "0050465766*0155473098", "0050465795*0155473098", "0050465841*0155473098", "0050465918*0149670521"};
//        	"0050405835*012|BBVA BANCOMER|000504058355|000000000000|Ventanilla#0050405893*012|BBVA BANCOMER|000504058934|000000000000|Ventanilla#0050406018*012|BBVA BANCOMER|000504060187|000000000000|Ventanilla#0050406214*012|BBVA BANCOMER|000504062142|000000000000|Ventanilla#0050406122*012|BBVA BANCOMER|000504061227|000000000000|Ventanilla#0050406114*012|BBVA BANCOMER|000504061144|000000000000|Ventanilla#0050406078*012|BBVA BANCOMER|000504060781|000000000000|Ventanilla#0050405970*012|BBVA BANCOMER|000504059700|000000000000|Ventanilla#0050405940*012|BBVA BANCOMER|000504059403|000000000000|Ventanilla#0050405842*012|BBVA BANCOMER|000504058421|000000000000|Ventanilla#0050405677*012|BBVA BANCOMER|000504056771|000000000000|Ventanilla#0050405536*012|BBVA BANCOMER|000504055369|000000000000|Ventanilla#0050405036*012|BBVA BANCOMER|000504050360|000000000000|Ventanilla#0050404925*012|BBVA BANCOMER|000504049255|000000000000|Ventanilla#0050404795*012|BBVA BANCOMER|000504047952|000000000000|Ventanilla#0050404645*012|BBVA BANCOMER|000504046459|000000000000|Ventanilla#0050404329*012|BBVA BANCOMER|000504043290|000000000000|Ventanilla#0050403867*012|BBVA BANCOMER|000504038670|000000000000|Ventanilla#0050407276*012|BBVA BANCOMER|000504072760|000000000000|Ventanilla#0050406206*012|BBVA BANCOMER|000504062068|000000000000|Ventanilla#0050406203*012|BBVA BANCOMER|000504062035|000000000000|Ventanilla#0050406202*012|BBVA BANCOMER|000504062027|000000000000|Ventanilla#0050406196*012|BBVA BANCOMER|000504061961|000000000000|Ventanilla#0050406192*012|BBVA BANCOMER|000504061920|000000000000|Ventanilla#0050406179*012|BBVA BANCOMER|000504061797|000000000000|Ventanilla#0050406155*012|BBVA BANCOMER|000504061557|000000000000|Ventanilla#0050406138*012|BBVA BANCOMER|000504061383|000000000000|Ventanilla"
//        	"0050384950*186/MÚLTIPLE2_CSB/FEB15/V1"
//        	.split("\\#");

        Long inicio = System.currentTimeMillis();
        
        // tableParams - record1
//        ArrayList<ProxyInputParameter> paramTabl = new ArrayList<ProxyInputParameter>();

        for (String idSolic : arrInfo) {
        	
//        	ZGET_DISTRIBUIDOR_OutputData datosSol = this.ObtenInfoSolic(destination, idSolic);
        	
        	ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        	inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        	inputParams.setRecordParam( new ArrayList<Object>() );
        	ProxyInputParameter input = new ProxyInputParameter();

        	String[] infor = idSolic.trim().split("\\*") ;
            ArrayList<ProxyInputParameter> paramTabl = new ArrayList<ProxyInputParameter>();

            String textoDato = infor[1];
//            String textoDato = infor[1] +"||" + this.getConvenioSIT(datosSol.getZbpEmpresa()) + "|"+ datosSol.getzEmpresa();

            // general Params
             input = new ProxyInputParameter();
            input.setKey("SOLICITUD");
            input.setValue( infor[0] );
            inputParams.getGeneralParam().add( input );
            
            
            // tableParams - record1
            ProxyInputParameter inputRecord1 = new ProxyInputParameter();

            inputRecord1 = new ProxyInputParameter();
            inputRecord1.setKey("ZID_TEXTO");
            inputRecord1.setValue( "ZS09" ); //  cuenta dispersora...
//            inputRecord1.setValue( "ZS01" ); // Datos de cobro
//            inputRecord1.setValue( "ZT07" ); // Datos de vesion
            
            paramTabl.add( inputRecord1 );
            
            inputRecord1 = new ProxyInputParameter();
            inputRecord1.setKey("ZTEXTO");
            inputRecord1.setValue( textoDato );
            paramTabl.add( inputRecord1 );
            inputParams.getRecordParam().add( paramTabl );

            ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

        }
        
        
	}
	
	public ZGET_DISTRIBUIDOR_OutputData ObtenInfoSolic(JCoDestination destination, String idSolic) throws Exception{
        ZGET_DISTRIBUIDOR_ProxyImpl proxy = new ZGET_DISTRIBUIDOR_ProxyImpl();
        String tipoDoc = "ZCSP";
        
        Long inicio = System.currentTimeMillis();

        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue(idSolic );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( tipoDoc );
        inputParams.add( input );
        ArrayList<ZGET_DISTRIBUIDOR_OutputData> arrSalida = proxy.executeRemoteFunction(destination, inputParams );
        ZGET_DISTRIBUIDOR_OutputData salida = arrSalida.get(0);
        return salida;
	}
	
	private String getConvenioSIT(String idEmpresa){
		HashMap<String, String> hshConv = new HashMap<String, String>();
		hshConv.put("0017000459","1143840");
		hshConv.put("0017000012","1154907");
		hshConv.put("0017001478","1262181");
		hshConv.put("0017000013","1154850");
		hshConv.put("0017000011","1156160");
		hshConv.put("0017000461","1156314");
		hshConv.put("0017000417","1155946");
		hshConv.put("0017000010","1187163");
		return hshConv.get(idEmpresa);
	}

}
