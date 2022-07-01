package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.Posts;
import com.ruibackend.ruiwebappbackend.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postsRepository;

    // post a new post
    @Override
    public Object postThread(Posts posts) {
        return postsRepository.save(posts);
    }

    //retrieves all post data
    @Override
    public List<Posts> getPosts() {
        return postsRepository.findAll();

    }
}
