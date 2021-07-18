package com.github.olivermakescode.gamerulehelper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class GameruleHelper implements ModInitializer {
    @Override
    public void onInitialize() {
        start();
    }

    @Nullable
    public static MinecraftServer server;

    public static Map<String,GameRuleInterface> rules;

    public static void start() {
        ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> {
            server = minecraftServer;
        });
        ServerLifecycleEvents.SERVER_STOPPING.register(minecraftServer -> {
            server = null;
        });
    }

    public static GameRuleInterface register(String name, boolean defaultValue) {
        GameRuleInterface rule = new BoolRuleHelper(name, defaultValue);
        rules.put(name,rule);
        return rule;
    }

    public static GameRuleInterface register(String name, int defaultValue) {
        GameRuleInterface rule = new IntRuleHelper(name, defaultValue);
        rules.put(name,rule);
        return rule;
    }

    public static GameRuleInterface register(String name, int defaultValue, int min) {
        GameRuleInterface rule = new IntRuleHelper(name, defaultValue, min);
        rules.put(name,rule);
        return rule;
    }

    public static GameRuleInterface register(String name, int defaultValue, int min, int max) {
        GameRuleInterface rule = new IntRuleHelper(name, defaultValue, min, max);
        rules.put(name,rule);
        return rule;
    }
}
