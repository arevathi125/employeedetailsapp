package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.empdao;
import com.example.demo.entity.empentity;

@Service
public class empservice {
@Autowired
private empdao dao;


//create method single user
public empentity createentity(empentity entity) {
	return dao.save(entity);
	
}
// create method Multiple user
public List<empentity> createentities(List<empentity> entities){
	return dao.saveAll(entities);
}

// Read method single user
public empentity getentityById(int id) {
	return dao.findById(id).orElse(null);
}

//Read method for multiple user
public List<empentity> getentities(){
	return dao.findAll();
}

//Update method
public empentity updateentity(empentity entity){
	empentity oldentity = null;
	Optional<empentity> optionalentity=dao.findById(entity.getId());
	if(optionalentity.isPresent()) {
		oldentity = optionalentity.get();
		oldentity.setDob(entity.getDob());
		oldentity.setDoj(entity.getDoj());
		oldentity.setName(entity.getName());
		oldentity.setAddress(entity.getAddress());
		oldentity.setSalary(entity.getSalary());
		oldentity.setPhoneNo(entity.getPhoneNo());
		dao.save(oldentity);
	}
	else { return new empentity();
}
	return oldentity;
}
public String deleteentityById(int id) {
	  dao.deleteById(id);
	  return " Employee details got deleted";
}
}