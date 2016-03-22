package com.wuzu.proto.springrest;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hyungchae Kim
 */
@SpringBootApplication
public class ProtoApp {

    @Autowired
    private HeroesRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProtoApp.class, args);
	}

    @PostConstruct
    public void initPersonData() {
        this.repository.save(Arrays.asList( new Heroes("Kim","Hyungchae")
                                          , new Heroes("Ryu","Kangha")
                                          , new Heroes("Jeon","GyungHoon")
                                          , new Heroes("Lee","TaeKyung")
                                          , new Heroes("Oh","SukKyu")
                                          ));
    }
}