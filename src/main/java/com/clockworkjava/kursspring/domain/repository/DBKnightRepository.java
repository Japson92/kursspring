package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Collection;
import java.util.Optional;


public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void createKnight(String name, int age) {

        Knight knight = new Knight(name, age);

        em.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("From Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = em.createQuery("From Knight k WHERE k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(id);

    }

    @Override
    public void build() {

    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }

    @Transactional
    @Override
    public void updateKnight(int id, Knight knight) {

        em.merge(knight);
    }


}
