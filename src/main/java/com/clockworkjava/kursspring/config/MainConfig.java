package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config/castle-config.xml")
//@PropertySource("classpath:castle.properties")
public class MainConfig {
    @Autowired
    Quest quest;

    //    @Value("${my.castle.name:East Watch}")
//    String name;
//    @Bean
//    public Quest createQuest(){
//        return new Quest();
//    }
    @Bean(name = "lancelot")
    @Primary
    public Knight lancelot() {
        Knight lancelot = new Knight("Lancelot", 29);
        lancelot.setQuest(quest);
        return lancelot;
    }

    @Bean(name = "percival")
    public Knight createKnightBean() {
        Knight percival = new Knight("Percival", 25);
        percival.setQuest(quest);
        return percival;
    }
//
//    @Bean(name = "zamek", initMethod = "build", destroyMethod = "tearDown")
//    @Value("${my.castle.name:East Watch}")
//    public Castle castle(String name){
//        Castle castle = new Castle(knight());
//        castle.setName(name);
//        return castle;
//    }
}
