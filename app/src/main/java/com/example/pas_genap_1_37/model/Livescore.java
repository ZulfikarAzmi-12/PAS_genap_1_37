package com.example.pas_genap_1_37.model;

public class Livescore {
    private String event;
    private String score;

    public Livescore(String event, String score) {
        this.event = event;
        this.score = score;
    }

    public String getEvent() {
        return event;
    }

    public String getScore() {
        return score;
    }
}
