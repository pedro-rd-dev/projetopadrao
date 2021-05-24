package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.graalvm.compiler.loop.DefaultLoopPolicies_OptionDescriptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;



    @GetMapping("/")
    public ModelAndView listarUsuarios(){

        ModelAndView mv = new ModelAndView("usuarios");
        ArrayList<Usuario> usuarios;
        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        mv.addObject("usuariosLista",usuarios);

        return mv;
    }

    @GetMapping("/add")
    public String addUsuarioPage(Usuario usuario){

        return "usuarios_add";
    }

    @PostMapping("/add")
    public String addUsuario(@Validated Usuario usuario){

        usuarioRepository.save(usuario);

        return "redirect:/usuarios/";
    }

    @GetMapping("/{id}")
    public ModelAndView editarUsuarioPage(@PathVariable(value = "id") Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        ModelAndView modelAndView = new ModelAndView("usuarios_edit");
        modelAndView.addObject("usuario",usuario);


        return modelAndView;
    }
    @PostMapping("/edit")
    public String editarUsuario(Usuario usuario){

        usuarioRepository.save(usuario);


        return "redirect:/usuarios/";
    }
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        usuarioRepository.delete(usuario);

        return "redirect:/usuarios/";
    }
}
