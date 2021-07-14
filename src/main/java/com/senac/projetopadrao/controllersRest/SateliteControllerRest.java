package com.senac.projetopadrao.controllersRest;

import com.senac.projetopadrao.models.Satelite;
import com.senac.projetopadrao.repositorys.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satelites")
public class SateliteControllerRest {

    @Autowired
    SateliteRepository sateliteRepository;

    @GetMapping("/")
    public List<Satelite> listarSatelite(){

        return sateliteRepository.findAll();

    }

    @PostMapping("/add")
    public String addSatelite(Satelite satelite){

        sateliteRepository.save(satelite);

        return "adicionado com sucesso";
    }

    @DeleteMapping("/{id}")
    public String deletarSatelite(@PathVariable(value = "id") int id){


        Satelite satelite = new Satelite();

        satelite = sateliteRepository.findSateliteByIdSatelite(id);

        sateliteRepository.delete(satelite);

        return "deletado com sucesso";
    }

}
