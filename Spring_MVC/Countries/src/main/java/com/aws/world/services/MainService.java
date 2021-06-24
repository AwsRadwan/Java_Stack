package com.aws.world.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aws.world.repositories.CityRepository;
import com.aws.world.repositories.CountryRepository;
import com.aws.world.repositories.LangRepository;

@Service
public class MainService {
	private final CityRepository cityRepo;
	private final CountryRepository countryRepo;
	private final LangRepository langRepo;
	public MainService(CityRepository cityRepo, CountryRepository countryRepo, LangRepository langRepo) {
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.langRepo = langRepo;
	}
	
	public List<Object[]> findCSS(){
		return countryRepo.findCountriesSpeakSolvene();
	}
	public List<Object[]> findCBCC(){
		return countryRepo.findCountriesByCityCount();
	}
	public List<Object[]> findC3(){
		return countryRepo.findC3();
	}
	public List<Object[]> findC4(){
		return countryRepo.findC4();
	}
	public List<Object[]> findC5(){
		return countryRepo.findC5();
	}
	public List<Object[]> findC6(){
		return countryRepo.findC6();
	}
	public List<Object[]> findC7(){
		return countryRepo.findC7();
	}
	public List<Object[]> findC8(){
		return countryRepo.findC8();
	}

	
	

}
