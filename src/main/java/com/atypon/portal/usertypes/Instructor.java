package com.atypon.portal.usertypes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instructor {
    @Id
    int id;
    String name;
    String password;
}
