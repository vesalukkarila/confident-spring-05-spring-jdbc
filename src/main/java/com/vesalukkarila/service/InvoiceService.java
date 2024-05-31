package com.vesalukkarila.service;

import com.vesalukkarila.model.Invoice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    private List<Invoice> invoices;

    public InvoiceService() {
        this.invoices = new CopyOnWriteArrayList<>();
    }

    public Invoice create(String userId, Integer amount){
        Invoice invoice = new Invoice(userId, amount, "http://www.urlToPdf");
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
