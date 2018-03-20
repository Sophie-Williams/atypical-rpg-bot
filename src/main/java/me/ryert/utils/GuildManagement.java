package me.ryert.utils;

import me.ryert.bot.Connect;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.managers.GuildController;

/**
 * Designed to manage the guild workings with helpful methods
 * @author Ryert
 */
public class GuildManagement {

    //Guild Controller with main guild
    public static final GuildController CONTROLLER = new GuildController(Connect.discord.getGuildById(Config.GUILD_ID));

    //Adds specified role to player
    public static void addRole(Member member, String roleName) {
        CONTROLLER.addRolesToMember(member, Connect.discord.getRolesByName(roleName, true)).queue();

    }
}
