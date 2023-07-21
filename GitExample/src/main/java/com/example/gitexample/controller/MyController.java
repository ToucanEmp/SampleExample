package com.example.gitexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gitexample.entity.MyEntity;
import com.example.gitexample.exception.ResourceNotFoundException;
import com.example.gitexample.repository.MyRepository;
import com.example.gitexample.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
	@Autowired
	private MyRepository myRepository;
	@PostMapping("/add")
	public MyEntity addEmp(@RequestBody MyEntity entity) {
		return myService.addEmp(entity);
	}
	@DeleteMapping("/deleteById")
	public void deleteEmp(@PathVariable long emp_id) {
		myService.deleteEmp(emp_id);
	}
	
	@GetMapping("/getById/{emp_id}")
	public Optional<MyEntity> findEmp(@PathVariable long emp_id) {
		return myService.findEmp(emp_id);
	}
	@GetMapping("/getAll")
	public List<MyEntity> getAll() {
		return myService.getAll();
	}
	@PutMapping("{id}")
    public ResponseEntity<MyEntity> updateEmployee(@PathVariable long id,@RequestBody MyEntity employeeDetails) {
		MyEntity updateEmployee = myRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setDept(employeeDetails.getDept());
        updateEmployee.setEmp_name(employeeDetails.getEmp_name());
        updateEmployee.setEmp_age(employeeDetails.getEmp_age());

        myRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }
	@GetMapping("/exists/{emp_id}")
	public Boolean exists(@PathVariable long emp_id) {
		return myService.exists(emp_id);
	}
	
	@GetMapping("/getbydept/{dept}")
	public List<MyEntity> getbydept(@PathVariable String dept) {
		return myService.findByDept(dept);
	}

}
