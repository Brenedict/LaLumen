package com.lalumen.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lalumen.backend.entity.Work;
import com.lalumen.backend.service.WorkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkService service;

    @PostMapping
    public Work postWork(@RequestBody Work work) {
        return service.postWork(work);
    }
    
    
}
