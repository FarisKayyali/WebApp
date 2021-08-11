package com.example.demo.usertypes;

import jdk.jfr.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Admin {

    @Id
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "password")
    String password;

    public Admin(Object[] columns) {
        this.id = (String) columns[0];
        this.name = (String) columns[1];
        this.password = (String) columns[2];
    }
}
