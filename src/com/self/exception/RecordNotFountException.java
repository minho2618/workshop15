package com.self.exception;

public class RecordNotFountException extends Exception {
	public RecordNotFountException() {
	};

	public RecordNotFountException(String message) {
		super(message);
	}
}