package br.com.adrielrocha.regescweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.adrielrocha.regescweb.models.Professor;
import br.com.adrielrocha.regescweb.models.StatusProfessor;
import br.com.adrielrocha.regescweb.repositories.ProfessorRepository;

@Controller
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    
    
    @GetMapping("/professores")
    public ModelAndView index() {
        

        List<Professor> professores = this.professorRepository.findAll();

        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professores", professores);

        return mv;
    }

    @GetMapping("/professor/new")
    public ModelAndView nnew() {

        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("statusProfessor", StatusProfessor.values());

        
        return mv;
    }

}
