package com.airway.api;

import static com.airway.util.Route.BASE_URL;
import static com.airway.util.Route.BOOK_SEAT;
import static com.airway.util.Route.GET_AVAILABLE_SEATS;
import static com.airway.util.Route.SCHEDULE_FLIGHT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airway.api.bean.FlightBean;
import com.airway.service.FlightService;
import com.airway.util.response.ResponseUtil;

/**
 * Created by Shyam Jul 31, 2021 10:36:54 PM
 */

@RestController()
@RequestMapping(value = BASE_URL)
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping(value = SCHEDULE_FLIGHT)
	public ResponseEntity<?> scheduleFlightDetail(@RequestBody FlightBean flightBean) {

		flightService.scheduleFlight(flightBean);
		return ResponseUtil.success();
	}

	@GetMapping(value = GET_AVAILABLE_SEATS)
	public ResponseEntity<?> checkSeatAvailability(@RequestParam(name = "flightNumber") String flightNumber) {

		return ResponseUtil.success(flightService.getAvailableSeats(flightNumber));
	}

	@PostMapping(value = BOOK_SEAT)
	public ResponseEntity<?> bookSeat(@RequestBody FlightBean bean) {
		
		flightService.bookFlightSeat(bean);
		return ResponseUtil.success();
	}

}
