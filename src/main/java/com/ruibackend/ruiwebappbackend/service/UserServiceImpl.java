package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.User;
import com.ruibackend.ruiwebappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    private User user;

    @Override
    public User saveUser(User user) {
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            return "ERROR";
//        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    // updates bio, find user BY id which grabs all info then set the bio based on the body.
    //then save
    @Override
    public User update(int id, User userObj) {
        User UserforBio = userRepository.findById(id).orElseThrow();
        UserforBio.setBio(userObj.getBio());
        return userRepository.save(UserforBio);
    }
    @Override
    public User resetPassword(int id, User userObj) {
        User passwordReset = userRepository.findById(id).orElseThrow();
        passwordReset.setPassword(userObj.getPassword());
        return userRepository.save(passwordReset);
    }
    //previously I was creating a new User Object each time with user = new user(), which
    //set everything to null (the json data). SO, I instead decided to pass in the data from
    //existing Object form-data in the raw data instead of generating a new one, and save that in the repo with
    //the content ALREADY set. and it walla, it works! I am passing in and modifying the object from the form-data,
    // instead of creating new ones.
    //PUT request checks for ID and changes if it exists.
    @Override
    public User uploadImage(int id, User userobj, MultipartFile multipartImage) throws IOException {
        User UserforImage = userRepository.findById(id).orElseThrow();
        UserforImage.setContent(multipartImage.getBytes());
        return userRepository.save(UserforImage);
    }

    @Override
    public Resource downloadImage(@PathVariable int imageId) {
        byte[] image = userRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getContent();
        return new ByteArrayResource(image);
    }

}
