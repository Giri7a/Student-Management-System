package com.example.demo.repository;

import com.example.demo.Entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
//The method returns a class entity
public interface ClassRepository extends JpaRepository<StudentClass,Long> {
    StudentClass findByClassName(String className);
}
