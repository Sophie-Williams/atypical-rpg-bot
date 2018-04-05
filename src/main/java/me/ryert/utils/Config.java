package me.ryert.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Temporary Solution until MYSQL is implemented
 */
public class Config {

    //String to hold the bot's token
    public static final String DISCORD_TOKEN;

    //String to hold the Guild ID of main server
    public static final String GUILD_ID;

    //String to hold the Channel ID of log channel
    public static final String LOG_CHANNEL;

    //Gets the data when class is first noticed
    static {
        DISCORD_TOKEN = getData("Token: ").get(0);
        GUILD_ID = getData("Guild ID: ").get(0);
        LOG_CHANNEL = getData("Log Channel: ").get(0);
    }

    //Returns the searched for data
    private static ArrayList<String> getData(String key) {

        //ArrayList Variable to hold results
        ArrayList<String> results = new ArrayList<>();

        //Try-catch loop to prevent mass exception handling
        try {

            //Scanner to parse the cache file
            Scanner cache = new Scanner(new File("src\\main\\resources\\Data\\Sneaky.txt"));

            //Checks through each line
            while (cache.hasNextLine()) {

                //Sets the variable line to the next line of the file
                String line = cache.nextLine();

                //Checks if the line contains the key
                if (line.contains(key))

                    //Adds the data to the list
                    results.add(line.replace(key, "").replace(" ", ""));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("[DEBUG] Key.txt is missing, has it been moved?");
        }

        //Returns the ArrayList with the search results
        return results;
    }
}
