package com.escuela.sms.repository;

import org.springframework.data.repository.CrudRepository;

import com.escuela.sms.model.SchoolYear;

// TODO: Auto-generated Javadoc
/**
 * The Interface SchoolYearRepository.
 */
public interface SchoolYearRepository extends CrudRepository<SchoolYear, Integer> {
	
	/**
	 * Find first 5 by order by id desc.
	 *
	 * @return the iterable
	 */
	Iterable<SchoolYear> findFirst5ByOrderByIdDesc();
}
