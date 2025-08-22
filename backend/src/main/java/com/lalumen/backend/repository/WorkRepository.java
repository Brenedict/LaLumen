package com.lalumen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalumen.backend.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {
    
}
