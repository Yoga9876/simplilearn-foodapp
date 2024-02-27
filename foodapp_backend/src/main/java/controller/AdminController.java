package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.AdminLoginRequest;
import dto.AdminSignupRequest; // Import the DTO for signup request
import model.Admin;
import service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/admin/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest adminLoginRequest) {
        Admin admin = adminService.findByUsername(adminLoginRequest.getUsername());
        if (admin == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if (passwordEncoder.matches(adminLoginRequest.getPassword(), admin.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<String> signup(@RequestBody AdminSignupRequest adminSignupRequest) {
        // Perform validation on the signup request if needed

        // Check if the username is already taken
        if (adminService.findByUsername(adminSignupRequest.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(adminSignupRequest.getPassword());

        // Create a new admin entity
        Admin newAdmin = new Admin(adminSignupRequest.getUsername(), encryptedPassword);

        // Save the new admin
        adminService.save(newAdmin);

        return ResponseEntity.status(HttpStatus.CREATED).body("Admin signed up successfully");
    }
}
