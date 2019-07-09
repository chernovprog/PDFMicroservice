package com.milkyweb.controller;

import com.milkyweb.service.PdfCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private PdfCreatorService pdfCreatorService;

    @GetMapping("/")
    public String onIndex() {
        return "index";
    }

    @GetMapping("/createPdfFile")
    public String createPdfFile() {
        pdfCreatorService.createPdfFile();

        return "redirect:/";
    }

}
