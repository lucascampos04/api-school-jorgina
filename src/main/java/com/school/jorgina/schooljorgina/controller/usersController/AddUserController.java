package com.school.jorgina.schooljorgina.controller.usersController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/addusers")
@RestController
public class AddUserController {
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public String usersInit(){
        return "usuários";
    }
}
