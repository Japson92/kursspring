package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {
    @PersistenceContext
    private EntityManager em;
    Random rand = new Random();

    Map<Integer, Quest> quests = new HashMap<>();


    @Transactional
    public void createQuest(String description){

        Quest quest = new Quest(description);

        em.persist(quest);

    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest){
        quests.remove(quest.getId());
    }
    @PostConstruct
    public void init(){
    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "quests=" + quests +
                '}';
    }


    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest(){
        List<String> descriprions = new ArrayList<>();

        descriprions.add("Uratuj ksiezniczke");
        descriprions.add("Wez udzial w turnieju");
        descriprions.add("Zabij bande goblinow");
        descriprions.add("Zabij smoka");

        String description = descriprions.get(rand.nextInt(descriprions.size()));
        createQuest(description);
    }

    public void update(Quest quest) {
        quests.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id) {
       return quests.get(id);
    }
}
