package com.atypon.portal.usertypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instructor {
    @Id
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    public Instructor(Object[] columns) {
        this.id = (String) columns[0];
        this.name = (String) columns[1];
        this.password = (String) columns[2];
    }

    public String getName() {
        return name;
    }
}
