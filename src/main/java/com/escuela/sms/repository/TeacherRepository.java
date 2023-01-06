package com.escuela.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.escuela.sms.model.Teacher;

/**
 * The Interface TeacherRepository.
 */
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
