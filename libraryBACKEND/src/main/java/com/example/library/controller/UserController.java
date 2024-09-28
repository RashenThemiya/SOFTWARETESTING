package com.example.library.controller;

import com.example.library.Models.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Allow requests from React frontend
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //only for admin post reqest using basic auth admin passward and username
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Return a conflict response when username already exists
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/logine")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
        if (authenticatedUser.isPresent()) {
            // Return the username and role upon successful login
            String role = authenticatedUser.get().getRole();
            return ResponseEntity.ok("Login successful! Role: " + role);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password!");
        }
    }
}