package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public ModelAndView listarUsuarios(){
        ModelAndView mv = new ModelAndView("usuarios");
        mv.addObject("usuarios", usuarioRepository.findAll());

        return mv;
    }
}
