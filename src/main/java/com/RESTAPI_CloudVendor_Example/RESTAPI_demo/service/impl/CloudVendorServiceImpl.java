package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.service.impl;

import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.exception.CloudVendorNotFoundException;
import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.model.CloudVendor;
import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.repository.CloudVendorRepository;
import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    //Create(POST)
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
       cloudVendorRepository.save(cloudVendor);
        return "Success";
    }
//Get by ID
    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException
                    ("Cloud vendor with Id: " + cloudVendorId + " not Present");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }
//Update By ID
    @Override
    public String updateCloudVendor(String cloudVendorId, CloudVendor cloudVendor) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException
                    ("Cloud vendor with Id: " + cloudVendorId + " not Present");
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }
//Delete By ID
    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException
                    ("Cloud vendor with Id: " + cloudVendorId + " not Present");
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }
//Get All Values Together
    @Override
    public List<CloudVendor> getAllCloudVendors() {
        if(cloudVendorRepository.findAll().isEmpty())
            throw new CloudVendorNotFoundException("Cloud vendor list is not Present");
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
