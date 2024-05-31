package com.vesalukkarila;

public class InvoiceService {

    public Invoice create(String userId, Integer amount){
        return new Invoice(userId, amount, "http://www.urlToPdf");
    }
}
