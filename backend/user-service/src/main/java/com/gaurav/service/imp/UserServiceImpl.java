package com.gaurav.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gaurav.model.User;
import com.gaurav.repository.UserRepository;
import com.gaurav.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        Optional<User> otp = userRepository.findById(userId);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new Exception("no found user");
    }

    @Override
    public User updateUserById(Long userId, User user) throws Exception {
        Optional<User> otp = userRepository.findById(userId);
        if (otp.isEmpty()) {
            throw new Exception("not found");
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteById(Long userId) throws Exception {
        Optional<User> otp = userRepository.findById(userId);
        if (otp.isEmpty()) {
            throw new Exception("not found");
        }
        User existingUser = otp.get();
        userRepository.delete(existingUser);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

}
