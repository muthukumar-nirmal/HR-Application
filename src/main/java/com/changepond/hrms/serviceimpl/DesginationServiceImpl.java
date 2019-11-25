/**
 * 
 */
package com.changepond.hrms.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.Desgination;
import com.changepond.hrms.repository.DesginationRepository;
import com.changepond.hrms.services.DesginationService;

/**
 * @author muthukumar.m
 *
 */
@Service
public class DesginationServiceImpl implements DesginationService {

	@Autowired
	private DesginationRepository desginationRepository;

	@Override
	public List<Desgination> getAll() {
		return desginationRepository.findAll();
	}

	@Override
	public Desgination create(Desgination desgination) {
		desgination.setCreatedAt(new Date());
		desgination.setUpdatedAt(new Date());
		return desginationRepository.save(desgination);
	}

	@Override
	public Desgination update(Desgination desgination) {
		return create(desgination);
	}

	@Override
	public Desgination findById(int id) {
		return desginationRepository.getOne(id);
	}

	@Override
	public Desgination findByName(String name) {
		return desginationRepository.findByName(name);
	}

	@Override
	public void deleteById(int id) {
		desginationRepository.deleteById(id);
	}
}
