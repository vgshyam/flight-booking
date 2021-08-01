package com.airway.dao;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.airway.data.model.Flight;

/**
 * @author shyam Jul 31, 2021 10:36:02 PM
 */

@Service
public interface FlightDao {

	/**
	 * @param flightNumber
	 */
	Optional<Flight> flightByFlightNumber(String flightNumber);

	/**
	 * @param convertToModel
	 */
	void save(Flight convertToModel);

}
