package com.airway.service;

import org.springframework.stereotype.Service;

import com.airway.api.bean.FlightBean;

/**
 * @author shyam Jul 31, 2021 9:34:48 PM
 */

@Service
public interface FlightService {

	/**
	 * @param flightBean
	 * @return
	 */
	void scheduleFlight(FlightBean flightBean);

	/**
	 * @param flightNumber
	 * @return {@link Integer}
	 */
	Integer getAvailableSeats(String flightNumber);

	/**
	 * @param bean
	 */
	void bookFlightSeat(FlightBean bean);

}
