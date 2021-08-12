package com.atypon.portal.managers;

import com.atypon.portal.entities.Student;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> getStudentCourses(String studentId){

        String queryStr = "select coid, grade from studentcourses where stid = ?1";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, studentId);
        List<Object[]> list = query.getResultList();
        List<String> data = new ArrayList<>();
        for (Object[] o : list){
            data.add(o[0].toString());
            data.add(o[1].toString());
        }
        return data;
    }
}
