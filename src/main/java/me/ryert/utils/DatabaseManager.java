package me.ryert.utils;

import me.ryert.bot.Connect;
import me.ryert.player.data.Inventory;
import me.ryert.player.data.Player;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

/**
 * Class with tools to manage the database
 * @author Ryert
 */
public class DatabaseManager {

    //Adds a new player to the database
    public static void add(String discordID, Player player, Inventory inventory) {
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutStream = new ObjectOutputStream(byteArrayOutStream);
            objectOutStream.writeObject(player);
            byte[] playerAsBytes = byteArrayOutStream.toByteArray();
            objectOutStream.writeObject(inventory);
            byte[] inventoryAsBytes = byteArrayOutStream.toByteArray();
            PreparedStatement statement = dbConn
                    .prepareStatement("INSERT INTO Player (DiscordID, GuildID, Stats, Inventory) " +
                            "VALUES(" + discordID + ", 0, ?, ?)");
            ByteArrayInputStream byteArrayInStream = new ByteArrayInputStream(playerAsBytes);
            statement.setBinaryStream(1, byteArrayInStream, playerAsBytes.length);
            byteArrayInStream = new ByteArrayInputStream(inventoryAsBytes);
            statement.setBinaryStream(2, byteArrayInStream, inventoryAsBytes.length);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Looks up the member
    public static boolean isPresent(String discordID) {
        boolean search = false;
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            Statement statement = dbConn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DiscordID FROM Player");
            while (resultSet.next())
                if (resultSet.getString(1).equals(discordID))
                    search = true;
            statement.close();
            resultSet.close();
            dbConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return search;
    }

    public static void update(String discordID, Player player) {
        //TODO
    }

    public static void update(String discordID, Inventory inventory) {
        //TODO
    }

    public static void delete(String discordID) {
        //TODO
    }
}
