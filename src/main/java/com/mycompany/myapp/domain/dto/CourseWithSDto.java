package com.mycompany.myapp.domain.dto;
import lombok.*;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class CourseWithSDto {

        private String courseName;

        private String courseLocation;

        private String courseContent;

    }

