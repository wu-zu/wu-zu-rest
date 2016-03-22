package com.wuzu.proto.springrest;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProtoApp.class)
@WebIntegrationTest(randomPort = true)
public class SpringDataRestTest {
    
    @Value("${local.server.port}")
    private int port;
    
    @Before
    public void setUp() {
        
        RestAssured.port = port;
    }
    
    @Test
    public void test() {
        
        when().get("/heroes")
              .then()
              .statusCode(HttpStatus.OK.value())
              .body("page.totalElements", is(5))
              .body("_embedded.heroes[0].firstName", is("Kim"))
              .body("_embedded.heroes[1].lastName", is("Kangha"));
    }
}