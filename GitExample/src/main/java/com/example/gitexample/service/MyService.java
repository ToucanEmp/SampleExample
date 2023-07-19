package com.example.gitexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gitexample.entity.MyEntity;
import com.example.gitexample.repository.MyRepository;

@Service
public class MyService {
	@Autowired
	private MyRepository myRepository;
	
	public MyEntity addEmp(MyEntity entity) {
		return myRepository.save(entity);
	}
	
	public void deleteEmp(long emp_id) {
		myRepository.deleteById(emp_id);
	}
	public Optional<MyEntity> findEmp(long emp_id) {
		return myRepository.findById(emp_id);
	}
	
	public List<MyEntity> getAll() {
		return myRepository.findAll();
	}
	public Boolean exists(long emp_id) {
		return myRepository.existsById(emp_id);
	}
	

}
