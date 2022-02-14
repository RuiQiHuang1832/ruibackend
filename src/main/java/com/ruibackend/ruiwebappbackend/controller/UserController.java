package com.ruibackend.ruiwebappbackend.controller;

import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new student added";
    }

    @GetMapping("/getAll")
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }

}
