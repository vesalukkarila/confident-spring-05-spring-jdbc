package com.vesalukkarila.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/*Enable in VM options: -Dspring.profiles.active=dev */
@Service
@Profile("dev")
public class DummyInvoiceServiceLoader {

    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Creating dummy invoices for development environment");
        invoiceService.create("dummyinvoice", 30);
        invoiceService.create("dummyinvoice2", 20);
    }
}
