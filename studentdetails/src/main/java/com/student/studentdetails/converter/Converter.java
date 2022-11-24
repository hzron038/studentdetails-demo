package com.student.studentdetails.converter;

import com.student.studentdetails.entity.StudentEntity;
import com.student.studentdetails.studentDTO.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public StudentEntity studentDTOtoEntity(StudentDTO studentDTO){
        var studentEntity = new StudentEntity();
        studentEntity.setId(studentDTO.getId());
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        return studentEntity;
    }
    public StudentDTO studentEntitytoDTO (StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastName(studentEntity.getLastName());
        studentDTO.setEmail(studentEntity.getEmail());
        return studentDTO;
    }
}
