package com.example.gitexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "MyCollection")
public class MyEntity {
	@Id
	private long emp_id; 
	private String emp_name;
	private String dept;
	private int emp_age;

}
