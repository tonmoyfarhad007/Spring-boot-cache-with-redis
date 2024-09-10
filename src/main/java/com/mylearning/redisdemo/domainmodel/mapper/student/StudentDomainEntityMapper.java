package com.mylearning.redisdemo.domainmodel.mapper.student;

import com.mylearning.redisdemo.domainmodel.mapper.DomainEntityMapper;
import com.mylearning.redisdemo.domainmodel.usecase.StudentDomainModel;
import com.mylearning.redisdemo.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentDomainEntityMapper extends DomainEntityMapper<StudentDomainModel, StudentEntity> {
}
