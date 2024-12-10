package com.example.cabTracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//UserService.java
@Service
public class UserService {
 @Autowired
 private UserRepository userRepository;

 public User createUser(User user) {
     return userRepository.save(user);
 }

 public List<User> getAllUsers() {
     return userRepository.findAll();
 }
}