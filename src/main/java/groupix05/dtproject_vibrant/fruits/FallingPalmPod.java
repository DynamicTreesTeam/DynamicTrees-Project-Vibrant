package groupix05.dtproject_vibrant.fruits;

import com.ferreusveritas.dynamictrees.api.registry.TypedRegistry;
import com.ferreusveritas.dynamictrees.blocks.PodBlock;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import groupix05.dtproject_vibrant.blocks.FallingPodBlock;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class FallingPalmPod extends Pod {

    public static final TypedRegistry.EntryType<Pod> TYPE = TypedRegistry.newType(FallingPalmPod::new);

    public FallingPalmPod(ResourceLocation registryName) {
        super(registryName);
    }

    protected PodBlock createBlock(Block.Properties properties) {
        return new FallingPodBlock(properties, this);
    }

}
