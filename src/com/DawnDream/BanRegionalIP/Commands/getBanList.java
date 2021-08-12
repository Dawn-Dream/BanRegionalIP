package com.DawnDream.BanRegionalIP.Commands;

import com.DawnDream.BanRegionalIP.main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class getBanList extends Command {
    public getBanList() {
        super("getBanDQList" , "com.DawnDream.BanRegionalIP.admin" , "BanDQList");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        Configuration configuration = new Configuration();
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(main.pl.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = configuration.getStringList("BanList");
        commandSender.sendMessage(ChatColor.GOLD + "已被封禁的地区：");
        for (int i = 0 ; i <= list.size() - 1 ; i++){
            commandSender.sendMessage(ChatColor.GOLD + list.get(i));
        }
    }
}

