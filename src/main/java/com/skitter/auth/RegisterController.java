package com.skitter.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by soren on 12/3/16.
 */
@Controller
public class RegisterController {

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping("/register")
    public String register(@RequestParam(value="name", required=false, defaultValue = "Jerry") String name, Model model){
        model.addAttribute("name", name);
        return "register";
    }

}
