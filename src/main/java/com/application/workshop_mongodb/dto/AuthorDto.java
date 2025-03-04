package com.application.workshop_mongodb.dto;

import java.io.Serializable;

import com.application.workshop_mongodb.domain.User;

public class AuthorDto implements Serializable{

    private String id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(User user){
        this.id = user.getId();
        this.name = user.getName();
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
