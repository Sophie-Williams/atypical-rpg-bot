package me.ryert.player.data;

import me.ryert.player.classes.ICharacterClass;
import me.ryert.player.classes.Student;

import java.io.Serializable;

/**
 * Player objects are stored here
 * @author Ryert
 */
public class Player implements Serializable {

    private ICharacterClass characterClass;
    private Stats stats;
    private Inventory inventory;
    private int level;
    private long exp;

    public Player() {
        this.characterClass = new Student();
        this.stats = new Stats();
        this.inventory = new Inventory(7);
        this.level = 1;
        this.exp = 0;
    }

    public ICharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(ICharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}
