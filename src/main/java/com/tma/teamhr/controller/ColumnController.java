package com.tma.teamhr.controller;

import com.tma.teamhr.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/columns")
public class ColumnController {

    @Autowired
    private IColumnService columnService;

}
