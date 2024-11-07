package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.controller;

import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.model.CloudVendor;
import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.response.ResponseHandler;
import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.service.CloudVendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v3/cloud_vendor")
public class CloudVendorController {
    private static final Logger logInfo = LoggerFactory.getLogger(CloudVendorController.class);
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    //Get Individual vendor by ID
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        logInfo.info("Employee Info Logging enabled for: {}", vendorId);
        logInfo.debug("Employee Debug Logging enabled for: {}", vendorId);
      return ResponseHandler.reponseBuilder
              ("Requested Details for Vendor Id: "+vendorId+ " is given", HttpStatus.OK,
                      cloudVendorService.getCloudVendor(vendorId));
    }
    //Get All Vendors
    @GetMapping("")
    public ResponseEntity<Object> getAllCloudVendorDetails( )
    {
        logInfo.info("Employee Info Logging enabled for All ");
        logInfo.debug("Employee Debug Logging enabled for All ");
        return ResponseHandler.reponseBuilder("Requested complete Vendor Details are given",
                HttpStatus.OK, cloudVendorService.getAllCloudVendors());
    }
    //Creat/POST Vendor
    @PostMapping("")
    public ResponseEntity<Object> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseHandler.reponseBuilder("CloudVendor Created Successfully",HttpStatus.OK);
    }
    //Update Vendor
    @PutMapping("{vendorId}")
    public ResponseEntity<Object>  updateCloudVendorDetails(@PathVariable("vendorId") String vendorId,
                                                            @RequestBody CloudVendor cloudVendor )
    {
        cloudVendorService.updateCloudVendor(vendorId,cloudVendor);
        return ResponseHandler.reponseBuilder("CloudVendor  Successfully Updated Id: "+vendorId,
                HttpStatus.OK);
    }
    //DELETE Vendor
    @DeleteMapping("{vendorId}")
    public ResponseEntity<Object>  deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return ResponseHandler.reponseBuilder("CloudVendor Successfully Deleted Id: "+vendorId,
                HttpStatus.OK);
    }

}
