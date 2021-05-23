package com.github.olivermakescode.gamerulehelper;

import net.minecraft.world.World;

public interface GameRuleInterface {

    default void updateValue(World world) {}

}
