package com.ruibackend.ruiwebappbackend.repository;


import com.ruibackend.ruiwebappbackend.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
