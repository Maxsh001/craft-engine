package net.momirealms.craftengine.bukkit.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class PaperCraftEnginePlugin extends JavaPlugin {
    private final PaperCraftEngineBootstrap bootstrap;

    public PaperCraftEnginePlugin(PaperCraftEngineBootstrap bootstrap) {
        this.bootstrap = bootstrap;
        this.bootstrap.plugin.setJavaPlugin(this);
    }

    @Override
    public void onLoad() {
        this.bootstrap.plugin.onPluginLoad();
    }

    @Override
    public void onEnable() {
        this.bootstrap.plugin.scheduler().asyncRepeating(() -> {
            Collection<? extends Player> players = Bukkit.getOnlinePlayers();
            if (players.size() > 30) {
                this.bootstrap.plugin.logger().warn("Glad to see that your server is growing!");
                this.bootstrap.plugin.logger().warn("The Community Edition supports up to 30 players. Unlock limitless potential with CraftEngine Premium:");
                this.bootstrap.plugin.logger().warn("► Unlimited player capacity");
                this.bootstrap.plugin.logger().warn("► Priority support");
                this.bootstrap.plugin.logger().warn("► Exclusive features");
            }
        }, 1, 1, TimeUnit.MINUTES);
        this.bootstrap.plugin.onPluginEnable();
        this.bootstrap.plugin.logger().warn("You're using the CraftEngine Community Edition.");
        this.bootstrap.plugin.logger().warn("This version is completely free for servers with up to 30 players.");
        this.bootstrap.plugin.logger().warn("Please consider purchasing the premium version to support CraftEngine's development.");
    }

    @Override
    public void onDisable() {
        this.bootstrap.plugin.onPluginDisable();
    }
}
