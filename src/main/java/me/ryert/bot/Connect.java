package me.ryert.bot;

import me.ryert.utils.Config;
import me.ryert.utils.MyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    //Log variable
    private static final Logger log = LoggerFactory.getLogger(Connect.class);

    //Prefix for commands
    public static final String PREFIX = "++";

    //JDA instance
    public static JDA discord = null;

    //Connection object to hold database
    public static Connection connection;

    //Connects the bot to discord
    public static void main(String[] args) throws LoginException, InterruptedException {
        discord = new JDABuilder(AccountType.BOT)
                .setGame(Game.playing("Type ++start to Join!"))
                .setToken(Config.DISCORD_TOKEN)
                .addEventListener(new MyListener())
                .buildBlocking();
    }

    //Connects to our info database
    static {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\databases\\PlayerData.db");
        } catch (SQLException e) {
            System.out.println("DataBase Issue: " + e.getMessage());
        }
    }
}
