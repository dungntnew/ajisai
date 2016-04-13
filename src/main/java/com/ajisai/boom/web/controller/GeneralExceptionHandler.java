package com.ajisai.boom.web.controller;

import com.ajisai.boom.exception.InvalidException;
import com.ajisai.boom.web.response.RequestErrorInfo;
import com.ajisai.boom.web.schema.ErrorInfo;
import com.ajisai.boom.web.schema.RequestError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@ControllerAdvice
@RestController
public class GeneralExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleException(UnsupportedOperationException e) {
        LOGGER.warn(e.getMessage());
        return createRequestErrorInfo(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleException(MethodArgumentNotValidException e) {
        LOGGER.warn(e.getMessage());
        return createRequestErrorInfo(e);
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleException(InvalidException e) {
        LOGGER.warn("Input is invalid.");
        return createRequestErrorInfo(e);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleException(MissingServletRequestParameterException e) {
        LOGGER.warn(e.getMessage());
        return createRequestErrorInfo(e);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorInfo handleException(Throwable t) {
        LOGGER.error(t.getMessage(), t);
        return createErrorInfo(t);
    }

    private ErrorInfo createErrorInfo(Throwable t) {
        return new ErrorInfo(t.getMessage());
    }

    private RequestErrorInfo createRequestErrorInfo(MissingServletRequestParameterException e) {
        List<RequestError> errors = newArrayList();
        String fieldName = e.getParameterName();
        String message = e.getMessage();
        errors.add(new RequestError(fieldName, message));
        return new RequestErrorInfo(e.getMessage(), errors);
    }

    private ErrorInfo createRequestErrorInfo(UnsupportedOperationException e) {
        return new ErrorInfo(e.getMessage());
    }

    private RequestErrorInfo createRequestErrorInfo(MethodArgumentNotValidException e) {
        List<RequestError> errors = e.getBindingResult().getAllErrors().stream()
                .map(oe -> new RequestError(oe.getObjectName(), oe.getDefaultMessage())).collect(Collectors.toList());
        return new RequestErrorInfo(e.getMessage(), errors);
    }

    private RequestErrorInfo createRequestErrorInfo(InvalidException e) {
        return new RequestErrorInfo(HttpStatus.BAD_REQUEST.name(), e.getErrors());
    }
}
