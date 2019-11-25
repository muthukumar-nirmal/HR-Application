/**
 * 
 */
package com.changepond.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.hrms.domain.Desgination;


/**
 * @author muthukumar.m
 *
 */
@Repository
public interface DesginationRepository extends JpaRepository<Desgination, Integer> {

	Desgination findByName(String name);
}
