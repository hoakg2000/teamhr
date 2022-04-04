package com.tma.teamhr.repository;

import com.tma.teamhr.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface IArticleRepository extends CrudRepository<Article, Long> {
}
