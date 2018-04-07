package me.ryert.utils;

import me.ryert.bot.Connect;
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
    public static void add(String discordID, Player player) {
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutStream = new ObjectOutputStream(byteArrayOutStream);
            objectOutStream.writeObject(player);
            byte[] playerAsBytes = byteArrayOutStream.toByteArray();
            PreparedStatement statement = dbConn
                    .prepareStatement("INSERT INTO Player (DiscordID, GuildID, Stats) " +
                            "VALUES(" + discordID + ", 0, ?)");
            ByteArrayInputStream byteArrayInStream = new ByteArrayInputStream(playerAsBytes);
            statement.setBinaryStream(1, byteArrayInStream, playerAsBytes.length);
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

    //Updates the player data
    public static void update(String discordID, Player player) {
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            ByteArrayOutputStream byteArrayOutStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutStream = new ObjectOutputStream(byteArrayOutStream);
            objectOutStream.writeObject(player);
            byte[] playerAsBytes = byteArrayOutStream.toByteArray();
            PreparedStatement statement = dbConn
                    .prepareStatement("UPDATE Player set Stats= ? WHERE DiscordID='" + discordID + "'");
            ByteArrayInputStream byteArrayInStream = new ByteArrayInputStream(playerAsBytes);
            statement.setBinaryStream(1, byteArrayInStream, playerAsBytes.length);
            statement.executeUpdate();
            statement.close();
            dbConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Updates a players guild registration
    public static void update(String discordID, int guildID) {
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            Statement statement = dbConn.createStatement();
            statement.execute("UPDATE Player set GuildID='" + guildID + "' WHERE DiscordID='" + discordID + "'");
            statement.close();
            dbConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Deletes a player from the database
    public static void delete(String discordID) {
        try {
            Connection dbConn = DriverManager.getConnection("jdbc:sqlite:" + Connect.DATABASE);
            Statement statement = dbConn.createStatement();
            statement.execute("DELETE FROM Player WHERE DiscordID='" + discordID + "'");
            statement.close();
            dbConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
