package groupix05.dtproject_vibrant.growthlogic;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import groupix05.dtproject_vibrant.DynamicTreesProjectVibrant;
import net.minecraft.util.ResourceLocation;

public class DTPVJGrowthLogicKits {

    public static final GrowthLogicKit MAPLE = new MapleLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "maple"));
    public static final GrowthLogicKit TAPERED = new TaperedLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "tapered"));
    public static final GrowthLogicKit DIAGONAL_PALM = new DiagonalPalmLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "diagonal_palm"));
    public static final GrowthLogicKit REDWOOD = new RedwoodLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "redwood"));
    public static final GrowthLogicKit SMALL_REDWOOD = new SmallRedwoodLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "small_redwood"));
    public static final GrowthLogicKit BAOBAB = new BaobabLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "baobab"));
    public static final GrowthLogicKit VARIATE_HEIGHT = new VariateHeightLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "variate_height"));
    public static final GrowthLogicKit WILLOW = new WillowLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "willow"));
    public static final GrowthLogicKit JUNIPER = new JuniperLogic(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "juniper"));

    public static void register(final Registry<GrowthLogicKit> registry) {
        registry.registerAll(MAPLE, DIAGONAL_PALM, REDWOOD, SMALL_REDWOOD,
                BAOBAB, VARIATE_HEIGHT, WILLOW, TAPERED, JUNIPER);
    }

}
