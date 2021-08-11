package com.example.demo.managers;



import com.example.demo.usertypes.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class AdminManager {

    @PersistenceContext
    EntityManager entityManager;




    public Admin validateAdmin(String username, String password){
        String queryStr = "select * from admins where id = ?1 and password = ?2";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, username);
        query.setParameter(2, password);

        return new Admin((Object[]) query.getSingleResult());

    }
}
