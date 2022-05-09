package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    Random rand = new Random();


    @Transactional
    public void createQuest(String description) {

        Quest quest = new Quest(description);

        em.persist(quest);

        System.out.println(quest);

    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest", Quest.class).getResultList();
    }

    @Transactional
    public void deleteQuest(Quest quest) {
        em.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriprions = new ArrayList<>();

        descriprions.add("Uratuj ksiezniczke");
        descriprions.add("Wez udzial w turnieju");
        descriprions.add("Zabij bande goblinow");
        descriprions.add("Zabij smoka");

        String description = descriprions.get(rand.nextInt(descriprions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        em.merge(quest);
    }


    public Quest getQuest(Integer id) {
        return em.find(Quest.class ,id);
    }
}
