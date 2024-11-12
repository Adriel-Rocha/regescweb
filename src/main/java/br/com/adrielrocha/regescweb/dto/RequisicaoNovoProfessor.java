package br.com.adrielrocha.regescweb.dto;

import java.math.BigDecimal;

import br.com.adrielrocha.regescweb.models.Professor;
import br.com.adrielrocha.regescweb.models.StatusProfessor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoProfessor {
    private String nome;
    private BigDecimal salario;
    private StatusProfessor statusProfessor;

    public Professor toProfessor() {
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);
    
        return professor;
    }
}


