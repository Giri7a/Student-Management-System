package com.example.demo.service.imp;

import com.example.demo.repository.SectionRepository;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.Dto.AllDto;
import com.example.demo.Entity.Section;
import com.example.demo.Entity.StudentClass;
import com.example.demo.Entity.StudentData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service // used to mark the class as a service provider
public class StudentServiceImp  {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired//enables dependency injection for Java classes
    private StudentRepository studentRepository;


    //Retrieves all StudentData entities from the database via studentRepository.findAll(),
    // converts each StudentData entity to AllDto using convertToDto, and returns a list of AllDto objects.
    public List<AllDto> getAllStudents() {
        List<StudentData> studentDataList = studentRepository.findAll();
        return studentDataList.stream() //a way to express and process collections of objects convert
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
   //Converts an AllDto object to StudentData using mapDtoToEntity and saves it using saveOrUpdateStudentData.
    public void createStudent(AllDto allDto) {
        StudentData studentData = mapDtoToEntity(allDto);
        saveOrUpdateStudentData(studentData);
    }

    //Updates an existing student by admission number. It fetches the student from the repository,
    // throws an exception if not found, maps the AllDto to the StudentData entity, and saves the updated entity.
    public void updateStudent(AllDto allDto) {  //id
        StudentData studentData = studentRepository.findByAdmissionNumber(allDto.getAdmissionNumber());
        if (studentData == null) {
            throw new EntityNotFoundException("Student with admission number " + allDto.getAdmissionNumber() + " not found");
        }
        mapDtoToEntity(allDto, studentData);
        saveOrUpdateStudentData(studentData);
    }

    //Deletes a student by admission number. It retrieves the student from the repository, deletes it if found, otherwise throws an exception.
    public void deleteStudent(String admissionNumber) {    //by admission number
        StudentData studentData = studentRepository.findByAdmissionNumber(admissionNumber);
        if (studentData != null) {
            studentRepository.delete(studentData);
        } else {
            throw new EntityNotFoundException("Student with admission number " + admissionNumber + " not found");
        }
    }
    //convertToDto: Converts a StudentData entity to AllDto.
    private AllDto convertToDto(StudentData studentData) {
        return new AllDto(
                studentData.getName(),
                studentData.getAdmissionNumber(),
                studentData.getStudentClass().getClassName(),
                studentData.getSection().getSectionName(),
                studentData.getJoiningDate()
        );
    }
    //mapDtoToEntity: Converts AllDto to StudentData entity.
    private StudentData mapDtoToEntity(AllDto dto) {
        StudentData studentData = new StudentData();
        studentData.setName(dto.getStudentName());
        studentData.setAdmissionNumber(dto.getAdmissionNumber());
        studentData.setJoiningDate(dto.getDateOfJoining());

        StudentClass studentClass = getOrCreateStudentClass(dto.getClassName());
        studentData.setStudentClass(studentClass);

        Section section = getOrCreateSection(dto.getSection(), studentClass);
        studentData.setSection(section);

        return studentData;
    }
    private void mapDtoToEntity(AllDto dto, StudentData studentData) {
        studentData.setName(dto.getStudentName());
        studentData.setAdmissionNumber(dto.getAdmissionNumber());
        studentData.setJoiningDate(dto.getDateOfJoining());

        StudentClass studentClass = getOrCreateStudentClass(dto.getClassName());
        studentData.setStudentClass(studentClass);

        Section section = getOrCreateSection(dto.getSection(), studentClass);
        studentData.setSection(section);
    }

    //getOrCreateStudentClass: Retrieves or creates a StudentClass entity based on class name.
    private StudentClass getOrCreateStudentClass(String className) {
        StudentClass studentClass = classRepository.findByClassName(className);
        if (studentClass == null) {
            studentClass = new StudentClass();
            studentClass.setClassName(className);
            classRepository.save(studentClass);
        }
        return studentClass;
    }

    //getOrCreateSection: Retrieves or creates a Section entity based on section name and associated StudentClass.
    private Section getOrCreateSection(String sectionName, StudentClass studentClass) {
        Section section = sectionRepository.findBySectionNameAndStudentClassId(sectionName, studentClass.getId());
        if (section == null) {
            section = new Section();
            section.setSectionName(sectionName);
            section.setStudentClass(studentClass);
            sectionRepository.save(section);
        }
        return section;
    }

    //saveOrUpdateStudentData: Saves or updates a StudentData entity in the repository.
    private void saveOrUpdateStudentData(StudentData studentData) {
        studentRepository.save(studentData);
    }

}






