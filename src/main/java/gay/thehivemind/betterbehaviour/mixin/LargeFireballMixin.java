package gay.thehivemind.betterbehaviour.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LargeFireball.class)
public class LargeFireballMixin {
    @Redirect(method = "onHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"))
    public void safelyDetonate(Level world, Entity source, double x, double y, double z, float r, boolean fire, Level.ExplosionInteraction blockInteraction) {
        world.explode(source, x, y, z, r, fire, Level.ExplosionInteraction.NONE);
    }
}
