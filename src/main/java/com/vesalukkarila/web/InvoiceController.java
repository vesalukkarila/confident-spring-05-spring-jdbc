package com.vesalukkarila.web;

import com.vesalukkarila.dto.InvoiceDto;
import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.service.InvoiceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    /*Extracting parameters appended to URL*/
    @PostMapping("/invoices")
    public Invoice createInvoiceFromParameters(
            @RequestParam("user_id") @NotBlank String userId,
            @RequestParam("amount") @Range(min = 10, max = 40) Integer amount) {
        return invoiceService.create(userId, amount);
    }

    /*Extracting path variables*/
    @PostMapping("/invoices/{userId}/{amount}")
    public Invoice createInvoiceFromPathVariables(
            @PathVariable("userId") @NotBlank String userId,
            @PathVariable("amount") @Range(min = 10, max = 40) Integer amount) {
        return invoiceService.create(userId, amount);
    }

    /*Incoming data in response body*/
    @PostMapping("/invoicesbody")
    public Invoice createInvoiceFromRequestBody(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
