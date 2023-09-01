package eu.vanish.mixin;

import net.minecraft.network.packet.s2c.play.PlayerSpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.UUID;

@Mixin(PlayerSpawnS2CPacket.class)
public interface PlayerSpawnS2CPacketAccessor {
    @Accessor("uuid")
    UUID getUUID();
}
