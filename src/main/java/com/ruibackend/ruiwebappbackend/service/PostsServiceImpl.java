package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.Posts;
import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.repository.PostsRepository;
import com.ruibackend.ruiwebappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postsRepository;
    private Posts posts;

    @Override
    public Object postThread(Posts posts) {
        return postsRepository.save(posts);


    }
}
