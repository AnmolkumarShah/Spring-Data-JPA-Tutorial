package com.jpaTutorial.Repos;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaTutorial.Entity.Course;
import com.jpaTutorial.Entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	CourseMaterialRepository theCourseMaterialRepository;

	@Test
	public void saveCourseMaterial() {
		
		Course theCourse = new Course();
		theCourse.setTitle("DSA");
		theCourse.setCredit(6);
		
		CourseMaterial theCourseMaterial = new CourseMaterial();
		theCourseMaterial.setUrl("www.google.com");
		theCourseMaterial.setCourse(theCourse);
		
		theCourseMaterialRepository.save(theCourseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> ml = theCourseMaterialRepository.findAll();
		ml.stream().forEach(System.out::println);
	}

}
