/**
 * 
 */
package com.changepond.hrms.services;

import java.util.List;

import com.changepond.hrms.domain.Desgination;


/**
 * @author muthukumar.m
 *
 */
public interface DesginationService {

	public List<Desgination> getAll();

	public Desgination create(Desgination desgination);

	public Desgination update(Desgination desgination);

	public Desgination findById(int id);

	public Desgination findByName(String name);

	public void deleteById(int id);
}
