package com.milkyweb.service;

import com.milkyweb.model.Carrier;
import com.milkyweb.model.Condition;
import com.milkyweb.model.Consignee;
import com.milkyweb.model.Dispatcher;
import com.milkyweb.model.JsonDetail;
import com.milkyweb.model.Shipper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfServiceImpl implements PdfService {

    public JasperPrint generatePdf(String template, JsonDetail json) {
        JasperPrint jasperPrint = null;

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(template);
            JRDataSource jrDataSource = new JREmptyDataSource();

            List<Dispatcher> listDispatcher = new ArrayList<>();
            listDispatcher.add(json.getDispatcher());
            JRBeanCollectionDataSource dataSourceDispatcher = new JRBeanCollectionDataSource(listDispatcher);

            List<Carrier> listCarrier = new ArrayList<>();
            listCarrier.add(json.getCarrier());
            JRBeanCollectionDataSource dataSourceCarrier = new JRBeanCollectionDataSource(listCarrier);

            List<Shipper> listShipper = new ArrayList<>();
            listShipper.add(json.getShipper());
            JRBeanCollectionDataSource dataSourceShipper = new JRBeanCollectionDataSource(listShipper);

            List<Consignee> listConsignee = new ArrayList<>();
            listConsignee.add(json.getConsignee());
            JRBeanCollectionDataSource dataSourceConsignee = new JRBeanCollectionDataSource(listConsignee);

            Condition condition = json.getCondition();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dispatcher", dataSourceDispatcher);
            parameters.put("carrier", dataSourceCarrier);
            parameters.put("shipper", dataSourceShipper);
            parameters.put("consignee", dataSourceConsignee);
            parameters.put("mainCondition", condition.getMainCondition());
            parameters.put("lastPageCondition", condition.getLastPageCondition());

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);

        } catch (JRException e) {
            e.printStackTrace();
        }

        return jasperPrint;
    }

}
