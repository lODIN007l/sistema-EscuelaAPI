package com.escuela.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.escuela.sms.model.Class;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClassRepository.
 */
public interface ClassRepository extends CrudRepository<Class, Integer> {
	
	/**
	 * Find by school year id.
	 *
	 * @param id the id
	 * @return the iterable
	 */
	Iterable<Class> findBySchoolYearId(Integer id);
	
	/**
	 * Find by name containing.
	 *
	 * @param name the name
	 * @return the iterable
	 */
	Iterable<Class> findByNameContaining(String name);
}
