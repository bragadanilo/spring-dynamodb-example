package com.dbraga.springddb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "entity-table")
public class MyEntity {
    @Id
    private MyEntityId id;
    private String name;
    private String type;

    public MyEntity() {
        id = new MyEntityId();
    }

    public MyEntity(String id, String idRel, String type) {
        this();
        this.id.setId(id);
        this.id.setIdRelation(idRel);
        this.type = type;
    }

    @DynamoDBHashKey
    public String getId() {
        return id.getId();
    }

    @DynamoDBRangeKey
    public String getIdRelation() {
        return id.getIdRelation();
    }

    public void setId(String id) {
        this.id.setId(id);
    }

    public void setIdRelation(String idRelation) {
        this.id.setIdRelation(idRelation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}