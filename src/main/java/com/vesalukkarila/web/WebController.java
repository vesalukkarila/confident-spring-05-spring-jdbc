package com.vesalukkarila.web;

import com.vesalukkarila.web.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    //this serves the login.html and allready provides backing bean for incoming data from form
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model) {
        //faking login
        if (loginForm.getUsername().equalsIgnoreCase(loginForm.getPassword())) {
            return "redirect:/";
        }
        model.addAttribute("invalidCredentials", true);
        return "login.html"; //spring will issue http 302 redirect to the path you are returning
    }
}
