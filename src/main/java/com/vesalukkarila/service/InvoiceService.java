package com.vesalukkarila.service;

import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private final UserService userService;
    private final String cdnUrl;
    private List<Invoice> invoices;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
        this.invoices = new CopyOnWriteArrayList<>();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Printout from invoicesService's postconstruct");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Printout from invoiceService's predestroy");
    }

    public Invoice create(String userId, Integer amount){
        User user = userService.findById(userId);
        if (user == null){
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

}
