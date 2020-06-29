package com.fullstack.student.dal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fullstack.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
