package me.ryert.player.data;

import me.ryert.player.classes.ICharacterClass;
import me.ryert.player.classes.Student;

import java.io.Serializable;

/**
 * Player objects are stored here
 * @author Ryert
 */
public class Player implements Serializable {

    //Instance Variables
    private ICharacterClass characterClass;
    private Stats stats;
    private Inventory inventory;
    private int level;
    private int exp;
    private int balance;

    //Default Constructor
    public Player() {
        this.characterClass = new Student();
        this.stats = new Stats();
        this.inventory = new Inventory(7);
        this.level = 1;
        this.exp = 0;
        this.balance = 25;
    }

    //Adds exp to a player
    public void addExp(int exp) {
        this.exp += exp;
        check();
    }

    //Checks for a level up
    public void check() {
        switch (this.exp) {
            //TODO: Decide on what xp gives you what level
            default :
                this.level = 1;
        }
    }

    //Completes a transaction
    public boolean transact(int funds) {
        if (funds < 0)
            if (this.balance < Math.abs(funds))
                return false;
        balance += funds;
        return true;
    }

    //Changes the player's class
    public void setCharacterClass(ICharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    //Returns the player's class
    public ICharacterClass getCharacterClass() {
        return characterClass;
    }

    //Returns the player's stats
    public Stats getStats() {
        return stats;
    }

    //Returns the player's inventory
    public Inventory getInventory() {
        return inventory;
    }

    //Returns the player's level
    public int getLevel() {
        return level;
    }

    //Returns the player's exp
    public int getExp() {
        return exp;
    }
}
