package com.aws.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.license.models.License;
import com.aws.license.repositories.LicenseRepository;

import com.aws.license.models.Person;
import com.aws.license.repositories.PersonRepository;

@Service
public class LicenseService {

private final LicenseRepository licenseRepository;
private final PersonRepository personRepository;
	
	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
	
	public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
	
	public List<Person> allPersonWithout() {
        return personRepository.findByLicenseIsNull();
    }
    

    public License createLicense(License b) {
        return licenseRepository.save(b);
    }

    public License findLicense(Long id) {
        Optional<License> license = licenseRepository.findById(id);
        if(license.isPresent()) {
            return license.get();
        } else {
            return null;
        }
    }
    
    public void deleteLicense(License license) {
    	licenseRepository.delete(license);
    }
	
}
