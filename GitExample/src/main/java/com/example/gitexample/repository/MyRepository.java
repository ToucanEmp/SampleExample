package com.example.gitexample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.gitexample.entity.MyEntity;

@Repository
public interface MyRepository extends MongoRepository<MyEntity, Long> {

	public List<MyEntity> findByDept(String dept);

}
