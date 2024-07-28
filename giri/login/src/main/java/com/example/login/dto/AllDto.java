package com.example.login.dto;

import java.util.Date;

public class AllDto {

        private String studentName;
        private String admissionNumber;
        private String className;
        private String section;
        private Date dateOfJoining;

    public AllDto() {
    }

    public AllDto(String studentName, String admissionNumber, String className, String section, Date dateOfJoining) {
        this.studentName = studentName;
        this.admissionNumber = admissionNumber;
        this.className = className;
        this.section = section;
        this.dateOfJoining = dateOfJoining;
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String studentName) {

        this.studentName = studentName;
    }

    public String getAdmissionNumber() {

        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getClassName() {

        return className;
    }

    public void setClassName(String className) {

        this.className = className;
    }

    public String getSection() {

        return section;
    }

    public void setSection(String section) {

        this.section = section;
    }

    public Date getDateOfJoining() {

        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {

        this.dateOfJoining = dateOfJoining;
    }
}
