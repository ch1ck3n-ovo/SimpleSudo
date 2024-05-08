package tw.ch1ck3n.simplesudo.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.ch1ck3n.simplesudo.SimpleSudo;

public final class SudoCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("simplesudo.use")) return true;
        Bukkit.getScheduler().runTask(SimpleSudo.INSTANCE, () -> {
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                String space = (sender instanceof Player ? "                " : "            ");  // Chat 16, Console 12
                sender.sendMessage(("&7[&a" + SimpleSudo.INSTANCE.getName() + "&7]" + " &cInvalid player: &e&n" + args[0] +
                        "&r\n" + space + "&cReason: &eOffline&7/&eInvalid name&7.").replace("&", "§"));
                return;
            }
            String message = "";
            for (String arg: args) message += " " + arg;
            message = message.replaceFirst(" " + player.getName(), "").substring(1);
            player.chat(message);
        });
        return true;
    }
}
