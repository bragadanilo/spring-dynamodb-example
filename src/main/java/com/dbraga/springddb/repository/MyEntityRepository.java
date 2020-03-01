package com.dbraga.springddb.repository;

import com.dbraga.springddb.model.MyEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface MyEntityRepository extends CrudRepository<MyEntity, String> {

    List<MyEntity> findByName(String name);
    List<MyEntity> findById(String id);
}