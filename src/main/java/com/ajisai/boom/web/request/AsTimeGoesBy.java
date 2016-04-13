package com.ajisai.boom.web.request;

import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.web.response.RequestError;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AsTimeGoesBy extends FlowerRequest {

    private String startDate;

    public AsTimeGoesBy(String name, String startDate) {
        super(name);
        this.startDate = startDate;
    }

    @Override
    public List<RequestError> validate() {
        List<RequestError> errors = super.validate();
        if (StringUtils.isEmpty(startDate)) {
            errors.add(new RequestError(startDate, "startDate is required"));
        } else {
            try {
                LocalDate.parse(startDate, Flower.DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                errors.add(new RequestError(startDate, "startDate is invalid"));
            }
        }
        return errors;
    }
}
