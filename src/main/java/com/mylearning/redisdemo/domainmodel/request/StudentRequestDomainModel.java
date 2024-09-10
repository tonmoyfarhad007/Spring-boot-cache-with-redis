package com.mylearning.redisdemo.domainmodel.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDomainModel {

    private String name;
    private String email;
    private Integer roll;
}
