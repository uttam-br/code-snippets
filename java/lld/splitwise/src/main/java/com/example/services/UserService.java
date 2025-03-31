package com.example.services;

import com.example.dto.UserDTO;
import com.example.models.User;
import com.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public void createUser(UserDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        System.out.println("Saving user to DB...");
        userRepository.save(user);
        System.out.println("Saved user to DB.");
    }

    public User getUser(long userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new Exception("User does not exists...");
        }

        return userOptional.get();
    }

}
