package com.github.olivermakescode.gamerulehelper.mixin;

import com.github.olivermakescode.gamerulehelper.GameRuleInterface;
import com.github.olivermakescode.gamerulehelper.GameruleHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class UpdateGrMixin {
    @Inject(at=@At("HEAD"),method="tick")
    public void updateGR(CallbackInfo info) {
        World world = ((PlayerEntity)(Object)this).world;
        for (GameRuleInterface i : GameruleHelper.rules) {
            i.updateValue(world);
        }
    }
}
