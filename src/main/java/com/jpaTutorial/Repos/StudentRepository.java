package com.jpaTutorial.Repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpaTutorial.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	There are some JPA methods
	
//	findBy[firstName] - firstName is field in student class, findBy should be same in case
	
	public List<Student> findByfirstName(String firstName);
	
	List<Student> findByfirstNameContaining(String str);	
	
	List<Student> findByLastNameNotNull();	
	
	// guardian field -> Guardian and in guardian class -> name field;
	
	List<Student> findByGuardianName (String guardianName);	
	
//	--------------------------------------------------------------------------
	
//	Query Annotation	
	
	
//	JPQL //  use attributes name as from class not from the relation table
	// ?1 denotes the first parameter
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameStudentByEmailJPQL(String email);
	
// Native query
	
	@Query(value = "select * from tbl_student where email_address = ?1",nativeQuery = true)
	List<Student> getStudentNative(String email);
	
//	Named Parameter
	@Query("from Student where emailId = :email")
	List<Student> getStudentByEmail(@Param("email") String email);
	
//	-------------------------------------------------------------------------------

	// update in table
	
	// since we are modifying record, @Modifying annotation is used
	// To make this a transaction we are using @Transactional annotation
	// similarly we can make mark transaction at class and method level
	// in service lavel to include multiple methods in transaction we can mark it as transaction
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set first_name = :name where email_address = :email",
			nativeQuery = true
	)
	int updateStudentFirstNameByEmailId(@Param("name") String firstName,@Param("email") String emailId);
	
}
