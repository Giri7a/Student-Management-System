package com.example.demo.Dto;



import java.util.Date;

public class StudentDto {
    private Long id;
    private String name;
    private String AdmissionNumber;
    private Date joiningDate;
    private ClassDto classDto;
    private SectionDto sectionDto;
    public StudentDto() {
    }
    public StudentDto(Long id, String name, String admissionNumber, Date joiningDate, ClassDto classDto, SectionDto sectionDto) {
        this.id = id;
        this.name = name;
        AdmissionNumber = admissionNumber;
        this.joiningDate = joiningDate;
        this.classDto = classDto;
        this.sectionDto = sectionDto;
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

    public ClassDto getStudentClassDto() {
        return classDto;
    }

    public void setStudentClassDto(ClassDto classDto) {
        this.classDto = classDto;
    }

    public SectionDto getSectionDto() {
        return sectionDto;
    }

    public void setSectionDto(SectionDto sectionDto) {
        this.sectionDto = sectionDto;
    }
}
