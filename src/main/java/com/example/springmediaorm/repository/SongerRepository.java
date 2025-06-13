package com.example.springmediaorm.repository;

import com.example.springmediaorm.model.Songer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongerRepository extends JpaRepository<Songer, Integer> {
} 