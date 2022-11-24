package com.student.studentdetails.studentservice;

import com.student.studentdetails.converter.Converter;
import com.student.studentdetails.entity.StudentEntity;
import com.student.studentdetails.repository.StudentRepository;
import com.student.studentdetails.studentDTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Converter converter;

    @Override
    public StudentDTO saveDetails(StudentDTO studentDTO) {
        StudentEntity studentEntity = converter.studentDTOtoEntity(studentDTO);
        studentRepository.save(studentEntity);
        studentDTO = converter.studentEntitytoDTO(studentEntity);
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> studentEntityList = (List<StudentEntity>)studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity studentEntity:studentEntityList
             ) {
            StudentDTO studentDTO = converter.studentEntitytoDTO(studentEntity);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, Long id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            studentEntity.setFirstName(studentDTO.getFirstName());
            studentEntity.setLastName(studentDTO.getLastName());
            studentEntity.setEmail(studentDTO.getEmail());
            studentRepository.save(studentEntity);
            studentDTO = converter.studentEntitytoDTO(studentEntity);

        }
        return studentDTO;
    }
}
