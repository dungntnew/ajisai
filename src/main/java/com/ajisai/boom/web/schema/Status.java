package com.ajisai.boom.web.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    private Long execTime;

    private ErrorInfo error;

    private Boolean success;
}
