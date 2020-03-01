package com.dbraga.springddb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;


public class MyEntityId {
    private String id;
    private String idRelation;

    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    @DynamoDBRangeKey
    public String getIdRelation() {
        return idRelation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdRelation(String idRelation) {
        this.idRelation = idRelation;
    }


}