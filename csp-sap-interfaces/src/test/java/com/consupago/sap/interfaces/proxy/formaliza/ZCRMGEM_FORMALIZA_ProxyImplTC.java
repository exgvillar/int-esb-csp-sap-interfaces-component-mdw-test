/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMGEM_FORMALIZA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMGEM_FORMALIZA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMGEM_FORMALIZA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMGEM_FORMALIZA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMGEM_FORMALIZA_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	

		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMGEM_FORMALIZA_ProxyImpl proxy = new ZCRMGEM_FORMALIZA_ProxyImpl();

        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
        ArrayList<String> arrSolic = new ArrayList<String>();

        arrSolic.add("0050453447");
        arrSolic.add("0050453458");
        arrSolic.add("0050452681");
        arrSolic.add("0050452682");
        arrSolic.add("0050452714");
        arrSolic.add("0050452716");
        arrSolic.add("0050452719");
        arrSolic.add("0050452727");
        arrSolic.add("0050452728");
        arrSolic.add("0050452731");
        arrSolic.add("0050452732");
        arrSolic.add("0050452733");
        arrSolic.add("0050452735");
        arrSolic.add("0050452737");
        arrSolic.add("0050452738");
        arrSolic.add("0050452742");
        arrSolic.add("0050452745");
        arrSolic.add("0050452750");
        arrSolic.add("0050452753");
        arrSolic.add("0050452759");
        arrSolic.add("0050452763");
        arrSolic.add("0050452764");
        arrSolic.add("0050452773");
        arrSolic.add("0050452776");
        arrSolic.add("0050452800");
        arrSolic.add("0050452815");
        arrSolic.add("0050452816");
        arrSolic.add("0050452818");
        arrSolic.add("0050452835");
        arrSolic.add("0050452840");
        arrSolic.add("0050452841");
        arrSolic.add("0050452842");
        arrSolic.add("0050452844");
        arrSolic.add("0050452846");
        arrSolic.add("0050452847");
        arrSolic.add("0050452849");
        arrSolic.add("0050452850");
        arrSolic.add("0050452852");
        arrSolic.add("0050452853");
        arrSolic.add("0050452856");
        arrSolic.add("0050452857");
        arrSolic.add("0050452866");
        arrSolic.add("0050452874");
        arrSolic.add("0050452891");
        arrSolic.add("0050452893");
        arrSolic.add("0050452895");
        arrSolic.add("0050452902");
        arrSolic.add("0050452933");
        arrSolic.add("0050452954");
        arrSolic.add("0050452966");
        arrSolic.add("0050452968");
        arrSolic.add("0050452977");
        arrSolic.add("0050452984");
        arrSolic.add("0050452992");
        arrSolic.add("0050452997");
        arrSolic.add("0050452998");
        arrSolic.add("0050452999");
        arrSolic.add("0050453000");
        arrSolic.add("0050453010");
        arrSolic.add("0050453013");
        arrSolic.add("0050453014");
        arrSolic.add("0050453015");
        arrSolic.add("0050453016");
        arrSolic.add("0050453018");
        arrSolic.add("0050453020");
        arrSolic.add("0050453022");
        arrSolic.add("0050453023");
        arrSolic.add("0050453024");
        arrSolic.add("0050453027");
        arrSolic.add("0050453030");
        arrSolic.add("0050453031");
        arrSolic.add("0050453032");
        arrSolic.add("0050453034");
        arrSolic.add("0050453035");
        arrSolic.add("0050453036");
        arrSolic.add("0050453037");
        arrSolic.add("0050453038");
        arrSolic.add("0050453039");
        arrSolic.add("0050453040");
        arrSolic.add("0050453041");
        arrSolic.add("0050453042");
        arrSolic.add("0050453043");
        arrSolic.add("0050453044");
        arrSolic.add("0050453046");
        arrSolic.add("0050453047");
        arrSolic.add("0050453048");
        arrSolic.add("0050453049");
        arrSolic.add("0050453050");
        arrSolic.add("0050453052");
        arrSolic.add("0050453053");
        arrSolic.add("0050453054");
        arrSolic.add("0050453057");
        arrSolic.add("0050453058");
        arrSolic.add("0050453060");
        arrSolic.add("0050453062");
        arrSolic.add("0050453066");
        arrSolic.add("0050453067");
        arrSolic.add("0050453075");
        arrSolic.add("0050453080");
        arrSolic.add("0050453081");
        arrSolic.add("0050453082");
        arrSolic.add("0050453083");
        arrSolic.add("0050453084");
        arrSolic.add("0050453085");
        arrSolic.add("0050453087");
        arrSolic.add("0050453088");
        arrSolic.add("0050453089");
        arrSolic.add("0050453090");
        arrSolic.add("0050453091");
        arrSolic.add("0050453092");
        arrSolic.add("0050453093");
        arrSolic.add("0050453101");
        arrSolic.add("0050453102");
        arrSolic.add("0050453103");
        arrSolic.add("0050453106");
        arrSolic.add("0050453117");
        arrSolic.add("0050453129");
        arrSolic.add("0050453132");
        arrSolic.add("0050453134");
        arrSolic.add("0050453135");
        arrSolic.add("0050453139");
        arrSolic.add("0050453140");
        arrSolic.add("0050453149");
        arrSolic.add("0050453151");
        arrSolic.add("0050453152");
        arrSolic.add("0050453154");
        arrSolic.add("0050453153");
        arrSolic.add("0050453155");
        arrSolic.add("0050453157");
        arrSolic.add("0050453158");
        arrSolic.add("0050453159");
        arrSolic.add("0050453160");
        arrSolic.add("0050453162");
        arrSolic.add("0050453163");
        arrSolic.add("0050453166");
        arrSolic.add("0050453169");
        arrSolic.add("0050453170");
        arrSolic.add("0050453171");
        arrSolic.add("0050453173");
        arrSolic.add("0050453174");
        arrSolic.add("0050453176");
        arrSolic.add("0050453177");
        arrSolic.add("0050453178");
        arrSolic.add("0050453180");
        arrSolic.add("0050453182");
        arrSolic.add("0050453186");
        arrSolic.add("0050453188");
        arrSolic.add("0050453189");
        arrSolic.add("0050453190");
        arrSolic.add("0050453191");
        arrSolic.add("0050453192");
        arrSolic.add("0050453193");
        arrSolic.add("0050453198");
        arrSolic.add("0050453200");
        arrSolic.add("0050453202");
        arrSolic.add("0050453204");
        arrSolic.add("0050453206");
        arrSolic.add("0050453207");
        arrSolic.add("0050453210");
        arrSolic.add("0050453211");
        arrSolic.add("0050453212");
        arrSolic.add("0050453222");
        arrSolic.add("0050453225");
        arrSolic.add("0050453226");
        arrSolic.add("0050453231");
        arrSolic.add("0050453236");
        arrSolic.add("0050453238");
        arrSolic.add("0050453240");
        arrSolic.add("0050453242");
        arrSolic.add("0050453245");
        arrSolic.add("0050453248");
        arrSolic.add("0050453251");
        arrSolic.add("0050453254");
        arrSolic.add("0050453258");
        arrSolic.add("0050453260");
        arrSolic.add("0050453261");
        arrSolic.add("0050453262");
        arrSolic.add("0050453263");
        arrSolic.add("0050453264");
        arrSolic.add("0050453266");
        arrSolic.add("0050453267");
        arrSolic.add("0050453268");
        arrSolic.add("0050453269");
        arrSolic.add("0050453271");
        arrSolic.add("0050453272");
        arrSolic.add("0050453276");
        arrSolic.add("0050453277");
        arrSolic.add("0050453279");
        arrSolic.add("0050453288");
        arrSolic.add("0050453294");
        arrSolic.add("0050453298");
        arrSolic.add("0050453300");
        arrSolic.add("0050453327");
        arrSolic.add("0050453335");
        arrSolic.add("0050453343");
        arrSolic.add("0050453347");
        arrSolic.add("0050453348");
        arrSolic.add("0050453349");
        arrSolic.add("0050453350");
        arrSolic.add("0050453351");
        arrSolic.add("0050453352");
        arrSolic.add("0050453353");
        arrSolic.add("0050453354");
        arrSolic.add("0050453355");
        arrSolic.add("0050453356");
        arrSolic.add("0050453357");
        arrSolic.add("0050453358");
        arrSolic.add("0050453359");
        arrSolic.add("0050453363");
        arrSolic.add("0050453364");
        arrSolic.add("0050453366");
        arrSolic.add("0050453367");
        arrSolic.add("0050453369");
        arrSolic.add("0050453370");
        arrSolic.add("0050453371");
        arrSolic.add("0050453372");
        arrSolic.add("0050453374");
        arrSolic.add("0050453377");
        arrSolic.add("0050453379");
        arrSolic.add("0050453380");
        arrSolic.add("0050453381");
        arrSolic.add("0050453386");
        arrSolic.add("0050453388");
        arrSolic.add("0050453390");
        arrSolic.add("0050453392");
        arrSolic.add("0050453398");
        arrSolic.add("0050453400");
        arrSolic.add("0050453404");
        arrSolic.add("0050453411");
        arrSolic.add("0050453412");
        arrSolic.add("0050453413");


        log.info("tamano Arreglo::" + arrSolic.size() );
        
        for (String solicitud : arrSolic) {
        	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter inputRecord = new ProxyInputParameter();
            inputRecord.setKey("ZOBJECT_ID");
            inputRecord.setValue( solicitud ); // justificar ceros a la izq
            recordParams1.add( inputRecord );
            inputParams.getRecordParam().add( recordParams1 );
		}
//        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
        proxy.executeRemoteFunction(destination, inputParams );
        
//        ArrayList<Customizables> arrcust = returnData.getArrCustomizables();
//        for (Customizables customizables : arrcust) {
//            log.info( customizables.getCustomfieldValue()+ "\t" + customizables.getCustomfieldKey() );
//		}
        
        
	}
}
