package com.application.workshop_mongodb.dto;

import java.io.Serializable;

import com.application.workshop_mongodb.domain.User;

public class UserDto implements Serializable{

    private String id;
    private String name;

    public UserDto() {
    }

    public UserDto(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
