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
        if (usersEntity.getCargo().isEmpty() || usersEntity.getRg().isEmpty() || usersEntity.getCpf().isEmpty() ||
                usersEntity.getEmail().isEmpty() || usersEntity.getSenha().isEmpty()  || usersEntity.getSalario() == 0 ||
                usersEntity.getSexo().isEmpty()
        ){
            String msgVazio = "Não pode haver campos vazios ou salário nulo";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msgVazio);
        }

        UsersEntity createdUser = usersServices.addUser(usersEntity);

        if (createdUser != null){
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(createdUser));
        }
        String msgError = "Não foi possível criar o usuário";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msgError);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UsersEntity> getAllUsers(){
        return usersServices.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsersEntity> getUserById(@PathVariable Long id){
        Optional<UsersEntity> user = usersServices.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsersEntity> updateUser(@PathVariable Long id, @RequestBody UsersEntity updatedUser){
        Optional<UsersEntity> updated = usersServices.updateUser(id, updatedUser);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        usersServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
