package com.ruibackend.ruiwebappbackend.controller;

import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.repository.UserRepository;
import com.ruibackend.ruiwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//^(this is the parent directory, must go here first before going to any other mappings)

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String home() {
        return "This is home page";
    }
    @GetMapping("/admin")
    public String admin() {
        return "This is admin page";
    }

    @GetMapping("/stuff")
    public String stuff() {
        return "This is stuff page";
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new student added";
    }

    @GetMapping("/getAll")
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }

    @PutMapping("/updateBio")
    public User update(@RequestBody User userObj) {
        return userService.update(userObj);
    }


}
