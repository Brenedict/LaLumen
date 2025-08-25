package com.lalumen.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lalumen.backend.entity.Work;
import com.lalumen.backend.service.WorkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService service;

    @GetMapping
    public List<Work> getWorks() {
        return service.getWorks();
    }

    @GetMapping("/{id}")
    public Work getWorkById(@PathVariable int id) {
        return service.getWorkById(id);
    }
    
    @PostMapping
    public Work postWork(@RequestBody Work work) {
        return service.postWork(work);
    }
     
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable int id) {
        service.deleteWork(id);
        return ResponseEntity.noContent().build();
    }
    
}
