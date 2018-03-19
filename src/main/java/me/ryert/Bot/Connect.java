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

public class Connect {

    //Log variable
    private static final Logger log = LoggerFactory.getLogger(Connect.class);

    //Prefix for commands
    public static final String PREFIX = "++";

    //JDA instance
    private static JDA discord = null;

    //Connects the bot to discord
    public static void main(String[] args) throws LoginException, InterruptedException {
        discord = new JDABuilder(AccountType.BOT)
                .setGame(Game.playing("Type ++start to Join!"))
                .setToken(Config.DISCORD_TOKEN)
                .addEventListener(new MyListener())
                .buildBlocking();
    }
}
