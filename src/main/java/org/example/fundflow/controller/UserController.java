package org.example.fundflow.controller;

import org.example.fundflow.dto.UserDTO;
import org.example.fundflow.dto.UserResponseDTO;
import org.example.fundflow.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserDTO userDTO) {
        UserResponseDTO user = userService.getUser(userDTO);
        return ResponseEntity.ok(user);
    }
}
