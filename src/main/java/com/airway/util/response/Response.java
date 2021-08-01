package com.airway.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author shyam Jul 31, 2021 10:38:12 PM
 */

@JsonInclude(value = Include.NON_NULL)
public class Response<T> {

	private ResponseStatus status;
	private Integer count;
	private Integer seatNumber;
	private String message;

	/**
	 * Default constructor
	 */
	public Response() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param status
	 * @param statusCode
	 * @param type
	 * @param data
	 * @param message
	 */
	public Response(ResponseStatus status, String message,Integer count, Integer seatNumber) {
		this.status = status;
		this.message = message;
		this.count=count;
		this.seatNumber=seatNumber;
	}

	/**
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the seatNumber
	 */
	public Integer getSeatNumber() {
		return seatNumber;
	}

	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public static class ResponseBuilder<S> {
		private ResponseStatus status;
		private String message;
		private Integer count;
		private Integer seatNumber;

		public ResponseBuilder<S> status(ResponseStatus status) {
			this.status = status;
			return this;
		}

		public ResponseBuilder<S> message(String message) {
			this.message = message;
			return this;
		}

		public ResponseBuilder<S> count(Integer count) {
			this.count = count;
			return this;
		}

		public ResponseBuilder<S> seatNumber(Integer seatNumber) {
			this.seatNumber = seatNumber;
			return this;
		}

		public Response<S> build() {
			return new Response<>(this.status, this.message, this.count, this.seatNumber);
		}
	}
}
