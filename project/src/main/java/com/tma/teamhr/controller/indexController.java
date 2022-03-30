package com.tma.teamhr.controller;

import com.tma.teamhr.pojos.CheckList;
import com.tma.teamhr.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @Autowired
    private IndexRepository indexRepository;

    @GetMapping("/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/checklist")
    public ResponseEntity<CheckList> checklist(){
        return new ResponseEntity<CheckList>(indexRepository.getCheckListById(1), HttpStatus.OK);
    }
}
