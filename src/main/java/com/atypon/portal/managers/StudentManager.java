package com.atypon.portal.managers;

import com.atypon.portal.usertypes.Admin;
import com.atypon.portal.usertypes.Instructor;
import com.atypon.portal.usertypes.Student;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Component
public class StudentManager {
    @PersistenceContext
    private EntityManager entityManager;

    public Student validateStudent(String username, String password){
        String queryStr = "select * from students where id = ?1 and password = ?2";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return new Student((Object[]) query.getSingleResult());
    }
}
