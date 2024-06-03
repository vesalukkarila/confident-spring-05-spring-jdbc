package com.vesalukkarila.service;

import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    //drawbacks: hides dependency this class need, hard to instantiate outside of spring context
    @Autowired
    private ExampleServiceForFieldInjection exampleServiceForFieldInjection;
    private final UserService userService;
    private List<Invoice> invoices;

    /*Recommended for mandatory dependencies.
    note to self: @Autowired was necessary in constructor injection before Spring 4.3,
    Done implicitly nowadays (though can still be used for clarity)*/
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

    /*recommended for optional dependencies*/
    @Autowired
    public void setExampleServiceForFieldInjection(ExampleServiceForFieldInjection exampleService) {
        this.exampleServiceForFieldInjection = exampleService;
    }
}
