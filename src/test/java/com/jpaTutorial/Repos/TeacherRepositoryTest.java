package com.jpaTutorial.Repos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaTutorial.Entity.Course;
import com.jpaTutorial.Entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	TeacherRepository theTeacherRepository;
	
	@Autowired
	CourseRepository theCourseRepository;

	@Test
	public void saveTeacher() {
		
		Course c1 = new Course();
		c1.setTitle("DBMS");
		c1.setCredit(10);
		
		Teacher theTeacher = new Teacher();
		theTeacher.setFirstName("Ram");
		theTeacher.setLastName("Samdekar");
//		theTeacher.setCourses(List.of(c1));
		
		theTeacherRepository.save(theTeacher);
		
	}

}
