package com.ruibackend.ruiwebappbackend.controller;

import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.repository.UserRepository;
import com.ruibackend.ruiwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    @PatchMapping("/updateBio/{id}")
    public User update(@PathVariable(value = "id") int id, @RequestBody User userObj ) {
        return userService.update(id, userObj);
    }
    //Somehow spring is able to detect everything that matches the USER entity, without
    //specifying @RequestBody annotation which is cool. guess it auto detects it
    @PatchMapping("/uploadimage/{id}")
    public User uploadImage(@PathVariable(value = "id") int id, User userObj, @RequestParam("file") MultipartFile multipartImage) throws IOException {

       return userService.uploadImage(id,userObj,multipartImage);
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable int imageId) {
            return userService.downloadImage(imageId);
    }


}
