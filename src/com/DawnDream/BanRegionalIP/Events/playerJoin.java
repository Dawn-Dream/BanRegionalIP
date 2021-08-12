package com.DawnDream.BanRegionalIP.Events;

import com.DawnDream.BanRegionalIP.getIpRegional.getIp;
import com.DawnDream.BanRegionalIP.main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class playerJoin implements Listener {
    @EventHandler
    public void playerJoin(PostLoginEvent event){
        Configuration configuration = new Configuration();
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(main.pl.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List list = configuration.getStringList("BanList");
        ProxiedPlayer player = event.getPlayer();
        String str = player.getSocketAddress().toString();
        int i = str.indexOf(":");
        str = str.substring(0,i);
        String dq = getIp.ipSite(str);
        for (int i1 = 0; i1 <= list.size()-1 ; i1 ++){
            if (list.get(i1).equals(dq)){
                player.disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" + str + "\n您的地区：" + dq);
            }
        }
    }
}
