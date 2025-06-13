package com.example.springmediaorm.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();

    E findById(int id);

    void save(E entity);
    void deleteById(int id);
}
