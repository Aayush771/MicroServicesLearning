package com.todo.restfulwebservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.restfulwebservices.Models.User;
import com.todo.restfulwebservices.Repository.UserDAOService;

@RestController
public class UserController {


    private UserDAOService userDAOService;

    
    public UserController(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }


    @GetMapping("/users")
    public List<User> retriveAllUsers(){

       return userDAOService.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
       return userDAOService.saveUser(user);
    }
}
