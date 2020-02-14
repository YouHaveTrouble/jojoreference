package eu.endermite.jojoreference.runnables;

import eu.endermite.jojoreference.JojoReference;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class JojoRunnables {

    public void madeInHeavenRunnable() {
        new BukkitRunnable() {
            double i = 2;
            int c = 0;
            @Override
            public void run() {
                c +=1;
                i = i*1.1;
                for (Player p : Bukkit.getOnlinePlayers()) {

                    p.getPlayer().setPlayerTime((long) i,false);
                }
                if (c > 200) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.getPlayer().resetPlayerTime();
                    }
                    cancel();
                }
            }
            }.runTaskTimerAsynchronously(JojoReference.getPlugin(), 1, 4);
    }
    public void zaWarudoRunnable() {
        new BukkitRunnable() {
            int c = 0;
            @Override
            public void run() {
                c +=1;
                for (World w : Bukkit.getWorlds()) {
                    for (LivingEntity e : w.getLivingEntities()) {
                        if (e instanceof Player) {
                            Player p = ((Player) e).getPlayer();
                            if (!p.hasPermission("jojo.zawarudo.bypass")) {
                                p.setWalkSpeed(0);
                                new PotionEffect(PotionEffectType.getByName("JUMP"), 21, 250).apply(p);
                                new PotionEffect(PotionEffectType.getByName("WEAKNESS"), 21, 250).apply(p);
                            }
                        } else {
                            e.setAI(false);
                        }
                    }
                }
                if (c == 1) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"One second has passed..."));
                }
                if (c == 2) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Two seconds has passed..."));
                }
                if (c == 3) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Three seconds has passed..."));
                }
                if (c == 4) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Four seconds has passed..."));
                }
                if (c == 5) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Five seconds has passed..."));
                }
                if (c == 6) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Six seconds has passed..."));
                }
                if (c == 7) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Seven seconds has passed..."));
                }
                if (c == 8) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Eight seconds has passed..."));
                }
                if (c == 9) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Nine seconds has passed..."));
                }
                if (c == 10) {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Ten seconds has passed!"));
                }
                if (c > 10) {

                    for (World w : Bukkit.getWorlds()) {
                        for (LivingEntity e : w.getLivingEntities()) {
                            if (e instanceof Player) {
                                Player p = ((Player) e).getPlayer();
                                p.setWalkSpeed(0.2F);
                            } else {
                                e.setAI(true);
                            }
                        }
                    }
                    cancel();
                }
            }
        }.runTaskTimer(JojoReference.getPlugin(), 0, 20);
    }

}
