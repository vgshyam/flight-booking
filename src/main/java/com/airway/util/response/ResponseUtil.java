package com.airway.util.response;

import org.springframework.http.ResponseEntity;

import com.airway.util.response.Response.ResponseBuilder;

/**
 * Created by Shyam Jul 30, 2021 10:38:48 PM
 */

public class ResponseUtil {

	public static ResponseEntity<?> success() {
		ResponseBuilder<String> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.Success);
		return ResponseEntity.ok().body(builder.build());
	}

	public static ResponseEntity<?> success(Integer count) {
		ResponseBuilder<String> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.Success).count(count);
		return ResponseEntity.ok().body(builder.build());
	}

	
	public static ResponseEntity<?> failure(String message, Integer statusCode) {
		ResponseBuilder<Object> builder = new ResponseBuilder<>();
		builder.status(ResponseStatus.Failure).message(message);
		return ResponseEntity.ok().body(builder.build());
	}
}
