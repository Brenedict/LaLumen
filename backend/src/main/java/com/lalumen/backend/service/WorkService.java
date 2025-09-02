package com.lalumen.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalumen.backend.entity.Account;
import com.lalumen.backend.entity.Category;
import com.lalumen.backend.entity.Work;
import com.lalumen.backend.repository.AccountRepository;
import com.lalumen.backend.repository.CategoryRepository;
import com.lalumen.backend.repository.WorkRepository;

import jakarta.transaction.Transactional;

@Service
public class WorkService {
    @Autowired
    WorkRepository repository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Work> getWorks() {
        return repository.findAll();
    }

    public Work getWorkById(int id) {
        Optional<Work> work = repository.findById(id);
        
        if(!work.isPresent()) {
            throw new RuntimeException("Work with id " + id + "not found");
        }
        
        return work.get();
    }

    public Work postWork(Work work) {
        work.setWorkId(0);
        return repository.save(work);
    }


    public void setAccount(int workId, int accountId) {
        Optional<Account> tempAccount = accountRepository.findById(accountId);

        Optional<Work> tempWork = repository.findById(workId);

        Work work = tempWork.get();

        work.setAccount(tempAccount.get());
        repository.save(work);
    }

    @Transactional
    public void addWorkCategory(int workId, int categoryId) {
        Optional<Category> tempCategory = categoryRepository.findById(categoryId);
        
        Optional<Work> tempWork = repository.findById(workId);

        // Add error checking

        Work work = tempWork.get();

        work.addWorkCategory(tempCategory.get());
    }
    
    public void deleteWork(int id) {
        repository.deleteById(id);
    }

    public List<Work> getWorkByAccountId(int id) {
        List<Work> works = repository.findByAccountId(id);

        if(works.isEmpty()) {
            throw new RuntimeException("No works exist for accountId " + id);
        }

        return works;
    }
}
