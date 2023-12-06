package com.school.jorgina.schooljorgina.controller.usersController;

import com.school.jorgina.schooljorgina.Model.entity.UsersEntity;
import com.school.jorgina.schooljorgina.services.usersServices.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/addusers")
@RestController
public class AddUserController {
    @Autowired
    private UsersServices usersServices;

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody UsersEntity usersEntity){
        try {
            UsersEntity addUsers = usersServices.addUser(usersEntity);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario criado \nID : " + addUsers.getId() + "Email : " + addUsers.getEmail());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao adicionar o usuario. | Erro : " + e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersEntity>> getAllUsers(){
        List<UsersEntity> users = usersServices.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UsersEntity> getUserById(@PathVariable Long id){
        Optional<UsersEntity> user = usersServices.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UsersEntity> updateUser(@PathVariable Long id, @RequestBody UsersEntity updatedUser){
        Optional<UsersEntity> updated = usersServices.updateUser(id, updatedUser);

        if (updated.isPresent()){
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        boolean deleted = usersServices.deleteUser(id);
        if (deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
