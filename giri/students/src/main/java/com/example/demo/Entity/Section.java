package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class    Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long id;

    @Column(name = "section_name", nullable = false)
    private String sectionName;

    @ManyToOne
    @JoinColumn(name = "StudentClass_id")
    private StudentClass studentClass;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<StudentData> studentDataList;

    public Section() {
    }

    public Section(Long id, String sectionName, StudentClass studentClass, List<StudentData> studentDataList) {
        this.id = id;
        this.sectionName = sectionName;
        this.studentClass = studentClass;
        this.studentDataList = studentDataList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<StudentData> getStudentDataList() {
        return studentDataList;
    }

    public void setStudentDataList(List<StudentData> studentDataList) {
        this.studentDataList = studentDataList;
    }
}
