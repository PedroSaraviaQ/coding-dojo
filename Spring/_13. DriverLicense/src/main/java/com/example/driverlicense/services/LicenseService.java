package com.example.driverlicense.services;

import com.example.driverlicense.models.License;
import com.example.driverlicense.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseService extends BaseService<License> {
    @Autowired LicenseRepository licenseRepository;

    public License save(License license) {
        license = licenseRepository.save(license);
        String number = String.format("%06d", license.getId());
        license.setNumber(number);
        return licenseRepository.save(license);
    }
}
