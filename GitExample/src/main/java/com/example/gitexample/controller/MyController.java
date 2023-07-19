package com.example.gitexample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gitexample.entity.MyEntity;
import com.example.gitexample.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
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

}
