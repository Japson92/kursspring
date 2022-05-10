package com.clockworkjava.kursspring.config;


import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }
    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}
