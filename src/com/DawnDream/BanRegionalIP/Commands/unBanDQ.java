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

public class unBanDQ extends Command {
    public unBanDQ() {
        super("unBanRegional" , "com.DawnDream.BanRegionalIP.admin" , "unban-dq" , "unbanDQ");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings.length != 2) {
            commandSender.sendMessage(ChatColor.RED + "[BanRegionalIP] 参数错误！请输入 /BanDQ help 查看帮助");
        }else {
            Configuration configuration = new Configuration();
            try {
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(main.pl.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            List list = configuration.getStringList("BanList");
            if (strings[0].equals("ip")){
                String str = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]);
                if (list.isEmpty()){
                    commandSender.sendMessage("[BanRegionalIP] 该 ip 从未封禁");
                }else{
                    Boolean b = false;
                    for (int i = 0 ; i <= list.size()-1 ; i++){
                        if (list.get(i).equals(str)){
                            b = true;
                        }
                    }
                    if (b){
                        list.remove(str);
                        commandSender.sendMessage("[BanRegionalIP] 已解封 " + str + " 区域内所有IP!");
                        System.out.println("[BanRegionalIP] 已解封 " + str + " 区域内所有IP!");
                    }else{
                        commandSender.sendMessage("[BanRegionalIP] 该 ip 从未封禁");
                    }
                }

            }else if (strings[0].equals("dq") || strings[0].equals("regional")){
                String str = strings[1];
                if (list.isEmpty()){
                    commandSender.sendMessage("[BanRegionalIP] 该 ip 从未封禁");
                }else{
                    Boolean b = false;
                    for (int i = 0 ; i <= list.size()-1 ; i++){
                        if (list.get(i).equals(str)){
                            b = true;
                        }
                    }
                    if (b){
                        list.remove(str);
                        commandSender.sendMessage("[BanRegionalIP] 已解封 " + str + " 区域内所有IP!");
                        System.out.println("[BanRegionalIP] 已解封 " + str + " 区域内所有IP!");
                    }else{
                        commandSender.sendMessage("[BanRegionalIP] 该 ip 从未封禁");
                    }
                }

            }else {
                commandSender.sendMessage(ChatColor.RED + "[BanRegionalIP] 参数错误！请输入 /BanDQ help 查看帮助");
            }
            configuration.set("BanList" , list);
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(main.pl.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
