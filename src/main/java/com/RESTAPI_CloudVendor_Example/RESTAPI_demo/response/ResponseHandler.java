package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> reponseBuilder
            (String message, HttpStatus httpStatus, Object responseObject)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", message);
        response.put("HttpStatus", httpStatus);
        response.put("Data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }
    public static ResponseEntity<Object> reponseBuilder
            (String message, HttpStatus httpStatus)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", message);
        response.put("HttpStatus", httpStatus);
        return new ResponseEntity<>(response, httpStatus);
    }

}
