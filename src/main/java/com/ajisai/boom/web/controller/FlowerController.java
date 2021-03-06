package com.ajisai.boom.web.controller;

import com.ajisai.boom.domain.Flower;
import com.ajisai.boom.exception.InvalidException;
import com.ajisai.boom.service.FlowerService;
import com.ajisai.boom.web.request.FlowerRequest;
import com.ajisai.boom.web.response.AjisaiListResponse;
import com.ajisai.boom.web.schema.ErrorInfo;
import com.ajisai.boom.web.schema.RequestError;
import com.ajisai.boom.web.response.RequestErrorInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @ApiOperation(value = "Find a flower with name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AjisaiListResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = RequestErrorInfo.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorInfo.class)
    })
    @RequestMapping(value = "/flowers", method = RequestMethod.GET)
    public AjisaiListResponse getFlowers(@RequestParam String name) throws InvalidException {

        FlowerRequest request = new FlowerRequest(name);
        List<RequestError> errors = request.validate();
        if (!errors.isEmpty()) {
            throw new InvalidException(errors);
        }

        Map<String, Flower> data = flowerService.getFlowers(request.getName());
        return new AjisaiListResponse(data);
    }
}
