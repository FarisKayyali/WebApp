package com.atypon.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    public Student(Object[] columns) {
        this.id = (String) columns[0];
        this.name = (String) columns[1];
        this.password = (String) columns[2];
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
