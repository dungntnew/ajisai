package com.ajisai.boom.web.request;

import com.ajisai.boom.web.response.RequestError;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class FlowerRequest {
    private String name;

    public List<RequestError> validate() {
        List<RequestError> errors = Collections.emptyList();
        if (StringUtils.isEmpty(name)) {
            errors.add(new RequestError(name, "flower name is required"));
        }
        return errors;
    }
}
