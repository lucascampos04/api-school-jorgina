package com.school.jorgina.schooljorgina.Model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity(name = "usuarios")
@Data
@NoArgsConstructor
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String cargo;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")
    private String cpf;

    @NotEmpty
    @Pattern(regexp = "[0-9]{2}.[0-9]{3}.[0-9]{3}-[0-9Xx]{1}")
    private String rg;

    @NotEmpty
    private String senha;

    @NotEmpty
    private String status;

    @NotEmpty
    private Double salario;

    @NotEmpty
    private String email;

    @NotEmpty
    private String telefone;

    @NotEmpty
    private String sexo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataregistro;
}
