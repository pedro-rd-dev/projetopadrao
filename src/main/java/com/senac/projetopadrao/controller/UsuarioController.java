package com.senac.projetopadrao.controller;

import com.senac.projetopadrao.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.senac.projetopadrao.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping("/usuarios")
    public String addUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("pedro");

        System.out.println("Entrou em ususaros");

        usuarioRepository.save(usuario);
        return "usuarios";
    }
}
