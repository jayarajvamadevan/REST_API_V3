package com.RESTAPI_CloudVendor_Example.RESTAPI_demo.repository;

import com.RESTAPI_CloudVendor_Example.RESTAPI_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>
{
    List<CloudVendor> findByVendorName(String vendorName);

}
