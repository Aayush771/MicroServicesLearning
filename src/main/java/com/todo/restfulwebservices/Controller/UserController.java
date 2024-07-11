package com.todo.restfulwebservices.Controller;

import com.todo.restfulwebservices.Entity.User;
import com.todo.restfulwebservices.Repository.DAOService;

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
    /**
     * Retrieve a specific user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The user entity if found, or a 404 response if not.
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<EntityModel<User>> retrieveUser(@PathVariable Integer id) {
        // Find the user by ID
        User user = daoService.findUserById(id);

        // If the user is not found, return a 404 response
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Create a model of the user with links to all users
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));

        // Return the user entity with a 200 OK status
        return ResponseEntity.ok(userEntityModel);
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
