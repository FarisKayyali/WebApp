package com.atypon.portal.managers;



import com.atypon.portal.usertypes.Admin;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Component
public class AdminManager {

    @PersistenceContext
    private EntityManager entityManager;

    public Admin validateAdmin(String username, String password){
        String queryStr = "select * from admins where id = ?1 and password = ?2";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return new Admin((Object[]) query.getSingleResult());
    }

    @Transactional
    public int executeAdminQuery(String queryStr){
        entityManager.joinTransaction();
        Query query = entityManager.createNativeQuery(queryStr);
        int rowsAffected = query.executeUpdate();
        return rowsAffected;
    }
}
