/**
 * 
 */
package com.changepond.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.hrms.domain.FlightDetails;


/**
 * @author muthukumar.m
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Long> {
	
	public FlightDetails findByNumber(String flightNo);

}
