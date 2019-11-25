/**
 * 
 */
package com.changepond.hrms.services;

import java.util.List;

import com.changepond.hrms.domain.Department;


/**
 * @author muthukumar.m
 *
 */
public interface DepartmentService {

	public List<Department> getAll();

	public Department create(Department department);

	public Department update(Department department);

	public Department findById(int id);

	public Department findByName(String name);

	public void deleteById(int id);

}
