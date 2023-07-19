package com.example.gitexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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

}
