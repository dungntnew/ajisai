package com.ajisai.boom.web.response;

import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.web.schema.BaseResponse;
import com.ajisai.boom.web.schema.Status;

import java.util.Map;

public class AjisaiListResponse extends BaseResponse {

    public AjisaiListResponse(Map<String, Flower> list) {
        super();
        setBody(list);
        setStatus(new Status());
    }
}
