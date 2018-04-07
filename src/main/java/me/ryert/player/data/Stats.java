package me.ryert.player.data;

import java.io.Serializable;

public class Stats implements Serializable {
    private int intelligence;

    public Stats() {
        this.intelligence = 0;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
