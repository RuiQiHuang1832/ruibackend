package com.ruibackend.ruiwebappbackend.service;

import com.ruibackend.ruiwebappbackend.model.User;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllStudents();
    User update( User userObj);
    User uploadImage(User userobj, MultipartFile multipartImage) throws IOException;
     Resource downloadImage(@PathVariable int imageId);
}
