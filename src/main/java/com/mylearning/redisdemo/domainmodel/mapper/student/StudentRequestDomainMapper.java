package com.mylearning.redisdemo.domainmodel.mapper.student;

import com.mylearning.redisdemo.domainmodel.mapper.DomainRequestMapper;
import com.mylearning.redisdemo.domainmodel.request.StudentRequestDomainModel;
import com.mylearning.redisdemo.domainmodel.usecase.StudentDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentRequestDomainMapper extends DomainRequestMapper<StudentDomainModel, StudentRequestDomainModel> {
}
