package com.milkyweb.service;

import com.milkyweb.model.JsonDetail;
import net.sf.jasperreports.engine.JasperPrint;

public interface PdfService {
    JasperPrint generatePdf(String template, JsonDetail json);
}
