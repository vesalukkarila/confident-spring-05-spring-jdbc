package com.vesalukkarila.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller without additional annotations makes class return html
@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
