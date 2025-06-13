package com.example.springmediaorm.service;

import com.example.springmediaorm.model.Songer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ISongerService implements IGeneralService<Songer> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Songer> findAll() {
        TypedQuery<Songer> query = em.createQuery("SELECT s FROM Songer s", Songer.class);
        return query.getResultList();
    }

    @Override
    public Songer findById(int id) {
        String sql = "SELECT s FROM Songer s WHERE s.id = :id";
        TypedQuery<Songer> query = em.createQuery(sql, Songer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
