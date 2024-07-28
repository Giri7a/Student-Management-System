package com.example.demo.repository;

import com.example.demo.Entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//The StudentRepository interface extends JpaRepository to inherit basic CRUD operations and adds a custom query method findByAdmissionNumber
public interface StudentRepository extends JpaRepository<StudentData,Long> {
    @Query("SELECT g FROM StudentData g WHERE g.AdmissionNumber = :admissionNumber")
    StudentData findByAdmissionNumber(@Param("admissionNumber") String admissionNumber);

}
