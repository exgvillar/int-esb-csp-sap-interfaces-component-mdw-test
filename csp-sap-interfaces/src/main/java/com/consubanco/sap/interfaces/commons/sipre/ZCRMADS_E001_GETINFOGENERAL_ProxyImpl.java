package com.consubanco.sap.interfaces.commons.sipre;

import com.consubanco.sap.interfaces.commons.sipre.model.E_ATTACH_FILE_Model;
import com.consubanco.sap.interfaces.commons.sipre.model.E_SIPRE_Model;
import com.consubanco.sap.interfaces.commons.sipre.model.GenericModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZCRMADS_E001_GETINFOGENERAL_ProxyImpl {

    private static Log log = LogFactory.getLog(ZCRMADS_E001_GETINFOGENERAL_ProxyImpl.class);
    private static final String RFC = "ZCRMADS_E001_GETINFOGENERAL";

    public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
                                                        ProxyInputParameterWithTable inputParams) throws Exception {

        ZCRMADS_E001_GETINFOGENERAL_OutputData outputData = new ZCRMADS_E001_GETINFOGENERAL_OutputData();
        List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
        JCoFunctionTemplate ft = null;
        JCoFunction function = null;

        try {
            ft = destination.getRepository().getFunctionTemplate(RFC);
            if (ft == null) {
                throw new RuntimeException(RFC + " not found in SAP.");
            }

            function = ft.getFunction();

            Iterator<ProxyInputParameter> iter = inputParams.getGeneralParam().iterator();
            while (iter.hasNext()) {
                ProxyInputParameter inputParam = iter.next();
                if (StringUtils.trimToNull(inputParam.getType()) == null) {
                    function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
                } else {
                    if (inputParam.getType().equals("java.util.date"))
                        function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getDateValue());
                    else
                        function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
                }
            }

            log.info(function.getImportParameterList().toString());

            function.execute(destination);

            log.info(function.getExportParameterList().toString());

            List<E_SIPRE_Model> tasksSipre = new ArrayList<E_SIPRE_Model>();
            JCoTable taskSipreTable = function.getExportParameterList().getTable("E_SIPRE");

            for (int i = 0; i < taskSipreTable.getNumRows(); i++, taskSipreTable.nextRow()) {
                E_SIPRE_Model taskSipre = new E_SIPRE_Model();

                taskSipre.setTaskId(taskSipreTable.getString("ID_TASK"));
                taskSipre.setCreateDate(taskSipreTable.getDate("CREATE_DATE"));
                taskSipre.setName(taskSipreTable.getString("NAME"));
                taskSipre.setNss(taskSipreTable.getString("NSS"));
                taskSipre.setMail(taskSipreTable.getString("EMAIL"));
                taskSipre.setTelephone(taskSipreTable.getString("TELEPHONE"));
                taskSipre.setNota(taskSipreTable.getString("NOTA"));

                GenericModel branchModel = new GenericModel();
                branchModel.setId(taskSipreTable.getString("ID_BRANCH"));
                branchModel.setDescription(taskSipreTable.getString("NOMBRE_SUCURSAL"));
                taskSipre.setBranch(branchModel);

                taskSipre.setBiometric(taskSipreTable.getString("BIOMETRICO"));

                List<E_ATTACH_FILE_Model> attachFiles = new ArrayList<E_ATTACH_FILE_Model>();
                JCoTable attachfileTable = taskSipreTable.getTable("E_ATTACH_FILE");

                for (int k = 0; k < attachfileTable.getNumRows(); k++, attachfileTable.nextRow()) {
                    E_ATTACH_FILE_Model attachfileModel = new E_ATTACH_FILE_Model();
                    attachfileModel.setFileName(attachfileTable.getString("FILENAME"));
                    attachfileModel.setBase64(attachfileTable.getString("BIN"));
                    attachFiles.add(attachfileModel);
                }

                taskSipre.setAttachfiles(attachFiles);

                GenericModel statusModel = new GenericModel();
                statusModel.setId(taskSipreTable.getString("ID_STATUS_TASK"));
                statusModel.setDescription(taskSipreTable.getString("DESCRIPCION_STATUS_TASK"));
                taskSipre.setStatus(statusModel);

                taskSipre.setPromotorBp(taskSipreTable.getString("BP_PROMOTOR"));
                taskSipre.setCustomerBp(taskSipreTable.getString("BP_CLIENTE"));

                tasksSipre.add(taskSipre);
            }

            outputData.setTasksSipre(tasksSipre);
            returnList.add(outputData);

            log.info("RFC :: " + RFC);
            log.info("Return data ---> " + returnList.toString());

        } catch (AbapException e) {
            log.error(" executing function " + RFC);
            log.error(e);
            throw e;
        }

        return (returnList);
    }
}
