package com.student.studentdetails.controller;

import com.student.studentdetails.studentDTO.StudentDTO;
import com.student.studentdetails.studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
    studentDTO = studentService.saveDetails(studentDTO);
    ResponseEntity<StudentDTO> studentDTOResponseEntity = new ResponseEntity<>(studentDTO, HttpStatus.OK);
    return studentDTOResponseEntity;
    }

    @GetMapping("/studentslist")
    public ResponseEntity<List<StudentDTO>> getStudentsList(){
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        ResponseEntity<List<StudentDTO>> responseEntity = new ResponseEntity<>(studentDTOList, HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        studentDTO= studentService.updateStudent(studentDTO,id);
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(studentDTO, HttpStatus.ACCEPTED);
        return  responseEntity;
    }
}
