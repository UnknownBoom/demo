package com.example.demo.controller;

import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("")
    public ResponseEntity<Collection<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
