package com.jpaTutorial.Repos;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpaTutorial.Entity.Guardian;
import com.jpaTutorial.Entity.Student;

@SpringBootTest
// @DataJpaTest // it will not impact database and test
class StudentRepositoryTest {

	@Autowired
	StudentRepository theStudentRepository;

	@Test
	public void saveStudent() {
		Student theStudent = new  Student(); 
			theStudent.setEmailId("anmol@gmail.com");
			theStudent.setFirstName("Anmol");
			theStudent.setLastName("Shah");
			
//			theStudent.setGuardianEmail("ram@gmail.com");
//			theStudent.setGuardianName("Ram");
//			theStudent.setGuardianMobile("1212121212");			
		
		theStudentRepository.save(theStudent);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = theStudentRepository.findAll();
		System.out.println(studentList);
	}

	@Test
	public void saveStudentWithGuardian() {
		Student theStudent = new Student();
		
		theStudent.setEmailId("saloni@gmail.com");
		theStudent.setFirstName("Saloni");
		theStudent.setLastName("Shah");
		
		Guardian theGuardian = new Guardian();
		theGuardian.setGuardianEmail("ram@gmail.com");
		theGuardian.setGuardianName("Ram");
		theGuardian.setGuardianMobile("1212121212");	
		
		theStudent.setGuardian(theGuardian);
		
		theStudentRepository.save(theStudent);
		
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> sl = theStudentRepository.findByfirstName("Anmol");
		sl.stream().forEach(System.out::println);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> sl = theStudentRepository.findByfirstNameContaining("l");
		sl.stream().forEach(System.out::println);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> sl = theStudentRepository.findByGuardianName("ram");
		sl.stream().forEach(System.out::println);
	}
	
	// more at - https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#jpa.query-methods.query-creation
	
	
	// findByFirstNameAndLastName(String firstName, String lastName)
	// findByFirstNameOrLastName(String firstName, String lastName)
	
	@Test
	public void printStudentByEmail() {
		List<Student> sl = theStudentRepository.getStudentByEmail("anmol@gmail.com");
		sl.stream().forEach(System.out::println);
	}
	
	@Test
	public void printFirstName() {
		String name = theStudentRepository.getStudentFirstNameStudentByEmailJPQL("saloni@gmail.com");
		System.out.println(name);
	}
	
	@Test
	public void printStudentNative() {
		List<Student> sl = theStudentRepository.getStudentNative("saloni@gmail.com");
		sl.stream().forEach(System.out::println);
	}
	
	
	@Test
	public void updateStudentNameByEmailId() {
		int a = theStudentRepository.updateStudentFirstNameByEmailId("Saloni Shah", "saloni@gmail.com");
	}
	
	
	
}
