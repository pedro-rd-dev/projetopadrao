package com.senac.projetopadrao.controllersRest;

import com.senac.projetopadrao.models.Usuario;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllerRest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/add")
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
