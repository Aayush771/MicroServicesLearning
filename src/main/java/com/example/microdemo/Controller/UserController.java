package com.example.microdemo.Controller;

import com.example.microdemo.Entity.User;
import com.example.microdemo.Repository.DAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private  DAOService daoService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(daoService.findAllUsers(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable Integer id){
        return new ResponseEntity<>(daoService.findUserById(id),HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser = daoService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
