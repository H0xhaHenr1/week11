package com.lhind.internship.jpaintro.controller;

import com.lhind.internship.jpaintro.model.entity.User;
import com.lhind.internship.jpaintro.model.entity.UserDetails;
import com.lhind.internship.jpaintro.repository.UserRepository;
import com.lhind.internship.jpaintro.service.UserDetailsService;
import com.lhind.internship.jpaintro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.USER_URL)
public class UserController {

    static final String USER_URL = "/users";

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public UserController(UserRepository userRepository, UserService userService, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getUserByIdWithDetails(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserBydIdWithDetails(id));
    }

//    @GetMapping()
//    public ResponseEntity getAllUsers(){
//        return ResponseEntity.ok(userService.getAllUsers());
//    }

    @GetMapping()
    public ResponseEntity getAllUsersWithDetails(){
        List<User> users = userService.getAllUserWithDetails();

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping()
    public ResponseEntity postUser(@RequestBody User user){
        if(user.getUserDetails() !=null){
            user.getUserDetails().setUser(user);
        }
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
