package com.clockworkjava.kursspring.domain;

public class Quest {
    private String description;

    public Quest() {
        this.description = "Uratuj ksiezniczke";
    }

    @Override
    public String toString() {
        return description;
    }
}
