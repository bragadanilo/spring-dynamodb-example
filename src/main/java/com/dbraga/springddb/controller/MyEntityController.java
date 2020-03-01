package com.dbraga.springddb.controller;

import com.dbraga.springddb.model.MyEntity;
import com.dbraga.springddb.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyEntityController {

    @Autowired
    private MyEntityRepository myEntityRepository;

    @GetMapping(value = "/springddb/entity/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<MyEntity>> getEntities(@PathVariable("name") String name) {

        List<MyEntity> entityList = new ArrayList<>(myEntityRepository.findByName(name));

        if(entityList.isEmpty()){
            MyEntity entity = MyEntity.builder().name(name).build();
            myEntityRepository.save(entity);
            entityList.add(entity);
        }

        return  ResponseEntity.ok(entityList);
    }

}
