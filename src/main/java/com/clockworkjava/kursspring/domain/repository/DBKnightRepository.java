package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository{
    @Override
    public void createKnight(String name, int age){
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights(){
        System.out.println("Uzywam bazy danych");
      return null;
    }

    @Override
    public Optional<Knight> getKnight(String name){
        System.out.println("Uzywam bazy danych");
        return null;
    }

    @Override
    public void deleteKnight(Integer id){
        System.out.println("Uzywam bazy danych");

    }
    @Override
    @PostConstruct
    public void build(){

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Knight getKnightById(Integer id) {
        System.out.println("Uzywam bazy danych");
        return null;
    }
}
