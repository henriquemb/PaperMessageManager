package com.github.henriquemb.papermessagemanager.manager;

import com.github.henriquemb.papermessagemanager.enums.Action;
import com.github.henriquemb.papermessagemanager.enums.ColorCodeLegacy;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageManager {
    private final String[] permissions;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public MessageManager(String[] permissions) {
        this.permissions = permissions;
    }

    public void sendMessage(CommandSender player, CommandSender target, String message) {
        message = ColorCodeLegacy.translateLegacyCodes(message);

        Component component = miniMessage.deserialize(message);

        target.sendMessage(component);
    }

    public void sendActionBar(CommandSender player, CommandSender target, String message) {
        message = processMessage(player, target, message);

        Component component = miniMessage.deserialize(message);

        player.sendActionBar(component);
    }

    private String processMessage(CommandSender player, CommandSender target, String message) {
        message = ColorCodeLegacy.translateLegacyCodes(message);
        message = replaceActions(player, message);
        message = PlaceholderAPI.setPlaceholders((Player) target, message);

        return message;
    }

    private String replaceActions(CommandSender player, String message) {
        if (hasPermission(player))
            return message;

        return Action.replaceAllActions(message);
    }

    private boolean hasPermission(CommandSender player) {
        for (String permission : permissions) {
            if (player.hasPermission(permission)) {
                return true;
            }
        }
        return false;
    }
}
