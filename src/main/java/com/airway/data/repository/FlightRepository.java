package com.airway.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airway.data.model.Flight;

/**
 * Created by Shyam Jul 8, 2021 11:29:01 AM
 */

public interface FlightRepository extends JpaRepository<Flight, Long> {

	/**
	 * @param flightNumber
	 */
	Optional<Flight> findByFlightNumberIgnoreCase(String flightNumber);

}
