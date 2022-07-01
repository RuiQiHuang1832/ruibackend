package com.ruibackend.ruiwebappbackend.controller;

import com.ruibackend.ruiwebappbackend.model.Posts;
import com.ruibackend.ruiwebappbackend.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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


    @GetMapping("/post-data")
    public List<Posts> getPosts() {
        return postsService.getPosts();
    }
}
