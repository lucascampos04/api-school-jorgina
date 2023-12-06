package com.school.jorgina.schooljorgina.Model.repository;

import com.school.jorgina.schooljorgina.Model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
}
