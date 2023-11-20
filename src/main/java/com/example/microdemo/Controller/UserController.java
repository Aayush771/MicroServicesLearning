package com.example.microdemo.Controller;

import com.example.microdemo.Entity.User;
import com.example.microdemo.Repository.DAOService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<EntityModel<User>> retrieveUser(@PathVariable Integer id) {
        User user = daoService.findUserById(id);

        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));
        return new ResponseEntity<>(userEntityModel, HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User savedUser = daoService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
