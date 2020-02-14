package eu.endermite.jojoreference;

import eu.endermite.jojoreference.commands.JojoCommand;
import eu.endermite.jojoreference.runnables.JojoRunnables;
import org.bukkit.plugin.java.JavaPlugin;

public class JojoReference extends JavaPlugin {

    private static JojoReference plugin;
    public static JojoReference getPlugin(){ return plugin; }
    private static JojoRunnables runnables;
    public static JojoRunnables getRunnables() {return runnables;}

    public void onEnable() {
        plugin = this;
        runnables = new JojoRunnables();

        getLogger().info("You expected a reference plugin, but it was me, Dio!");
        getCommand("jojo").setExecutor(new JojoCommand());
    }
}
