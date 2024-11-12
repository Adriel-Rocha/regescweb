package br.com.adrielrocha.regescweb.dto;

import java.math.BigDecimal;

import br.com.adrielrocha.regescweb.models.Professor;
import br.com.adrielrocha.regescweb.models.StatusProfessor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoProfessor {
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @DecimalMin(value = "0.0")
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


