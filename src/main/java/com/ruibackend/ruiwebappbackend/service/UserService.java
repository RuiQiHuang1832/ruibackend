package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllStudents();

}
