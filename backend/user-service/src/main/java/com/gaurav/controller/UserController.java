package com.gaurav.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.model.User;
import com.gaurav.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/api/user/{userId}")
    public User getUserById(@PathVariable Long userId) throws Exception {

        Optional<User> otp = userRepository.findById(userId);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new Exception("now found user");
    }

    @PutMapping("/api/user/{Id}")
    public User updateUserById(@PathVariable Long Id, @RequestBody User user) throws Exception {
        Optional<User> otp = userRepository.findById(Id);
        if (otp.isEmpty()) {
            throw new Exception("not found");
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/api/user/{Id}")
    public User deleteById(@PathVariable Long Id) throws Exception {
        Optional<User> otp = userRepository.findById(Id);
        if (otp.isEmpty()) {
            throw new Exception("not found");
        }
        User existingUser = otp.get();
        userRepository.delete(existingUser);
        return existingUser;
    }


}
