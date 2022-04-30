package com.clockworkjava.kursspring.utils;

import java.util.Set;

public class Ids {

   static public int generateNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        } else {
            Integer integer = keysSoFar.stream().max(Integer::compareTo).get();
            return integer + 1;

        }
    }
}
