package com.grsa.byemicroservice.repository;


import com.grsa.byemicroservice.model.Counter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CounterDAOImpl implements CounterDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveCounter(Counter counter) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(counter);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Counter getCounter(String key) {
        EntityManager em = sessionFactory.createEntityManager();
        Counter counter = em.find(Counter.class, key);
        em.close();
        return counter;
    }
}
