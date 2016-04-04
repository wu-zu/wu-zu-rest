package com.wuzu.board;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wuzu.board.domain.Article;
import com.wuzu.board.domain.Comment;
import com.wuzu.board.repository.ArticleRepository;
import com.wuzu.board.repository.CommentRepository;

/**
 * 웹앱 실행 : gradle bootRun
 * 
 * @author Gahngha Ryu
 */
@SpringBootApplication
public class App {
	
	@Autowired
	private ArticleRepository articleRepo;
	
	@Autowired
	private CommentRepository commentRepo;
    
	public static void main(String[] args) {
	    
	    SpringApplication.run(App.class, args);
	}
	
	@PostConstruct
	public void initTestData() {
		Article a1 = new Article();
		a1.setNickname("testNick");
		a1.setPassword("password1234");
		a1.setTitle("제목입니다.");
		a1.setContent("동해물과백수단이");
		
		Article a2 = new Article();
		a2.setNickname("하니");
		a2.setPassword("pwd");
		a2.setTitle("요리보고");
		a2.setContent("둘리둘리");
		
		articleRepo.save(a1);
		articleRepo.save(a2);
		
		Comment c1 = new Comment();
		c1.setNickname("코멘트1");
		c1.setPassword("pass");
		c1.setContent("이바보야");
		c1.setArticle(a1);
		
		commentRepo.save(c1);
		
		
	}
	
	
}