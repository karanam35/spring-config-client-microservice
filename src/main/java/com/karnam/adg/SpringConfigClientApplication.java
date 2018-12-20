package com.karnam.adg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@EnableAutoConfiguration
@ConfigurationProperties
@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
	
	@Value("${enviroment}")
    private String testProperty;

    @Value("${test}")
    private String localTestProperty;


    @RequestMapping("/")
    public String test() {
    	System.out.println(testProperty+" : "+localTestProperty);
    	return null;
    }

}

