package com.ajisai.boom.web.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestError {
    private String fieldName;
    private String message;
}
