package com.lhind.internship.jpaintro.service;

import com.lhind.internship.jpaintro.model.entity.User;
import com.lhind.internship.jpaintro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return  userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserBydIdWithDetails(Long id){
        return userRepository.findUserWithDetailsById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> getAllUserWithDetails(){
        return userRepository.findAllUsersWithDetails();
    }
}
