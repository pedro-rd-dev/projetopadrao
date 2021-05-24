package com.senac.projetopadrao.controllers;

import com.senac.projetopadrao.models.Satelite;
import com.senac.projetopadrao.repositorys.SateliteRepository;
import com.senac.projetopadrao.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
@RequestMapping("/satelites")
public class SateliteController {

    @Autowired
    SateliteRepository sateliteRepository;



    @GetMapping("/")
    public ModelAndView listarSatelites(){

        ModelAndView mv = new ModelAndView("satelites");
        ArrayList<Satelite> satelites;
        satelites = (ArrayList<Satelite>) sateliteRepository.findAll();
        mv.addObject("satelitesLista",satelites);

        return mv;
    }

    @GetMapping("/add")
    public String addUsuarioPage(Satelite satelite){

        return "satelites_add";
    }

    @PostMapping("/add")
    public String addUsuario(@Validated Satelite satelite){

        sateliteRepository.save(satelite);

        return "redirect:/satelites/";
    }

}
