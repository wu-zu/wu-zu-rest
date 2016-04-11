package com.wuzu.board.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wuzu.board.domain.Comment;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository extends JpaRepository<Comment, Integer>{ 

    List<Comment> findByArticle_Id(@Param(value = "articleID") int articleID, Pageable pageable);
}
