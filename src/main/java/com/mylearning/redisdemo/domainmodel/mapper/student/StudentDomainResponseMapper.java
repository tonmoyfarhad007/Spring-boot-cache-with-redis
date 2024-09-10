package com.mylearning.redisdemo.domainmodel.mapper.student;

import com.mylearning.redisdemo.domainmodel.mapper.DomainResponseMapper;
import com.mylearning.redisdemo.domainmodel.response.StudentResponseDomainModel;
import com.mylearning.redisdemo.domainmodel.usecase.StudentDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentDomainResponseMapper extends DomainResponseMapper<StudentDomainModel, StudentResponseDomainModel> {
}
