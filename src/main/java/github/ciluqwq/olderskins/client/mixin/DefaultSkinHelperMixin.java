package github.ciluqwq.olderskins.client.mixin;

import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(DefaultSkinHelper.class)
public class DefaultSkinHelperMixin {
    @Shadow @Final private static SkinTextures[] SKINS;
    @Inject(at = @At("HEAD"), method = "getSkinTextures(Ljava/util/UUID;)Lnet/minecraft/client/util/SkinTextures;",cancellable = true)
    private static void getSkinTextures(UUID uuid, CallbackInfoReturnable<SkinTextures> cir) {
        if(Math.floorMod(uuid.hashCode(), SKINS.length)<=10){
            cir.setReturnValue(SKINS[15]);
        }else{
            cir.setReturnValue(SKINS[0]);
        }
    }
}

