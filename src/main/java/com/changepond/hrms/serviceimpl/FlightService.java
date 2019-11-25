package com.changepond.hrms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changepond.hrms.domain.FlightDetails;
import com.changepond.hrms.repository.FlightRepository;

/**
 * 
 * @author muthukumar.m
 *
 */

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	public FlightService() {
	}

	public List<FlightDetails> list(){
		List<FlightDetails> list = flightRepository.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			return new ArrayList<FlightDetails>();
		}
	}
	
	public FlightDetails save(FlightDetails flightDetails) {
		return flightRepository.saveAndFlush(flightDetails);
	}
	
	public FlightDetails update(FlightDetails flightDetails) {
		return flightRepository.save(flightDetails);
	}
	
	public FlightDetails find(Long id) {
		return flightRepository.getOne(id);
	}
	
	public FlightDetails findByNumber(String flightNo) {
		return flightRepository.findByNumber(flightNo);
	}
	
	public void delete(Long id) {
		flightRepository.deleteById(id);
	}
}
