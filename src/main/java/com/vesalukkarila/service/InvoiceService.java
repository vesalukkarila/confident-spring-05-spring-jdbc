package com.vesalukkarila.service;

import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private final UserService userService;
    private List<Invoice> invoices;

    public InvoiceService(UserService userService) {
        this.userService = userService;
        this.invoices = new CopyOnWriteArrayList<>();
    }

    public Invoice create(String userId, Integer amount){
        User user = userService.findById(userId);
        if (user == null){
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, "http://www.urlToPdf");
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
