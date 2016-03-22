package com.wuzu.board.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * @author Gahngha Ryu
 */
@Configuration
@Profile("prod")
public class DbConfig {
    
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        
        return new TomcatEmbeddedServletContainerFactory() {
            
            /**
             * 임베디드 톰캣의 JNDI 활성화
             */
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
                
                tomcat.enableNaming();
                
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
            
            /**
             * JNDI에 데이터소스 등록
             */
            @Override
            protected void postProcessContext(Context context) {
                
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/board"); // java:comp/env/jdbc/board
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "com.mysql.jdbc.Driver");
                resource.setProperty("url", "jdbc:mysql://호스트명/BOARD");
                
                context.getNamingResources().addResource(resource);
            }
        };
    }
    
    @Bean
    public DataSource dataSource() throws IllegalArgumentException, NamingException {
        
        JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
        factory.setJndiName("java:comp/env/jdbc/board");
        factory.setExpectedType(DataSource.class);
        factory.setLookupOnStartup(false);
        factory.afterPropertiesSet();
        
        return (DataSource) factory.getObject();
    }
}