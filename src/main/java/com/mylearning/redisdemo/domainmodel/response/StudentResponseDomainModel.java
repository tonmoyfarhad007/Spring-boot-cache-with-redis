package com.mylearning.redisdemo.domainmodel.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDomainModel {
    private Integer id;
    private String name;
    private String email;
    private Integer roll;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
