package com.wuzu.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wuzu.board.domain.Comment;

//@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository extends JpaRepository<Comment, Integer>{ 

}
