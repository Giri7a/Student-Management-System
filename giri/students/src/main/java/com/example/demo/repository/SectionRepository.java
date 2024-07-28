package com.example.demo.repository;

import com.example.demo.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
//The method returns a Section entity
public interface SectionRepository extends JpaRepository<Section,Long> {
    Section findBySectionNameAndStudentClassId(String section, Long id);
}
