package com.student.studentdetails.studentservice;

import com.student.studentdetails.studentDTO.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveDetails(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(StudentDTO studentDTO, Long id);
}
