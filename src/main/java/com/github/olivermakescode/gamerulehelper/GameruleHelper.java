package com.github.olivermakescode.gamerulehelper;

import java.util.Arrays;

public class GameruleHelper {
    public static GameRuleInterface[] rules = {};

    public static GameRuleInterface register(String name, boolean defaultValue) {
        GameRuleInterface rule = new BoolRuleHelper(name, defaultValue);
        rules = Arrays.copyOf(rules, rules.length+1);
        rules[rules.length-1] = rule;
        return rule;
    }

    public static GameRuleInterface register(String name, int defaultValue) {
        GameRuleInterface rule = new IntRuleHelper(name, defaultValue);
        rules = Arrays.copyOf(rules, rules.length+1);
        rules[rules.length-1] = rule;
        return rule;
    }
}
