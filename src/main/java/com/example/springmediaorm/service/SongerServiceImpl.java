package com.example.springmediaorm.service;

import com.example.springmediaorm.model.Songer;
import com.example.springmediaorm.repository.SongerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SongerServiceImpl implements IGeneralService<Songer> {
    @Autowired
    private SongerRepository songerRepository;

    @Override
    public List<Songer> findAll() {
        return songerRepository.findAll();
    }

    @Override
    public Songer findById(int id) {
        return songerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Songer entity) {
        songerRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        songerRepository.deleteById(id);
    }
}
