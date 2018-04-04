package me.ryert.utils;

import me.ryert.bot.Connect;
import me.ryert.player.classes.Warrior;
import me.ryert.player.data.Inventory;
import me.ryert.player.data.Player;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MyListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        //Disregard potential bots' commands
        if (event.getAuthor().isBot())
            return;

        //Gets the channel that requested the command
        MessageChannel channel = event.getChannel();

        //Gets the message
        Message message = event.getMessage();
        String content = message.getContentRaw();

        //Checks for prefix
        if (content.indexOf(Connect.PREFIX) == 0)
            content = content.replaceFirst(Connect.PREFIX, "");
        else
            return;
    }

    //Sets up the new player's data
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        GuildManagement.addRole(event.getMember(), "Arrival");
        if (DatabaseManager.lookup(event.getUser().getId()) == null)
            DatabaseManager.add(event.getMember().getUser().getId(), new Player(), new Inventory(7));
    }

    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        //TODO: Move the user to a tobepurged table
    }
}
