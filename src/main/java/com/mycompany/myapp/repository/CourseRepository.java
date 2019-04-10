package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.dto.CourseDto;
import com.mycompany.myapp.domain.dto.CourseWithTNDto;
import com.mycompany.myapp.domain.dto.CourseWithSDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Cacheable;
import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    @Query("SELECT Course FROM course c  WHERE c.name = :courseName")
//    Course findCourseByCourseName(@Param("courseName") String courseName);

    @Query("SELECT new com.mycompany.myapp.domain.dto.CourseDto(c.courseName, c.courseLocation, c.courseContent, c.teacherId) from Course c")
    List<CourseDto> findAllCoursesDto();

    @Query("SELECT new com.mycompany.myapp.domain.dto.CourseWithTNDto(c.courseName, c.courseLocation, c.courseContent, u.login) from Course c join User u on c.teacherId = u.id")
    List<CourseWithTNDto> findAllCoursesDtoWithTeacherName();

    @Query(value="SELECT new com.mycompany.myapp.domain.Course(c.courseName,c.courseLocation, c.courseContent, c.teacherId)  FROM Course c  WHERE c.courseName =:courseName",nativeQuery = true)
    Optional<Course> findCourseByCourseName(@Param("courseName") String courseName);

    @Query("SELECT new com.mycompany.myapp.domain.dto.CourseWithSDto(c.courseName, c.courseLocation, c.courseContent)  FROM Course c  WHERE c.id in(SELECT uc.course from  UserCourse uc join User u on uc.user = u.id)")
    List<CourseWithSDto> findAllCoursesDtoWithStudentName();

}
