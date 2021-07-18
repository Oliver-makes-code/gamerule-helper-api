package com.github.olivermakescode.gamerulehelper;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class IntRuleHelper implements GameRuleInterface {
    private int value;
    private final int defaultValue;
    private final GameRules.Key<GameRules.IntRule> rule;

    public IntRuleHelper(String name, int defaultValue) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.rule = GameRuleRegistry.register(name, GameRules.Category.MISC, GameRuleFactory.createIntRule(defaultValue));
    }

    public IntRuleHelper(String name, int defaultValue, int min) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.rule = GameRuleRegistry.register(name, GameRules.Category.MISC, GameRuleFactory.createIntRule(defaultValue, min));
    }

    public IntRuleHelper(String name, int defaultValue, int min, int max) {
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.rule = GameRuleRegistry.register(name, GameRules.Category.MISC, GameRuleFactory.createIntRule(defaultValue, min, max));
    }

    @Override
    public void updateValue() throws NullPointerException {
        assert GameruleHelper.server != null;
        this.value = GameruleHelper.server.getGameRules().getInt(rule);
    }

    public int getValue() {
        if (GameruleHelper.server != null)
            this.updateValue();
        else this.value = this.defaultValue;
        return this.value;
    }
}
