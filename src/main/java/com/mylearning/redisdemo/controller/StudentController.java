package com.mylearning.redisdemo.controller;


import com.mylearning.redisdemo.domainmodel.mapper.student.StudentDomainResponseMapper;
import com.mylearning.redisdemo.domainmodel.mapper.student.StudentRequestDomainMapper;
import com.mylearning.redisdemo.domainmodel.request.StudentRequestDomainModel;
import com.mylearning.redisdemo.domainmodel.response.StudentResponseDomainModel;
import com.mylearning.redisdemo.domainmodel.usecase.StudentDomainModel;
import com.mylearning.redisdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRequestDomainMapper studentRequestDomainMapper;
    private final StudentDomainResponseMapper studentDomainResponseMapper;


    @PostMapping("student")
    public ResponseEntity<StudentResponseDomainModel> addStudent(@RequestBody StudentRequestDomainModel studentRequestDomainModel) {
        StudentDomainModel studentDomainModel = studentRequestDomainMapper.requestModelToDomainModel(studentRequestDomainModel);
        studentDomainModel = studentService.addStudent(studentDomainModel);
        StudentResponseDomainModel studentResponseDomainModel = studentDomainResponseMapper.domainModelToResponseModel(studentDomainModel);
//        return ResponseEntity.ok(studentResponseDomainModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponseDomainModel);
    }

    @GetMapping("student")
    public ResponseEntity<List<StudentResponseDomainModel>> getStudents() {

        List<StudentDomainModel> studentDomainModels = studentService.getAllStudents();
        List<StudentResponseDomainModel> studentResponseDomainModels = studentDomainResponseMapper.domainModelToResponseModel(studentDomainModels);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDomainModels);


    }


}
