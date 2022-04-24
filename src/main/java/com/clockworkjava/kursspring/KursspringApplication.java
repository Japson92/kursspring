package com.clockworkjava.kursspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:castle.properties")
//@ImportResource("classpath:config/spring-config.xml")
public class KursspringApplication {

	public static void main(String[] args) {
		 SpringApplication.run(KursspringApplication.class, args);

	}

}
