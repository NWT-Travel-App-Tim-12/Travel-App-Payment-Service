package com.app.travel.service.payment.exceptions.exceptions;

public class InvalidAdditionalDataCast extends FieldNameBaseException{
    public InvalidAdditionalDataCast(String message) {
        super(message, "additional_data");
    }
}
