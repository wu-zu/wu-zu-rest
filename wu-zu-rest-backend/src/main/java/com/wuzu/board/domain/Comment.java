package com.wuzu.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * @author Kyunghun Jeon
 */
@Data
@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
    private Date addDate = new Date();

    @ManyToOne
    @JoinColumn(name="ARTICLE_ID")
    private Article article;

	
}
