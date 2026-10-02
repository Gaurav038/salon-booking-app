package com.gaurav.service;

import java.util.List;

import com.gaurav.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(Long userId) throws Exception;

    User updateUserById(Long userId, User user) throws Exception;

    void deleteById(Long userId) throws Exception;

}
