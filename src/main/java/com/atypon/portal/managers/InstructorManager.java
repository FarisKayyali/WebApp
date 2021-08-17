package com.atypon.portal.managers;

import com.atypon.portal.entities.Instructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorManager {
    @PersistenceContext
    private EntityManager entityManager;

    public Instructor validateInstructor(String username, String password){
        String queryStr = "select * from instructors where id = ?1 and password = ?2";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return new Instructor((Object[]) query.getSingleResult());
    }

    public List<Object[]> getInstructorCourses(String instructorId){
        String queryStr = "select name from courses where instructorId = ?1";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, instructorId);

        List<Object[]> idsAndNames = query.getResultList();

        return idsAndNames;
    }

    public List<String> getInstructorStudents(String courseName){
        String queryStr = "select id, name from students where id in (select stid from studentcourses where coid =(select id from courses where name = ?1))order by id";
        Query query = entityManager.createNativeQuery(queryStr);
        query.setParameter(1, courseName);

        List<Object[]> idsAndNames = query.getResultList();

        String queryStr2 = "select grade from studentcourses where coid = (select id from courses where name = ?1) order by stid";
        Query query2 = entityManager.createNativeQuery(queryStr2);
        query2.setParameter(1, courseName);

        List <Integer> grades = query2.getResultList();

        List<String> instructorStudents = new ArrayList<>();

        for (int i = 0; i < grades.size(); i++){
            instructorStudents.add(idsAndNames.get(i)[0].toString());
            instructorStudents.add(idsAndNames.get(i)[1].toString());
            instructorStudents.add(Integer.toString(grades.get(i)));
        }

        return instructorStudents;
    }
}
