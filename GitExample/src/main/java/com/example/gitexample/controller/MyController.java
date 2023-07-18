package com.example.gitexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gitexample.entity.MyEntity;
import com.example.gitexample.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
	
	public MyEntity addEmp(@RequestBody MyEntity entity) {
		return myService.addEmp(entity);
	}

}
