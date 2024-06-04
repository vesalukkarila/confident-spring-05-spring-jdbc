package com.vesalukkarila.web;

import com.vesalukkarila.dto.InvoiceDto;
import com.vesalukkarila.model.Invoice;
import com.vesalukkarila.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

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
    * converting Java object <-> JSON*/
    @GetMapping("/invoices")
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    /*Extracting parameters appended to URL*/
    @PostMapping("/invoices")
    public Invoice createInvoiceFromParameters(@RequestParam("user_id") String userId,
                                 @RequestParam("amount") Integer amount) {
        return invoiceService.create(userId, amount);
    }

    /*Extracting path variables*/
    @PostMapping("/invoices/{userId}/{amount}")
    public Invoice createInvoiceFromPathVariables(@PathVariable("userId") String userId,
                                                   @PathVariable("amount") Integer amount) {
        return invoiceService.create(userId, amount);
    }

    /*Incoming data in response body*/
    @PostMapping("/invoicesbody")
    public Invoice createInvoiceFromRequestBody(@RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
