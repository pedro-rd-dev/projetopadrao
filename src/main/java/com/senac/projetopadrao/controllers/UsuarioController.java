package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public ModelAndView listarUsuarios(){
        ModelAndView mv = new ModelAndView("usuario");

        ArrayList<Usuario> usuarios;

        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();

        mv.addObject("usuarios",usuarios);

        return mv;
    }

}
