package com.github.olivermakescode.gamerulehelper;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class BoolRuleHelper implements GameRuleInterface {
    private boolean value;
    private GameRules.Key<GameRules.BooleanRule> rule;

    public BoolRuleHelper(String name, boolean defaultValue) {
        this.value = defaultValue;
        this.rule = GameRuleRegistry.register(name, GameRules.Category.MISC, GameRuleFactory.createBooleanRule(defaultValue));
    }

    @Override
    public void updateValue(World world) {
        this.value = world.getGameRules().getBoolean(this.rule);
    }

    public boolean getValue() {
        return this.value;
    }
}
