package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.UserCourse;
import com.mycompany.myapp.domain.dto.CourseWithTNDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long>{

}
