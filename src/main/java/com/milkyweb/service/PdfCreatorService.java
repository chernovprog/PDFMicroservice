package com.milkyweb.service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PdfCreatorService {
    private static final String DEST = "demo.pdf";
    private static final String JRXML = "report1.jrxml";

    public void createPdfFile() {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(JRXML);
            JRDataSource jrDataSource = new JREmptyDataSource();
            Map<String, Object> parameters = getParameters();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, DEST);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    private Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "my title");
        parameters.put("number", 123);

        return parameters;
    }

}
