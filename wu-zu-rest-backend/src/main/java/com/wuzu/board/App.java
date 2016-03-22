package com.wuzu.board;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 웹앱 실행 : gradle bootRun
 * 
 * @author Gahngha Ryu
 */
@SpringBootApplication(scanBasePackages = "com.wuzu.board.config")
public class App {
    
	public static void main(String[] args) {
	    
	    SpringApplication.run(App.class, args);
	}
}