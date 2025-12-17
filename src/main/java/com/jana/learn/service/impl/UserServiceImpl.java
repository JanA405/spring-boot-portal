package com.jana.learn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jana.learn.model.User;
import com.jana.learn.repository.UserRepository;
import com.jana.learn.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
        private UserService userService;
    
        @Override
        public User createUser(User user) {
             return userRepository.save(user);
        }
    
        @Override
        public List<User> getAllUsers() {
           return userRepository.findAll();
        }
    
        @Override
        public User updateUserById(Long id, User user) {
            Optional<User> existingUser= userRepository.findById(id);
            if (existingUser.isPresent()){
               User isUser = existingUser.get(); //convert optional <user> to user
               isUser.setName(user.getName());
               isUser.setEmail(user.getEmail());
               isUser.setPassword(user.getPassword());
               isUser.setRole(user.getRole());
               return userRepository.save(isUser);
            }
            return null;
                   
        }
    
        @Override
        public void deleteUserById(Long id) {
            userRepository.deleteById(id);
        }
       
    }
    

