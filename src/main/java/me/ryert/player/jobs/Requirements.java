package me.ryert.player.jobs;

import me.ryert.player.data.Player;

public class Requirements {

    static int balance, level, jobLevel;
    public Requirements(Player player){
        this.balance = player.getBalance();
        this.level = player.getLevel();
    }

}
