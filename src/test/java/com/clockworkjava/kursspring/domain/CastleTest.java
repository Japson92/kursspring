package com.clockworkjava.kursspring.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage(){
        Quest quest = new Quest();
        Knight knight = new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight, "East Watch");
        String except = "Znajduje sie tu zamek o nazwie East Watch. Zamieszkaly przez rycerza Rycerz o imieniu Lancelot(29). Zadanie: Uratuj ksiezniczke";
        assertEquals(except, castle.toString());
    }
}
