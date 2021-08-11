package com.atypon.portal.managers;



import com.atypon.portal.usertypes.Admin;
import org.springframework.stereotype.Component;


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
