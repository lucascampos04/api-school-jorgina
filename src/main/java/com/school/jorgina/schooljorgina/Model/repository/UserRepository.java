package com.school.jorgina.schooljorgina.Model.repository;

import com.school.jorgina.schooljorgina.Model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByRg(String rg);
    Optional<UsersEntity> findByCpf(String cpf);

    Optional<Object> findByEmail(String email);

    Optional<Object> findByTelefone(String telefone);
}
