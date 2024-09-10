package com.mylearning.redisdemo.repository;

import com.mylearning.redisdemo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
