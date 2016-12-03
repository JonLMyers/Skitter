package com.skitter.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by soren on 12/3/16.
 */
@Controller
public class RegisterController {

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user){
        return "result";
    }

    @RequestMapping("/register")
    public String register(@RequestParam(value="name", required=false, defaultValue = "Jerry") String name, Model model){
        model.addAttribute("name", name);
        return "register";
    }

}
