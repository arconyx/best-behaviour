package gay.thehivemind.betterbehaviour.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LargeFireball.class)
public class LargeFireballMixin {
    @Redirect(method = "onHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)Lnet/minecraft/world/level/Explosion;"))
    public Explosion safelyDetonate(Level world, Entity entity, double x, double y, double z, float power, boolean createFire, Level.ExplosionInteraction explosionSourceType) {
        return world.explode(entity, x, y, z, power, createFire, Level.ExplosionInteraction.NONE);
    }
}
