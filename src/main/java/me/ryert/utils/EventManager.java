package me.ryert.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Manages all the future events
 *
 * @author Ryert
 */
public class EventManager {

    public static void schedule(Event event, double minutes) {

        //New timer object
        Timer timer = new Timer();

        //Schedules the event after a passed amount of time
        timer.schedule(new TimerTask() {

            //Method that runs when the time occurs
            public void run() {
                event.runEvent();
            }
        }, new Date(System.currentTimeMillis() + (int) (minutes * 60 * 1000)));
    }
}

