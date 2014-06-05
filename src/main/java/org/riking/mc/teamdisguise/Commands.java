package org.riking.mc.teamdisguise;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

import static org.riking.mc.teamdisguise.TeamDisguise.*;

public class Commands implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();
        Player player = (Player) sender;

        ChatColor color;
        GameProfile handle;
        if (cmd.equals("red")) {
            color = ChatColor.RED;
            handle = makeGameProfile(player, redBlob, redSig);
        } else if (cmd.equals("green")) {
            color = ChatColor.GREEN;
            handle = makeGameProfile(player, grnBlob, grnSig);
        } else if (cmd.equals("yellow")) {
            color = ChatColor.YELLOW;
            handle = makeGameProfile(player, yloBlob, yloSig);
        } else if (cmd.equals("blue")) {
            color = ChatColor.BLUE;
            handle = makeGameProfile(player, bluBlob, bluSig);
        } else {
            return false;
        }

        PlayerDisguise disguise = new PlayerDisguise(player.getName());
        disguise.setGameProfileRaw(WrappedGameProfile.fromHandle(handle));

        DisguiseAPI.disguiseToAll(player, disguise);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
