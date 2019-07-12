package com.milkyweb.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private static final String DEST = "demo.pdf";

    public void savePdf(JasperPrint jasperPrint) {
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, DEST);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
