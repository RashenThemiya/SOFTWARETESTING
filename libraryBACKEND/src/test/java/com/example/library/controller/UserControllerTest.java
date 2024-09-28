package com.example.library.controller;

import com.example.library.Models.User;
import com.example.library.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testRegisterUser() throws Exception {
        // Mock user object
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        // Simulate the saveUser method
        when(userService.saveUser(any(User.class))).thenReturn(user);

        // Perform the POST request and assert the status
        mockMvc.perform(post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(user)));
    }

    @Test
    public void testLoginUser() throws Exception {
        // Mock user and authentication
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setRole("admin");

        // Simulate the authenticateUser method
        when(userService.authenticateUser("testUser", "testPassword"))
                .thenReturn(Optional.of(user));

        // Perform the POST request for login
        mockMvc.perform(post("/users/logine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("Login successful! Role: admin"));
    }

    @Test
    public void testLoginUser_InvalidCredentials() throws Exception {
        // Simulate failed login
        when(userService.authenticateUser("wrongUser", "wrongPassword"))
                .thenReturn(Optional.empty());

        // Create a user with wrong credentials
        User invalidUser = new User();
        invalidUser.setUsername("wrongUser");
        invalidUser.setPassword("wrongPassword");

        // Perform the POST request and expect unauthorized status
        mockMvc.perform(post("/users/logine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidUser)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid username or password!"));
    }

}
