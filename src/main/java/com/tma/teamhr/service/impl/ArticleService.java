package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.IArticleRepository;
import com.tma.teamhr.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleRepository articleRepository;

}
