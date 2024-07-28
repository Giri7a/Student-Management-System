package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name", nullable = false, unique = true)
    private String className;

    @OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL)
    private List<Section> sectionList;

    @OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentData> studentDataList;

    public StudentClass() {
    }

    public StudentClass(Long id, String className, List<Section> sectionList, List<StudentData> studentDataList) {
        this.id = id;
        this.className = className;
        this.sectionList = sectionList;
        this.studentDataList = studentDataList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<StudentData> getStudentDataList() {
        return studentDataList;
    }

    public void setStudentDataList(List<StudentData> studentDataList) {
        this.studentDataList = studentDataList;
    }
}
