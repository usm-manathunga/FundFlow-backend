package org.example.fundflow.service.Impl;

import org.example.fundflow.dto.UserDTO;
import org.example.fundflow.dto.UserResponseDTO;
import org.example.fundflow.entity.User;
import org.example.fundflow.repository.UserRepository;
import org.example.fundflow.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO getUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return new UserResponseDTO(user.getId(), user.getEmail(), user.getRole());
    }
}
