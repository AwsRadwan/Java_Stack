package com.aws.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.license.models.Person;
import com.aws.license.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons() {
        return personRepository.findAll();
    }
    

    public Person createPerson(Person b) {
        return personRepository.save(b);
    }

    public Person findPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            return person.get();
        } else {
            return null;
        }
    }
    
    public void deletePerson(Person person) {
    	personRepository.delete(person);
    }
    

}
