package com.example.demo.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Giri_StudentData")
public class StudentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "student_name",nullable = false)
    private String name;
    @Column(name = "admission_number",nullable = false,unique = true)
    private String AdmissionNumber;

    private Date joiningDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private StudentClass studentClass;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public StudentData() {
    }

    public StudentData(Long id, String name, String admissionNumber, Date joiningDate, StudentClass studentClass, Section section) {
        this.id = id;
        this.name = name;
        AdmissionNumber = admissionNumber;
        this.joiningDate = joiningDate;
        this.studentClass = studentClass;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmissionNumber() {
        return AdmissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        AdmissionNumber = admissionNumber;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
