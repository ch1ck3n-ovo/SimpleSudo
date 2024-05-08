package tw.ch1ck3n.simplesudo;

import org.bukkit.plugin.java.JavaPlugin;
import tw.ch1ck3n.simplesudo.commands.SudoCmd;

public final class SimpleSudo extends JavaPlugin {

    public static SimpleSudo INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        this.getCommand("sudo").setExecutor(new SudoCmd());
    }

    @Override
    public void onDisable() {
        this.getCommand("sudo").setExecutor(null);
        SimpleSudo.INSTANCE.getServer().getPluginManager().removePermission("simplesudo.use");
    }
}
