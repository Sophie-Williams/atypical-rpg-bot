package me.ryert.player.data;

import java.io.Serializable;

/**
 * Player objects are stored here
 * @author Ryert
 */
public class Inventory implements Serializable {

    private int slots;
    public Inventory(int slots) {
        this.slots = slots;
    }

    public int getSlots() {
        return slots;
    }
}
