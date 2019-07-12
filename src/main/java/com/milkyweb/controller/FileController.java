package com.milkyweb.controller;

import com.milkyweb.model.JsonDetail;
import com.milkyweb.service.FileService;
import com.milkyweb.service.PdfService;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class PdfController {
    private static final String PART_PATH = "src/main/resources/templates/";

    @Autowired
    private PdfService pdfService;

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value = "/files/pdf/", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object createPdfFile(@RequestBody JsonDetail json, HttpServletResponse response) {
        String template = PART_PATH + json.getTemplate() + ".jrxml";

        if (Files.notExists(Paths.get(template))) {
            response.setStatus(404);
            return "";
        }

        JasperPrint jasperPrint = pdfService.generatePdf(template, json);
        fileService.savePdf(jasperPrint);

        response.setStatus(201);

        return "";
    }

}
