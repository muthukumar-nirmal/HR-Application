/**
 * 
 */
package com.changepond.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.hrms.domain.Department;


/**
 * @author muthukumar.m
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByDepartName(String name);
}
