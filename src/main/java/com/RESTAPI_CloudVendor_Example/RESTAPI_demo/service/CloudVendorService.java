package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.service;

import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor( CloudVendor cloudVendor);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public String updateCloudVendor(String cloudVendorId,CloudVendor cloudVendor);
    public String deleteCloudVendor( String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
    public List<CloudVendor> getByVendorName(String vendorName);
}
