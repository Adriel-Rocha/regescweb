package br.com.adrielrocha.regescweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.adrielrocha.regescweb.dto.RequisicaoNovoProfessor;
import br.com.adrielrocha.regescweb.models.Professor;
import br.com.adrielrocha.regescweb.models.StatusProfessor;
import br.com.adrielrocha.regescweb.repositories.ProfessorRepository;
import jakarta.validation.Valid;

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

    @GetMapping("/professores/new")
    public ModelAndView nnew(RequisicaoNovoProfessor req) {

        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("listaStatusProfessor", StatusProfessor.values());

        return mv;
    }

    @PostMapping("/professores")
    public ModelAndView create(@Valid RequisicaoNovoProfessor req, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("********************* ---------- ******************");

            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
            
        } else {
            Professor professor = req.toProfessor();
            this.professorRepository.save(professor);
        
            return new ModelAndView("redirect:/professores");
    }
}

}
