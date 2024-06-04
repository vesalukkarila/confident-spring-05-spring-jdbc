package com.vesalukkarila.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InvoiceController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello from webmvc controller";
    }
}
