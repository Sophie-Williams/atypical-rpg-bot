package me.ryert.utils;

import me.ryert.bot.Connect;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
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

        //Cleans prefix
        if (content.indexOf(Connect.PREFIX) == 0)
            content = content.replaceFirst(Connect.PREFIX, "");
        else
            return;

        //TODO: Add Commands and hierarchy
    }
}
