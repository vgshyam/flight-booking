package com.airway.service.impl;

import static com.airway.util.MessageUtil.FLIGHT_ALREADY_EXISTS;
import static com.airway.util.MessageUtil.TICKETS_FULL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airway.api.bean.FlightBean;
import com.airway.dao.FlightDao;
import com.airway.dao.UserDetailDao;
import com.airway.data.model.Flight;
import com.airway.data.model.UserDetail;
import com.airway.security.exception.GeneralException;
import com.airway.service.FlightService;

/**
 * @author shyam Jul 31, 2021 10:35:23 PM
 */

@Component
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	public void scheduleFlight(FlightBean flightBean) {

		Optional<Flight> flightOp = flightDao.flightByFlightNumber(flightBean.getFlightNumber());

		if (flightOp.isPresent()) {
			throw new GeneralException(FLIGHT_ALREADY_EXISTS);
		}
		flightDao.save(this.convertToModel(flightBean));
	}

	private Flight convertToModel(FlightBean bean) {
		Flight flight = new Flight();
		flight.setFlightNumber(bean.getFlightNumber());
		flight.setSeat(bean.getNoOfSeats());
		return flight;
	}

	@Override
	public Integer getAvailableSeats(String flightNumber) {

		Optional<Flight> flightOp = flightDao.flightByFlightNumber(flightNumber);

		flightOp.orElseThrow(GeneralException::new);

		return flightOp.get().getSeat();
	}

	@Override
	public void bookFlightSeat(FlightBean bean) {

		Optional<Flight> flightOp = flightDao.flightByFlightNumber(bean.getFlightNumber());

		// flight not found
		flightOp.orElseThrow(GeneralException::new);

		// add user detail
		Optional<UserDetail> userOp = userDetailDao.userByUserName(bean.getUserName());
		UserDetail userDetail;
		if (userOp.isPresent()) {
			userDetail = userOp.get();
		} else {
			userDetail = new UserDetail();
			userDetail.setUserName(bean.getUserName());
			userDetail = userDetailDao.save(userDetail);
		}

		Flight flight = flightOp.get();
		// no seat available
		if(flight.getSeat()==0)
			throw new GeneralException(TICKETS_FULL);
		// book seat
		flight.setSeat(flight.getSeat()-1);
		flight.getUsers().add(userDetail);
		flightDao.save(flight);
	}

}
