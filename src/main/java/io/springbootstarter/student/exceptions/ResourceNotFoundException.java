package io.springbootstarter.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student does not exist")
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
    }
}
