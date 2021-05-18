package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        ModelAndView mv = new ModelAndView("usuarios");

        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();

        mv.addObject("usuarios",usuarios);

        return mv;
    }


    //https://riptutorial.com/thymeleaf/example/29269/form-submission
    @GetMapping("/add")
    public String addUsuarioPage(Model model){
        model.addAttribute("usuarioForm",new Usuario());

        return "usuarios_add";
    }
    @PostMapping("/add")
    public String addUsuario(@ModelAttribute("usuarioForm") Usuario usuario){

        usuarioRepository.save(usuario);

        return "redirect:/usuarios/";
    }


/*
    @Autowired
    UsuarioRepository usuarioRepository;
    */

/*
    @GetMapping("/")
    public ModelAndView listarUsuarios(){
        ModelAndView mv = new ModelAndView("usuarios");
        mv.addObject("usuarios", usuarioRepository.findAll());

        return mv;
    }
    @GetMapping("/add")
    public String addUsuario(){

        return "usuarios_add";
    }
    */

}
