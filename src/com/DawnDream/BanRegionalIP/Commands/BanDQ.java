package com.DawnDream.BanRegionalIP.Commands;

import com.DawnDream.BanRegionalIP.main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BanDQ extends Command {
    public BanDQ() {
        super("BanRegional" , "com.DawnDream.BanRegionalIP.admin" , "ban-dq" , "banDQ");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(strings.length != 2 || strings[0].equals("help")){
            commandSender.sendMessage(ChatColor.GOLD
                    + "———————— BanRegionalIP help ————————\n"
                    + "/BanDQ [ip/player] [ip地址/PlayerName]\n"
                    + "/unBanDQ [ip/dq] [ip地址/地区名]\n"
                    + "/BanDqList");
        }else{
            Configuration configuration = new Configuration();
            try {
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(main.pl.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            List list = configuration.getStringList("BanList");
            if(strings[0].equals("ip")){
                if (list.isEmpty()){

                    Collection<ProxiedPlayer> players = main.pl.getProxy().getPlayers();
                    ProxiedPlayer[] a = new ProxiedPlayer[0];
                    ProxiedPlayer[] proxiedPlayers = players.toArray(a);
                    for (int i = 0 ; i <= proxiedPlayers.length - 1 ; i ++){
                        String address = proxiedPlayers[i].getSocketAddress().toString();
                        address = address.substring(0 , address.indexOf(":"));
                        String dq1 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(address);
                        String dq2 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]);
                        if (dq1.equals(dq2)){
                            proxiedPlayers[i].disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" +  address + "\n您的地区：" + dq1);
                        }
                    }
                    list.add(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]));
                    commandSender.sendMessage("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]) + " 区域内所有IP!");
                    System.out.println("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]) + " 区域内所有IP!");

                }else{
                    Boolean b = false;
                    for (int i = 0 ; i <= list.size()-1 ; i++){
                        if (list.get(i).equals(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]))){
                            b = true;
                        }
                    }
                    if (!b){
                        Collection<ProxiedPlayer> players = main.pl.getProxy().getPlayers();
                        ProxiedPlayer[] a = new ProxiedPlayer[0];
                        ProxiedPlayer[] proxiedPlayers = players.toArray(a);
                        for (int i = 0 ; i <= proxiedPlayers.length - 1 ; i ++){
                            String address = proxiedPlayers[i].getSocketAddress().toString();
                            address = address.substring(address.indexOf(":")).replace("/" , "");
                            String dq1 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(address);
                            String dq2 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]);
                            if (dq1.equals(dq2)){
                                proxiedPlayers[i].disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" +  address + "\n您的地区：" + dq1);
                            }
                        }
                        list.add(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]));
                        commandSender.sendMessage("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]) + " 区域内所有IP!");
                        System.out.println("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(strings[1]) + " 区域内所有IP!");
                    }else{
                        commandSender.sendMessage("[BanRegionalIP] 已存在此区域！");
                    }
                }

            }else if (strings[0].equals("player")){
                ProxiedPlayer player = main.pl.getProxy().getPlayer(strings[1]);
                if (player == null){
                    commandSender.sendMessage(ChatColor.RED + "[BanRegionalIP] 玩家不存在！");
                }else{
                    String str = player.getSocketAddress().toString();
                    int i1 = str.indexOf(":");
                    str = str.substring(0,i1);

                    if (list.isEmpty()){
                        Collection<ProxiedPlayer> players = main.pl.getProxy().getPlayers();
                        ProxiedPlayer[] a = new ProxiedPlayer[0];
                        ProxiedPlayer[] proxiedPlayers = players.toArray(a);
                        for (int i = 0 ; i <= proxiedPlayers.length - 1 ; i ++){
                            String address = proxiedPlayers[i].getSocketAddress().toString();
                            address = address.substring(address.indexOf(":")).replace("/" , "");
                            String dq1 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(address);
                            String dq2 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str);
                            if (dq1.equals(dq2)){
                                proxiedPlayers[i].disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" +  address + "\n您的地区：" + dq1);
                            }
                        }
                        list.add(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str));
                        commandSender.sendMessage("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str) + " 区域内所有IP!");
                        System.out.println("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str) + " 区域内所有IP!");
                        
                    }else {
                        Boolean b = false;
                        for (int i = 0 ; i <= list.size()-1 ; i++){
                            if (list.get(i).equals(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str))){
                                b = true;
                            }
                        }
                        if (!b){
                            Collection<ProxiedPlayer> players = main.pl.getProxy().getPlayers();
                            ProxiedPlayer[] a = new ProxiedPlayer[0];
                            ProxiedPlayer[] proxiedPlayers = players.toArray(a);
                            for (int i = 0 ; i <= proxiedPlayers.length - 1 ; i ++){
                                String address = proxiedPlayers[i].getSocketAddress().toString();
                                address = address.substring(address.indexOf(":")).replace("/" , "");
                                String dq1 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(address);
                                String dq2 = com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str);
                                if (dq1.equals(dq2)){
                                    proxiedPlayers[i].disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" +  address + "\n您的地区：" + dq1);
                                }
                            }
                            list.add(com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str));
                            player.disconnect(ChatColor.RED + "您所在的地区已被服务器封禁！\n" + ChatColor.GOLD + "您的IP地址：" + str + "\n您的地区：" + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str));
                            commandSender.sendMessage("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str) + " 区域内所有IP!");
                            System.out.println("[BanRegionalIP] 已封禁 " + com.DawnDream.BanRegionalIP.getIpRegional.getIp.ipSite(str) + " 区域内所有IP!");
                        }else{
                            commandSender.sendMessage("[BanRegionalIP] 已存在此区域！");
                        }
                    }

                }
            }else if (strings[0].equals("help")){
                commandSender.sendMessage(ChatColor.GOLD + "———————————— BanRegionalIP help ————————————\n"
                                                            + "/BanRegional [ip/player] [ip地址/playerName]\n"
                                                            + "/unBanRegional [ip/dq] [ip地址/地区名]");
            }else{
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
