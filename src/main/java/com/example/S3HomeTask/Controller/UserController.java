package com.example.S3HomeTask.Controller;

import com.example.S3HomeTask.domain.User;
import com.example.S3HomeTask.services.DataProcessingService;
import com.example.S3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService service;


    @GetMapping
    public ResponseEntity<List<User>>  userList() {
        return ResponseEntity.ok(service.getDataProcessingService().getRepository().getUsers());

    }

    @PostMapping("/body")
    public String userAdd(@RequestBody User user) {

        service.getDataProcessingService().getRepository().addUser(user);
        return "User added";
    }
}
