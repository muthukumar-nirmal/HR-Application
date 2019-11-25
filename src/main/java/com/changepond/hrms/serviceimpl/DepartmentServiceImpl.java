/**
 * 
 */
package com.changepond.hrms.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.Department;
import com.changepond.hrms.repository.DepartmentRepository;
import com.changepond.hrms.services.DepartmentService;

/**
 * @author muthukumar.m
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department create(Department department) {
		department.setCreatedAt(new Date());
		department.setUpdatedAt(new Date());
		return departmentRepository.save(department);
	}

	@Override
	public Department update(Department department) {
		return create(department);
	}

	@Override
	public Department findById(int id) {
		return departmentRepository.getOne(id);
	}

	@Override
	public Department findByName(String name) {
		return departmentRepository.findByDepartName(name);
	}

	@Override
	public void deleteById(int id) {
		departmentRepository.deleteById(id);
	}
}
