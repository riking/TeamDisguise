package org.riking.mc.teamdisguise;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import me.libraryaddict.disguise.utilities.DisguiseUtilities;
import net.minecraft.util.com.mojang.authlib.GameProfile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
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

        PlayerDisguise disguise = new PlayerDisguise(color.toString() + player.getName());
        try {
            Field gameProfile = PlayerDisguise.class.getDeclaredField("gameProfile");
            gameProfile.setAccessible(true);
            gameProfile.set(disguise, WrappedGameProfile.fromHandle(handle));
            Field skinToUse = PlayerDisguise.class.getDeclaredField("skinToUse");
            skinToUse.setAccessible(true);
            skinToUse.set(disguise, "Notch");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        DisguiseAPI.disguiseToAll(player, disguise);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
