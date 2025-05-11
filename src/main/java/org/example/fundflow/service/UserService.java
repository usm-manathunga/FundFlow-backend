package org.example.fundflow.service;

import org.example.fundflow.dto.UserDTO;
import org.example.fundflow.dto.UserResponseDTO;

public interface UserService {
    public UserResponseDTO getUser(UserDTO userDTO);
}
