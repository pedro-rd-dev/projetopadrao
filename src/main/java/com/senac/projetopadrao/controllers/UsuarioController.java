package com.senac.projetopadrao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/listar")
    public String listarUsuarios(){

        System.out.println("USUARIOS");

        return "usuarios";
    }


}
