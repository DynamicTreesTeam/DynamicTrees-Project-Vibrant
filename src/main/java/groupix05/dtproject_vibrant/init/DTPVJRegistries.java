package groupix05.dtproject_vibrant.init;

import com.ferreusveritas.dynamictrees.api.cells.CellKit;
import com.ferreusveritas.dynamictrees.api.registry.TypeRegistryEvent;
import com.ferreusveritas.dynamictrees.api.worldgen.FeatureCanceller;
import com.ferreusveritas.dynamictrees.blocks.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.blocks.rootyblocks.SoilProperties;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.genfeatures.GenFeature;
import com.ferreusveritas.dynamictrees.trees.Family;
import com.ferreusveritas.dynamictrees.trees.Species;
import groupix05.dtproject_vibrant.blocks.ScruffyLeavesProperties;
import groupix05.dtproject_vibrant.cancellers.PVJFeatureCanceller;
import groupix05.dtproject_vibrant.cells.DTPVJCellKits;
import groupix05.dtproject_vibrant.growthlogic.DTPVJGrowthLogicKits;
import groupix05.dtproject_vibrant.DynamicTreesProjectVibrant;
import groupix05.dtproject_vibrant.trees.*;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DTPVJRegistries {

    public static void setup() {
    }

    public static void setupBlocks() {
        setUpSoils();
        setupConnectables();
    }

    private static void setUpSoils() {
    }

    private static void setupConnectables() {
    }

    @SubscribeEvent
    public static void onGenFeatureRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<GenFeature> event) {
        //DTBYGGenFeatures.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onCellKitRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<CellKit> event) {
        DTPVJCellKits.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onGrowthLogicKitRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<GrowthLogicKit> event) {
        DTPVJGrowthLogicKits.register(event.getRegistry());
    }


    @SubscribeEvent
    public static void registerSpeciesTypes(final TypeRegistryEvent<Species> event) {
        event.registerType(DynamicTreesProjectVibrant.location("mangrove"), MangroveSpecies.TYPE);
        event.registerType(DynamicTreesProjectVibrant.location("generates_underwater"), GenUnderwaterSpecies.TYPE);
    }

    @SubscribeEvent
    public static void registerFamilyTypes(final TypeRegistryEvent<Family> event) {
        event.registerType(DynamicTreesProjectVibrant.location("diagonal_palm"), DiagonalPalmFamily.TYPE);
    }

    @SubscribeEvent
    public static void registerLeavesPropertiesTypes(final TypeRegistryEvent<LeavesProperties> event) {
        event.registerType(DynamicTreesProjectVibrant.location("scruffy"), ScruffyLeavesProperties.TYPE);
    }

    @SubscribeEvent
    public static void registerSoilPropertiesTypes(final TypeRegistryEvent<SoilProperties> event) {
    }

    @SubscribeEvent
    public static void registerFruitTypes(final TypeRegistryEvent<Fruit> event) {
    }

    public static final FeatureCanceller PVJ_TREE_CANCELLER = new PVJFeatureCanceller<>(DynamicTreesProjectVibrant.location("tree"), BaseTreeFeatureConfig.class);

    @SubscribeEvent
    public static void onFeatureCancellerRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<FeatureCanceller> event) {
        event.getRegistry().registerAll(PVJ_TREE_CANCELLER);
    }
}
