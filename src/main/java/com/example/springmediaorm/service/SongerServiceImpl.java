package com.example.springmediaorm.service;

import com.example.springmediaorm.model.Songer;
import com.mysql.cj.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Transactional
public class SongerServiceImpl implements IGeneralService<Songer> {
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

    @Override
    public void save(Songer entity) {
        if (entity.getMa() == 0) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
    }

    @Override
    public void update(Songer entity) {

    }

    @Override
    public void deleteById(int id) {
        Songer entity = this.findById(id);
        em.remove(entity);
    }

}
