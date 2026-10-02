package com.gaurav.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.model.User;
import com.gaurav.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws Exception {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/user/{Id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long Id, @RequestBody User user) throws Exception {
        User userUpdated = userService.updateUserById(Id, user);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable Long Id) throws Exception {
        userService.deleteById(Id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
