package com.ruibackend.ruiwebappbackend.service;


import com.ruibackend.ruiwebappbackend.model.Posts;

import java.util.List;

public interface PostsService {

    Object postThread(Posts posts);
    List<Posts> getPosts();

}


