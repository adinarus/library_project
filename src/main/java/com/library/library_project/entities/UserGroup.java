package com.library.library_project.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class UserGroup {
    private Long id;
    private String username;
    private String userGroup;
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

}
