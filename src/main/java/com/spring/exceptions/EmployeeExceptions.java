package com.spring.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.serviceImpl.EmployeeServiceImpl;

public class EmployeeExceptions {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeExceptions.class);

	@ExceptionHandler(FailedToExecuteQueryException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<?> handleFailedToExecuteQueryException(FailedToExecuteQueryException ex,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOG.error("Error Message : {}", ex.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InsufficientDataException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<?> handleInsufficientDataException(InsufficientDataException ex, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOG.error("Error Message : {}", ex.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException ex, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOG.error("Error Message : {}", ex.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
