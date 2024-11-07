package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.exception;

public class CloudVendorNotFoundException extends RuntimeException {
    public CloudVendorNotFoundException(String message) {
        super(message);
    }
    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
