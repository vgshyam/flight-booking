package com.airway.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airway.dao.FlightDao;
import com.airway.data.model.Flight;
import com.airway.data.repository.FlightRepository;

/**
 * @author shyam Jul 31, 2021 10:36:27 PM
 */

@Component
public class FlightDaoImpl implements FlightDao {

	@Autowired
	private FlightRepository flightRepo;

	@Override
	public Optional<Flight> flightByFlightNumber(String flightNumber) {
		return flightRepo.findByFlightNumberIgnoreCase(flightNumber);
	}

	@Override
	public void save(Flight flight) {
		flightRepo.save(flight);

	}

}
