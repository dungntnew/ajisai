package com.ajisai.boom.exception;

import com.ajisai.boom.web.response.RequestError;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuppressWarnings("serial")
public class InvalidException extends Exception {

    private List<RequestError> errors;

}
