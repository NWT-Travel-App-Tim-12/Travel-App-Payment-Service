package com.app.travel.service.payment.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectDoesNotExistInDb extends FieldNameBaseException{
    public ObjectDoesNotExistInDb(String message, String className) {
        super(message, className, HttpStatus.NOT_FOUND);
    }
}
