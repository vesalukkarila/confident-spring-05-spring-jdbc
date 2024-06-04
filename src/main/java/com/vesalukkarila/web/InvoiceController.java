package com.vesalukkarila.web;

import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello from webmvc controller";
    }

    /*@EnableWebMvc in config enables Jackson to work behind the scenes
    * and converting Java object <-> JSON*/
    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }
}
