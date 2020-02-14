package eu.endermite.jojoreference.commands;

import eu.endermite.jojoreference.JojoReference;
import eu.endermite.jojoreference.runnables.JojoRunnables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JojoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length > 0) {
            if (args[0].equals("help")) {
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e&lDIO says:"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo help &rwill display this message"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo wryyy &rwill make everyone wryyyyyyy"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo gravity &rwill make everyone question their beliefs"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo zawarudo &rwill stop time for 10 seconds"));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo madeinheaven &rwill make an entire new universe"));
                return true;
            }

            if (args[0].equals("wryyy")) {
                if (args.length == 1) {
                    if (commandSender.hasPermission("jojo.wryyy")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.chat("Wryyyyyyyyyyyyy!");
                        }
                        return true;
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                        return true;
                    }
                } else if (args.length == 2) {
                    if (commandSender.hasPermission("jojo.wryyy.others")) {
                        if (Bukkit.getPlayer(args[1]) instanceof Player) {
                            Bukkit.getPlayer(args[1]).chat("Wryyyyyyyyyyyyy!");
                            return true;
                        } else {
                            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDidn't find a player with that name online"));
                            return true;
                        }
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                    } return true;
                } else {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThat's waaay too many arguments! Try &e/jojo wryyy [player]"));
                    return true;
                }
            }

            if (args[0].equals("gravity")) {
                if (args.length == 1) {
                    if (commandSender.hasPermission("jojo.gravity")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            new PotionEffect(PotionEffectType.getByName("LEVITATION"), 200, 0).apply(p);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDo you believe in... gravity?"));
                        }
                        return true;
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                        return true;
                    }
                } else if (args.length == 2) {
                    if (commandSender.hasPermission("jojo.gravity.others")) {
                        if (Bukkit.getPlayer(args[1]) instanceof Player) {
                            new PotionEffect(PotionEffectType.getByName("LEVITATION"), 200, 0).apply(Bukkit.getPlayer(args[1]));
                            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e" + Bukkit.getPlayer(args[1]).getDisplayName() + "'s belief in gravity was questioned."));
                            Bukkit.getPlayer(args[1]).sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDo you believe in... gravity?"));
                        } else {
                            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&eDidn't find a player with that name online"));
                            return true;
                        }
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                    } return true;
                } else {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThat's waaay too many arguments! Try &e/jojo gravity [player]"));
                    return true;
                }
            }
            if (args[0].equals("zawarudo")) {
                if (args.length == 1) {
                    if (commandSender.hasPermission("jojo.zawarudo")) {
                        JojoReference.getRunnables().zaWarudoRunnable();
                        return true;
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                        return true;
                    }
                } else {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThat's waaay too many arguments! Try &e/jojo gravity [player]"));
                    return true;
                }
            }
            if (args[0].equals("madeinheaven")) {
                if (args.length == 1) {
                    if (commandSender.hasPermission("jojo.madeinheaven")) {
                            JojoReference.getRunnables().madeInHeavenRunnable();
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&eMade in Heaven begins to take effect..."));
                        return true;
                    } else {
                        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cI'm sorry, but I can't let you do that"));
                        return true;
                    }
                } else {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThat's waaay too many arguments! Try &e/jojo gravity [player]"));
                    return true;
                }
            }
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cNo such command. Try &e/jojo help"));
            return true;
        }
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e&lDIO says:"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo help &rwill display this message"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo wryyy &rwill make everyone wryyyyyyy"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo gravity &rwill make everyone question their beliefs"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo zawarudo &rwill stop time for 10 seconds"));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&' ,"&e/jojo madeinheaven &rwill make an entire new universe"));
        return true;
    }
}
