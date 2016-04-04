package com.wuzu.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wuzu.board.domain.Article;

//@RepositoryRestResource(collectionResourceRel = "articles", path = "articles")
public interface ArticleRepository extends JpaRepository<Article, Integer>{ 

}
