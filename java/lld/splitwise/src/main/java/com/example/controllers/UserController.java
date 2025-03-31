package com.example.controllers;

import com.example.dto.UserDTO;
import com.example.models.User;
import com.example.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping(
            value = {"", "/"},
            consumes = {APPLICATION_JSON_VALUE},
            produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> createUser(@RequestBody UserDTO requestBody) {
        userService.createUser(requestBody);
        return ResponseEntity.ok("User added successfully.");
    }

    @GetMapping(
            value = "/{userId}",
            produces = {APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> getUser(@PathVariable long userId) throws Exception {
        System.out.println("Got request to get user with user id " + userId);

        try {
            User user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
