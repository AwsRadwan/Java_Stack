package com.aws.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.world.models.City;
import com.aws.world.models.Country;
import com.aws.world.models.Language;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	
	List<Country> findAll();

	@Query("SELECT d FROM Country d")
    List<Country> findAllCountries();
	
	@Query(value="SELECT countries.name, language, percentage FROM languages \r\n"
			+ "INNER JOIN countries ON languages.country_id = countries.id \r\n"
			+ "WHERE language = \"Slovene\""
			+ "ORDER BY percentage DESC; \r\n", nativeQuery=true)
    List<Object[]> findCountriesSpeakSolvene();
    
    @Query(value="SELECT countries.name AS country, COUNT(cities.id) AS number_cities\r\n"
    		+ "FROM countries\r\n"
    		+ "JOIN cities ON countries.code = cities.country_code\r\n"
    		+ "GROUP BY countries.code\r\n"
    		+ "ORDER BY COUNT(cities.id) desc; \r\n", nativeQuery=true)
    List<Object[]> findCountriesByCityCount();
    
    @Query(value="select cities.name, cities.population , country_id from cities \r\n"
    		+ "join countries on cities.country_id = countries.id\r\n"
    		+ " where countries.name ='mexico' and cities.population >500000; \r\n", nativeQuery=true)
    List<Object[]> findC3();
    
    @Query(value="SELECT countries.name, language ,percentage FROM languages\r\n"
    		+ "join countries on countries.id = country_id where percentage>89; \r\n", nativeQuery=true)
    List<Object[]> findC4();
    
    @Query(value="SELECT name, surface_area, population  FROM countries where surface_area<501 and population>100000;", nativeQuery=true)
    List<Object[]> findC5();
    
    @Query(value="SELECT countries.name, countries.government_form, countries.life_expectancy, capital  FROM countries \r\n"
    		+ "join cities on country_id = countries.id  "
    		+ "where capital>200 and life_expectancy>75 and government_form=\"Constitutional Monarchy, Federation\"", nativeQuery=true)
    List<Object[]> findC6();
    
    @Query(value="SELECT cities.name ,cities.country_code, cities.district ,cities.population from countries\r\n"
    		+ "join cities on country_id=countries.id where countries.code ='arg' and district='Buenos Aires' and cities.population>500000;", nativeQuery=true)
    List<Object[]> findC7();
    
    @Query(value="SELECT countries.region AS region, COUNT(countries.id) AS countries_number\r\n"
    		+ "FROM countries\r\n"
    		+ "GROUP BY countries.region\r\n"
    		+ "ORDER BY COUNT(countries.id) desc", nativeQuery=true)
    List<Object[]> findC8();
	
}