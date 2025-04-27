package gay.thehivemind.betterbehaviour.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {
    @WrapMethod(method="shouldBreakDoors")
    public boolean beAGoodNeighbour(Operation<Boolean> original) {
        return false;
    }
}
