package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.Castle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KursspringApplication {

	public static void main(String[] args) {
/*		ConfigurableApplicationContext ctx =*/ SpringApplication.run(KursspringApplication.class, args);
//		Castle castle = (Castle) ctx.getBean("castle");
//		System.out.println(castle);
	}

}
