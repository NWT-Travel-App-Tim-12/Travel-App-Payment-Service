package com.app.travel.service.payment.exceptions;

import com.app.travel.service.payment.exceptions.exceptions.FieldNameBaseException;
import com.app.travel.service.payment.exceptions.exceptions.InvalidAdditionalDataCast;
import com.app.travel.service.payment.exceptions.exceptions.MissingParameterInRequest;
import com.app.travel.service.payment.exceptions.exceptions.ObjectDoesNotExistInDb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MissingParameterInRequest.class,
            ObjectDoesNotExistInDb.class,
            InvalidAdditionalDataCast.class
    })
    public ResponseEntity<Object> customErrors(FieldNameBaseException exception){
        Map<String, Object> responseBody = new HashMap<>();
        var statusCode = exception.getCode() != null ? exception.getCode() : HttpStatus.BAD_REQUEST;
        responseBody.put("timestamp", new Date());
        responseBody.put("status", statusCode.value());
        var errors = new HashMap<String, String>();
        errors.put(exception.getFieldName(), exception.getMessage());
        responseBody.put("errors", errors);
        return ResponseEntity
                .status(
                        statusCode
                )
                .body(responseBody);
    }
}