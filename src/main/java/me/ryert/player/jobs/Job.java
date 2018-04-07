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
    public int getName() {
        return Name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getName() {
        return Name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
