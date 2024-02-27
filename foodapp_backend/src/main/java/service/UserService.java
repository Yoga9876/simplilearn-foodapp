package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.SignInRequest;
import dto.SignUpRequest;
import dto.UpdateUserRequest;
import model.User;
import repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signUp(SignUpRequest signUpRequest) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        // Create a new user object
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setFullName(signUpRequest.getFullName());

        // Save the user to the database
        return userRepository.save(user);
    }

    public User signIn(SignInRequest signInRequest) {
        Optional<User> userOptional = userRepository.findByUsername(signInRequest.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Check if the password matches
            if (passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
                return user;
            }
        }
        return null; // User not found or password doesn't match
    }

    

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        // Find the user by userId
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null; // User not found
        }

        // Update user details
        user.setEmail(updateUserRequest.getEmail());
        user.setFullName(updateUserRequest.getFullName());

        // Save the updated user to the database
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId) {
        // Check if the user exists
        if (!userRepository.existsById(userId)) {
            return false; // User not found
        }

        // Delete the user from the database
        userRepository.deleteById(userId);
        return true;
    }
}