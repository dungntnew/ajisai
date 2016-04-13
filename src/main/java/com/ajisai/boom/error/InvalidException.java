package com.ajisai.boom.error;

import com.ajisai.boom.web.response.RequestError;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@ToString(callSuper = true)
@AllArgsConstructor
public class InvalidException extends Exception {

    private List<RequestError> errors;

}
