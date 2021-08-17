package com.atypon.portal.managers;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EditMarksService {
    public static List<String> oldData;
    public static String courseName;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void editMarks(String newData[]){
        int j = 2;

        for (int i = 0; i < oldData.size()/3; i++){
            if(!newData[i].equals("") && !newData[i].equals(null)){
                if(!newData[i].equals(oldData.get(j))){
                    entityManager.joinTransaction();
                    String queryStr = "update studentcourses set grade = ?1 where coid = (select id from courses where name = ?2) AND stid = ?3";
                    Query query = entityManager.createNativeQuery(queryStr);
                    query.setParameter(1, Integer.parseInt(newData[i]));
                    query.setParameter(2, courseName);
                    query.setParameter(3, oldData.get(j-2));

                    int x = query.executeUpdate();
                }
            }
            j += 3;
        }

    }
}
