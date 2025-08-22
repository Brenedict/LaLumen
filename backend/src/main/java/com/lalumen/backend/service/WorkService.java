package com.lalumen.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalumen.backend.entity.Work;
import com.lalumen.backend.repository.WorkRepository;

@Service
public class WorkService {
    @Autowired
    WorkRepository repository;

    public Work postWork(Work work) {
        work.setWorkId(0);
        return repository.save(work);
    }
}
