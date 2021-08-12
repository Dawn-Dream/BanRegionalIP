package com.DawnDream.BanRegionalIP;

import com.DawnDream.BanRegionalIP.Commands.BanDQ;
import com.DawnDream.BanRegionalIP.Commands.getBanList;
import com.DawnDream.BanRegionalIP.Commands.unBanDQ;
import com.DawnDream.BanRegionalIP.Events.playerJoin;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.*;

public class main extends Plugin {
    public static Plugin pl;

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        pl = this;
        getProxy().getPluginManager().registerCommand(this, new BanDQ());
        getProxy().getPluginManager().registerCommand(this, new unBanDQ());
        getProxy().getPluginManager().registerCommand(this, new getBanList());
        getProxy().getPluginManager().registerListener(this, new playerJoin());
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

