package com.homeloan.application.controller;

import com.homeloan.application.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {


    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){

    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(){

    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(){

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(){

    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(){

    }
}
