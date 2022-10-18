package com.jpaTutorial.Repos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaTutorial.Entity.Course;
import com.jpaTutorial.Entity.Student;
import com.jpaTutorial.Entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository theCourseRepository;
	
	@Test
	public void getAllCourse() {
		List<Course> cl = theCourseRepository.findAll();
		cl.stream().forEach(c -> {
			System.out.println(c.getTitle());
			System.out.println(c.getCourseMaterial());
		});
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher t = new Teacher();
		t.setFirstName("Sunil");
		t.setLastName("kothare");
		
		Course c = new Course();
		c.setTitle("English");
		c.setTeacher(t);
		c.setCredit(5);
		
		theCourseRepository.save(c);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Student s = new Student();
		s.setFirstName("Suman");
		s.setLastName("Shah");
		s.setEmailId("suman@gmail.com");
		
		Teacher t = new Teacher();
		t.setFirstName("Rajesh");
		t.setLastName("Shah");
	
		
		Course c = new Course();
		c.setTitle("AI");
		c.setCredit(20);
		c.setTeacher(t);
		
		c.addStudent(s);
		
		theCourseRepository.save(c);
		
		
	}

}
