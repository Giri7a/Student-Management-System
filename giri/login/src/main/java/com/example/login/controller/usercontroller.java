package com.example.login.controller;

import com.example.login.dto.AllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.login.service.userservice;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class usercontroller {

    @Autowired //enables dependency injection for Java classes
    private userservice userservice;

    @Autowired
    private RestTemplate restTemplate; //handling HTTP communication
    @PostMapping("/login")

    public String login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (userservice.Authenticate(username, password)) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }


    @GetMapping("/Students/AllStudents")
    public List<AllDto> getAllStudents() {
        String url = "http://localhost:8082/api/Students/AllStudents";
        return restTemplate.getForObject(url, List.class);
    }
    @PostMapping("/Students/addStudent") //responseentity.It represents the entire HTTP response, including headers, status code, and body.
    public ResponseEntity<String> createClassSectionStudent(@RequestBody AllDto allDto) { //binds the HTTP request body to the parameter
       try {
          String url = "http://localhost:8082/api/Students/addStudent";
          restTemplate.postForObject(url, allDto, AllDto.class);
          return ResponseEntity.ok("Student added successfully");
       } catch (Exception e) {
             // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add student: " + e.getMessage());
          }
    }

     @PutMapping("/Students/updateStudent")
     public ResponseEntity<String> updateStudentById(@RequestBody AllDto allDto) {
        try {
            String url = "http://localhost:8082/api/Students/updateStudent";
            restTemplate.put(url, allDto);
            return ResponseEntity.ok("Student updated successfully");
       } catch (Exception e) {
          // Log the exception
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update student: " + e.getMessage());
       }
     }

     @DeleteMapping("/Students/deleteStudent/{admissionNumber}")
     public void deleteStudentByAdmissionNumber(@PathVariable String admissionNumber) {
            String url = "http://localhost:8082/api/Students/deleteStudent/{admissionNumber}";
            restTemplate.delete(url, admissionNumber);
      }

}
