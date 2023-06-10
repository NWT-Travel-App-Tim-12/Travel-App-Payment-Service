package com.app.travel.service.payment.exceptions.exceptions;

public class MissingParameterInRequest extends FieldNameBaseException{
    public MissingParameterInRequest(String message, String fieldName) {
        super(message, fieldName);
    }
}
