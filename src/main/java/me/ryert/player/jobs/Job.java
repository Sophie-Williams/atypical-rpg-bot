package me.ryert.player.jobs;

import java.io.Serializable;

/**
 * Job objects stored here
 * @author kingkory
 */
public abstract class Job implements Serializable {
    private String Name;
    private int level;

    public Job(){
        Name = "No Job Selected";
        level = 0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
