package com.vesalukkarila.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

//@Controller without additional annotations makes class return html
@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(value = "username", required = false, defaultValue = "stranger") String userName) {
        model.addAttribute("username", userName);
        model.addAttribute("currentDate", LocalDateTime.now());
        return "index.html";
    }
}
