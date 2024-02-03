package com.jsp.usera2boot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserIdNotFoundException extends RuntimeException {
private String message;

public UserIdNotFoundException(String message) {
	super();
	this.message = message;
}

}
