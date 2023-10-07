package be.florens.espressotest.mixin;

import net.minecraft.util.profiling.jfr.JvmProfiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;

@Mixin(JvmProfiler.class)
public interface JvmProfilerMixin {

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE",
            target = "Ljava/lang/ModuleLayer;findModule(Ljava/lang/String;)Ljava/util/Optional;"))
    private static Optional<?> disableJfr(ModuleLayer instance, String name) {
        return Optional.empty();
    }
}
