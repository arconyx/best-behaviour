package gay.thehivemind.betterbehaviour.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Zombie.class)
public class ZombieMixin {
    @WrapMethod(method= "supportsBreakDoorGoal")
    public boolean beAGoodNeighbour(Operation<Boolean> original) {
        return false;
    }
}
