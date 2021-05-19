package com.senac.projetopadrao.controllersRest;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerRest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public ArrayList<Usuario> listar(){
        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();

        return usuarios;
    }

    @PostMapping("/addRest")
    public String addUsuario(){

        Usuario usuario = new Usuario();
        usuario.setNome("pedro");
        usuario.setDataDeNascimento("07/08/1987");
        usuario.setEstadoCivil(true);

        usuarioRepository.save(usuario);

        return "usuario adicionado";
    }

    @PutMapping("/editar")
    public String editarUsuario(){

        return "usuario editado";
    }
}
