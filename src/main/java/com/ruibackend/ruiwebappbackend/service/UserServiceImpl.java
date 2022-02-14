package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }
}
