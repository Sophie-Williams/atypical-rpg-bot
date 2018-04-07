package me.ryert.player.jobs;

import me.ryert.player.data.Player;

/**
 * Mining objects stored here
 * @author kingkory
 */
public class Mining {

    int speed, rate, cooldown;
    public Mining(){
        speed = 1;
        rate = 1;
        cooldown = 1;
    }

    //This is what will be called when the user does --mine or whatever
    public void mine(Player player){
        if(coolDown()) {
            player.transact(getMoney());
            coolDownReset();
        }
        else
            System.out.println("Cannot Mine for another " + cooldown + " minutes");

    }

    public int getMoney(){
        return rate / speed;
    }

    //make this so that mine cannot be done again for "cooldown" minutes
    public boolean coolDown(){
        if(cooldown == 0)
            return true;
        else
            return false;
    }

    public void coolDownReset(){
        cooldown = speed;
    }



}
