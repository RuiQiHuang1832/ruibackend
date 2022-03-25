package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllStudents();
    User update( User userObj);

}
