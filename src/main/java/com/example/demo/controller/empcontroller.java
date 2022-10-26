package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.empentity;
import com.example.demo.service.empservice;

@RestController
public class empcontroller {
@Autowired
private empservice service;

// create method for adding single employee
@PostMapping("/addemployee")
public empentity addemployee(@RequestBody empentity entity) {
	return service.createentity(entity);
}

// create method for adding multiple employees
@PostMapping("/addemployees")
public List<empentity> addemployees(@RequestBody List<empentity> entities) {
	return service.createentities(entities);
}

// Read method for single employee
@GetMapping("/getemployee/{id}")
public empentity getemployeeByid(@PathVariable int id) {
	return service.getentityById(id);
}

//Read method for multiple employee
@GetMapping("/getemployees")
public List<empentity> getemployees() {
	return service.getentities();
}

//update method for single employee
@PutMapping("/updateemployee")
public empentity updateemployee(@RequestBody empentity entity) {
	return service.updateentity(entity);
}

//Delete method for single employee
@DeleteMapping("/deleteemployee/{id}")
public String deletemployeeByid(@PathVariable int id) {
	return service.deleteentityById(id);
}
}