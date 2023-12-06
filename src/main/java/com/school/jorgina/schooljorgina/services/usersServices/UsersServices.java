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
       if (userRepository.findByRg(userEntity.getRg()).isPresent()){
            throw new RuntimeException("RG já existe");
       }

       if (userRepository.findByCpf(userEntity.getCpf()).isPresent()){
            throw new RuntimeException("CPF já existe");
       }

       if (userRepository.findByEmail(userEntity.getEmail()).isPresent()){
            throw new RuntimeException("EMAIL já existe");
       }

       if (userRepository.findByTelefone(userEntity.getTelefone()).isPresent()){
            throw new RuntimeException("Telefone já existe");
       }

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

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return false;
    }
}
