package me.ryert.commands;

import me.ryert.player.data.Player;
import me.ryert.utils.DatabaseManager;
import me.ryert.utils.GuildManagement;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;

/**
 * Admin Command
 * Checks for any users who aren't set up.
 *
 * @author Ryert
 */
public class RefreshData {

    //Method that gets called when command is run
    public static void run(MessageChannel channel) {
        channel.sendMessage("Scanning the player base...").queue();
        channel.sendMessage("Found " + scan() + " unregistered users.").queue();
    }

    //Scans the player base looking for unregistered users
    public static int scan() {
        int badUser = 0;
        for (Member member : GuildManagement.CONTROLLER.getGuild().getMembers()) {
            if (!DatabaseManager.isPresent(member.getUser().getId())) {
                DatabaseManager.add(member.getUser().getId(), new Player());
                badUser++;
            }
            if (member.getRoles().size() == 0)
                GuildManagement.addRole(member, "Arrival");
        }
        return badUser;
    }

}
