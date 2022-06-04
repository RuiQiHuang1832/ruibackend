package com.ruibackend.ruiwebappbackend.controller;

import com.ruibackend.ruiwebappbackend.model.Posts;
import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.service.PostsService;
import com.ruibackend.ruiwebappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;


import java.io.IOException;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

//^(this is the parent directory, must go here first before going to any other mappings)

@CrossOrigin
@RestController
public class PostsController {

    @Autowired
    private PostsService postsService;

    @PostMapping("/posts")
    public String postThread(@RequestBody Posts posts) {
        postsService.postThread(posts);
        return "success";
    }

}
