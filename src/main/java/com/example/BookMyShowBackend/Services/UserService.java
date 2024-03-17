package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.User;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().emailId(addUserRequest.getUserEmailId())
                .name(addUserRequest.getName())
                .build();

        userRepository.save(user);
        return "User has been saved with userId "+user.getUserId();

    }
}
