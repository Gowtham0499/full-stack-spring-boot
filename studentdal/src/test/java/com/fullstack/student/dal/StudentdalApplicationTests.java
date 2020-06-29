package com.fullstack.student.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack.student.dal.entities.Student;
import com.fullstack.student.dal.repositories.StudentRepository;

@SpringBootTest
class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("John");
		student.setCourse("Java Web Services");
		student.setFee(800d);
		studentRepository.save(student);
	}

	@Test
	public void testFindStudentById() {
		Student student = studentRepository.findById(1l).get();
		System.out.println(student);
	}

	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findById(1l).get();
		student.setFee(700d);
		studentRepository.save(student);
	}

	@Test
	public void testDeleteStudent() {
		studentRepository.deleteById(1l);
	}

}
