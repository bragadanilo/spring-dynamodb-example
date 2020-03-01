package com.dbraga.springddb.controller;

import com.dbraga.springddb.model.MyEntity;
import com.dbraga.springddb.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class MyEntityController {

    @Autowired
    private MyEntityRepository myEntityRepository;

    @GetMapping(value = "/springddb/entity/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<MyEntity>> getEntities(@PathVariable("name") String name) {

        List<MyEntity> entityList = new ArrayList<>(myEntityRepository.findByName(name));

        if(entityList.isEmpty()){
            MyEntity entity = new MyEntity(name, name, name);
            myEntityRepository.save(entity);
            entityList.add(entity);
        }

        return  ResponseEntity.ok(entityList);
    }

    @GetMapping(value = "/springddb/init/")
    public ResponseEntity<List<MyEntity>> init() {

        MyEntity entity0 = new MyEntity("L1","M1","L");
        MyEntity entity1 = new MyEntity("M1","S1","M");

        MyEntity entity2 = new MyEntity("S1","T1","S");
        MyEntity entity3 = new MyEntity("T1","T1","T");

        MyEntity entity4 = new MyEntity("S1","T2","S");
        MyEntity entity5 = new MyEntity("T2","T2","T");

        MyEntity entity21 = new MyEntity("S2","T3","S");
        MyEntity entity32 = new MyEntity("T3","T3","T");

        MyEntity entity41 = new MyEntity("S2","T4","S");
        MyEntity entity52 = new MyEntity("T4","T4","T");


        List<MyEntity> toAdd = Arrays.asList(entity0, entity1, entity2, entity3, entity4, entity5,
                entity21, entity32, entity41, entity52
                );

        toAdd.forEach(e -> myEntityRepository.save(e));


        return  ResponseEntity.ok(toAdd);
    }

    @GetMapping(value = "/springddb/search/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<MyEntity>> getbyid(@PathVariable("id") String id) {

        List<MyEntity> entityList = new ArrayList<>();
        getById(id, entityList);
        System.out.println(entityList);

        return  ResponseEntity.ok(entityList);
    }

    private List<MyEntity> getById(String id, List<MyEntity> result){
        List<MyEntity> entityList = myEntityRepository.findById(id);

        if(!entityList.isEmpty() && "T".equals(entityList.get(0).getType())){
            result.addAll(entityList);
            return Collections.emptyList();
        }
        entityList.forEach(e -> {
            System.out.println("getting for:" + e.getId());
            getById(e.getIdRelation(), result);
        });


        return null;
    }

}
