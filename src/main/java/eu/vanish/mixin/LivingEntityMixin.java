package eu.vanish.mixin;

import eu.vanish.Vanish;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Redirect(method = "fall", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isAir()Z"))
    public boolean xParticlesInVanish(BlockState instance) {
        //noinspection ConstantValue
        if ((Object) this instanceof ServerPlayerEntity && Vanish.INSTANCE.vanishedPlayers.isVanished((ServerPlayerEntity) (Object) this)) {
            return true;
        }
        return instance.isAir();
    }
}
