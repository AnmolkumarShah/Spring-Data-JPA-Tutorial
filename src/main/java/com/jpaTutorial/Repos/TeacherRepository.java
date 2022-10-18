package com.jpaTutorial.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaTutorial.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
