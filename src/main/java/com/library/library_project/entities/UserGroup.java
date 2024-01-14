package com.library.library_project.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usergroups")
public class UserGroup {
    @Id
    @GeneratedValue
    Long id;
    @Column(name="username")
    String username;

    @Column(name="groupname")
    String userGroup;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
