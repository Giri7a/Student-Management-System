package com.example.demo.controller;

import com.example.demo.Dto.AllDto;
import com.example.demo.service.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // rest body
@RequestMapping("/api/Students")
public class StudentController {
    @Autowired
    private StudentServiceImp studentServiceImp;

    @PostMapping("/addStudent")
    public void createClassSectionStudent(@RequestBody AllDto allDto){
        studentServiceImp.createStudent(allDto);
    }
@GetMapping("/AllStudents")
    public List<AllDto> getAllStudents(){

        return studentServiceImp.getAllStudents();
}
@PutMapping("/updateStudent")//Admission
    private void updateStudentById(@RequestBody AllDto allDto){
        studentServiceImp.updateStudent(allDto);
}
    @DeleteMapping("/deleteStudent/{admissionNumber}")//AdmissionNumber
    public void deleteStudentByAdmissionNumber(@PathVariable String admissionNumber) {
        studentServiceImp.deleteStudent(admissionNumber);
    }
}
