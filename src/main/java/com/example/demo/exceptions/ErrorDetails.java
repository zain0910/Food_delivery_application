package com.example.demo.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

	private LocalDateTime localDateTime;

	private String message;

	private String details;

//	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
//		super();
//		this.localDateTime = localDateTime;
//		this.message = message;
//		this.details = details;
//	}
//
//	public ErrorDetails() {
//		super();
//	}
//
//	public LocalDateTime getLocalDateTime() {
//		return localDateTime;
//	}
//
//	public void setLocalDateTime(LocalDateTime localDateTime) {
//		this.localDateTime = localDateTime;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getDetails() {
//		return details;
//	}
//
//	public void setDetails(String details) {
//		this.details = details;
//	}
//
//	@Override
//	public String toString() {
//		return "ErrorDetails [localDateTime=" + localDateTime + ", message=" + message + ", details=" + details + "]";
//	}

}
