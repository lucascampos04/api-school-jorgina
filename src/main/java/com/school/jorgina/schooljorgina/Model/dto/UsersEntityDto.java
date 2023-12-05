package com.school.jorgina.schooljorgina.Model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.school.jorgina.schooljorgina.Model.entity.UsersEntity}
 */
public record UsersEntityDto(Long id, String nome, String cargo, String cpf, String rg, String senha, String status,
                             Double salario, String email, String telefone, String sexo,
                             LocalDateTime dataregistro) implements Serializable {
}
