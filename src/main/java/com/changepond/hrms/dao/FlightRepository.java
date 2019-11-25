/**
 * 
 */
package com.changepond.hrms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.atrs.entities.FlightDetails;


/**
 * @author muthukumar.m
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Long> {
	
	public FlightDetails findByNumber(String flightNo);

}
