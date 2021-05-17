package com.senac.projetopadrao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class loginController {

    @RequestMapping("/login")
    public String login(){

        return "login/login";
    }
}
