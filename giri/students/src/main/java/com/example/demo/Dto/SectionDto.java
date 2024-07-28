package com.example.demo.Dto;


import java.util.List;

public class SectionDto {
    private Long id;
    private String sectionName;
    private ClassDto classDto;
    private List<StudentDto> studentDtoList;
    public SectionDto() {
    }
    public SectionDto(Long id, String sectionName, ClassDto classDto, List<StudentDto> studentDtoList) {
        this.id = id;
        this.sectionName = sectionName;
        this.classDto = classDto;
        this.studentDtoList = studentDtoList;
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

    public ClassDto getStudentClassDto() {
        return classDto;
    }

    public void setStudentClassDto(ClassDto classDto) {
        this.classDto = classDto;
    }

    public List<StudentDto> getStudentDataDtoList() {
        return studentDtoList;
    }

    public void setStudentDataDtoList(List<StudentDto> studentDtoList) {
        this.studentDtoList = studentDtoList;
    }
}
