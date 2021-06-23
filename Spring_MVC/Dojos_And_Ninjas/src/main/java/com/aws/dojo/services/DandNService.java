package com.aws.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.dojo.models.Dojo;
import com.aws.dojo.models.Ninja;
import com.aws.dojo.repositories.DojoRepository;
import com.aws.dojo.repositories.NinjaRepository;

@Service
public class DandNService {
	
	private final DojoRepository drep;
	private final NinjaRepository nrep;
	
	public DandNService( DojoRepository drep, NinjaRepository nrep) {
		this.drep = drep;
		this.nrep = nrep;
	}
	
	public List<Dojo> allDojos() {
        return drep.findAll();
    }
	public List<Ninja> allNinjas() {
        return nrep.findAll();
    }
    

    public Dojo createDojo(Dojo b) {
        return drep.save(b);
    }
    public Ninja createNinja(Ninja b) {
        return nrep.save(b);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = drep.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = nrep.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
    public void deleteNinja(Ninja n) {
    	nrep.delete(n);
    }
    public void deleteDojo(Dojo n) {
    	drep.delete(n);
    }
    public long numOfNinjas(Dojo dojo) {
    	long x = nrep.countByDojo(dojo);
    	return x;
    }
	
}
