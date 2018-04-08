package me.ryert.player.jobs;

import me.ryert.player.data.Player;

/**
 * Mining objects stored here
 * @author kingkory
 */
public class Mining {

    static double coolMax, rate, cooldown;
    public Mining(){
        coolMax = 1;
        rate = 1;
        cooldown = 1;
    }

    //This is what will be called when the user does --mine or whatever
    public static void mine(Player player){
        if(coolDown()) {
            player.transact(getMoney());
            coolDownReset();
        }
        else
            System.out.println("Cannot Mine for another " + cooldown + " minutes");

    }

    public static int getMoney(){
        return (int) (rate);
    }

    //TODO make this so that mine cannot be done again for "cooldown" minutes
    public static boolean coolDown(){
        if(cooldown == 0)
            return true;
        else
            return false;
    }

    public static void coolDownReset(){
        cooldown = coolMax;
    }

    public static void upgradeMax(Player player){

    }

    public static void upgradeRate(Player player){

    }


}
