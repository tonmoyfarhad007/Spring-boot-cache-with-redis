package com.mylearning.redisdemo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mylearning.redisdemo.domainmodel.mapper.student.StudentDomainEntityMapper;
import com.mylearning.redisdemo.domainmodel.usecase.StudentDomainModel;
import com.mylearning.redisdemo.entity.StudentEntity;
import com.mylearning.redisdemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDomainEntityMapper studentDomainEntityMapper;
    private final RedisService redisService;

    public StudentDomainModel addStudent(StudentDomainModel studentDomainModel) {

        StudentEntity studentEntity = studentDomainEntityMapper.domainModelToEntity(studentDomainModel);
        studentEntity.setCreatedAt(LocalDateTime.now());
        studentEntity = studentRepository.save(studentEntity);

        return studentDomainEntityMapper.entityToDomainModel(studentEntity);
    }

    public List<StudentDomainModel> getAllStudents() {

        List<StudentEntity> cacheData = redisService.getList("all_students",new TypeReference<List<StudentEntity>>() {});

        if (cacheData!=null){
            return studentDomainEntityMapper.entityToDomainModel(cacheData);
        }
        List<StudentEntity> studentEntities = studentRepository.findAll();
        redisService.setList("all_students",studentEntities, 300L);
        return studentDomainEntityMapper.entityToDomainModel(studentEntities);
    }
}
