package com.school.jorgina.schooljorgina.Model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity(name = "usuarios")
@Data
@AllArgsConstructor
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String nome;

    
    private String cargo;

    
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")
    private String cpf;

    
    @Pattern(regexp = "[0-9]{2}.[0-9]{3}.[0-9]{3}-[0-9Xx]{1}")
    private String rg;

    
    private String senha;

    
    private String status;

    
    private Double salario;

    
    private String email;

    
    private String telefone;

    
    private String sexo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataregistro;

    public UsersEntity() {

    }

    @PrePersist
    public void prePersist(){
        StatusVerificacao();
    }

    public String StatusVerificacao(){
        if (getSalario() == null){
            setStatus("ALUNO");
            return "ALUNO";
        } else {
            setStatus("FUNCIONARIO");
            return "FUNCIONARIO";
        }
    }
}
