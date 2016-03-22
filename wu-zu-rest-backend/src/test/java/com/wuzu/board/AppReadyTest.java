package com.wuzu.board;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 애플리케이션 개발을 위한 준비가 되었는지 테스트
 * 
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest(randomPort = true)
public class AppReadyTest {
    
    @Value("${local.server.port}")
    private int port;
    
    @Autowired
    private DataSource dataSource;
    
    @Test
    public void dataSource() throws NamingException {
        
        assertThat(dataSource, is(notNullValue()));
    }
}