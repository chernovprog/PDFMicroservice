package com.milkyweb.service;

import net.sf.jasperreports.engine.JasperPrint;

public interface FileService {
    void savePdf(JasperPrint jasperPrint);
}
