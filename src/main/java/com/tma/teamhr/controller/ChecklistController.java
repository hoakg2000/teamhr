package com.tma.teamhr.controller;

import com.tma.teamhr.service.IChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/devs")
public class ChecklistController {

    @Autowired
    private IChecklistService checklistService;

}
