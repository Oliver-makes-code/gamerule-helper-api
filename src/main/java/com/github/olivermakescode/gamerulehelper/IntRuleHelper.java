package com.github.olivermakescode.gamerulehelper;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class IntRuleHelper implements GameRuleInterface {
    public static int value;
    GameRules.Key<GameRules.IntRule> rule;

    public IntRuleHelper(String name, int defaultValue) {
        value = defaultValue;
        rule = GameRuleRegistry.register(name, GameRules.Category.MISC, GameRuleFactory.createIntRule(defaultValue));
    }

    @Override
    public void updateValue(World world) {
        value = world.getGameRules().getInt(rule);
    }
}
