package com.example.demo.Dto;

import java.util.List;

public class ClassDto {
    private Long id;
    private String className;
    private List<SectionDto> sectionDtoList;

    public ClassDto() {
    }

    public ClassDto(Long id, String className, List<SectionDto> sectionDtoList) {
        this.id = id;
        this.className = className;
        this.sectionDtoList = sectionDtoList;
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

    public List<SectionDto> getSectionDtoList() {
        return sectionDtoList;
    }

    public void setSectionDtoList(List<SectionDto> sectionDtoList) {
        this.sectionDtoList = sectionDtoList;
    }
}
