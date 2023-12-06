package com.school.jorgina.schooljorgina.services.usersServices;

import com.school.jorgina.schooljorgina.Model.entity.UsersEntity;
import com.school.jorgina.schooljorgina.Model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServices {

    private final UserRepository userRepository;

    @Autowired
    public UsersServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UsersEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UsersEntity addUser(UsersEntity userEntity) {
        userEntity.setDataregistro(LocalDateTime.now());
        return userRepository.save(userEntity);
    }

    public Optional<UsersEntity> updateUser(Long id, UsersEntity updatedUserEntity) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    updatedUserEntity.setId(id);
                    updatedUserEntity.setDataregistro(existingUser.getDataregistro());
                    return userRepository.save(updatedUserEntity);
                });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
