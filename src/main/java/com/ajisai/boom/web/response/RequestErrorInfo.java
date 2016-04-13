package com.ajisai.boom.web.response;

import com.ajisai.boom.web.schema.ErrorInfo;
import com.ajisai.boom.web.schema.RequestError;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RequestErrorInfo extends ErrorInfo {

    private List<RequestError> requestErrors;

    public RequestErrorInfo(String message, List<RequestError> requestErrors) {
        super(message);
        this.requestErrors = requestErrors;
    }
}