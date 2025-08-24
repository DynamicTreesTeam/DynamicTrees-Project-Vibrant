package groupix05.dtproject_vibrant.init;

import com.ferreusveritas.dynamictrees.api.cells.CellKit;
import com.ferreusveritas.dynamictrees.api.registry.TypeRegistryEvent;
import com.ferreusveritas.dynamictrees.api.worldgen.FeatureCanceller;
import com.ferreusveritas.dynamictrees.blocks.leaves.LeavesProperties;
import com.ferreusveritas.dynamictrees.blocks.rootyblocks.SoilProperties;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import com.ferreusveritas.dynamictrees.systems.fruit.Fruit;
import com.ferreusveritas.dynamictrees.systems.genfeatures.GenFeature;
import com.ferreusveritas.dynamictrees.systems.pod.Pod;
import com.ferreusveritas.dynamictrees.trees.Family;
import com.ferreusveritas.dynamictrees.trees.Species;
import groupix05.dtproject_vibrant.blocks.ScruffyLeavesProperties;
import groupix05.dtproject_vibrant.cancellers.PVJFeatureCanceller;
import groupix05.dtproject_vibrant.cells.DTPVJCellKits;
import groupix05.dtproject_vibrant.fruits.*;
import groupix05.dtproject_vibrant.genfeatures.DTPVJGenFeatures;
import groupix05.dtproject_vibrant.growthlogic.DTPVJGrowthLogicKits;
import groupix05.dtproject_vibrant.DynamicTreesProjectVibrant;
import groupix05.dtproject_vibrant.trees.*;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DTPVJRegistries {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DynamicTreesProjectVibrant.MOD_ID);
    public static final RegistryObject<SoundEvent> FRUIT_BONK = registerSound("falling_fruit.bonk");

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

    public static RegistryObject<SoundEvent> registerSound (String name){
        return SOUNDS.register(name, ()-> new SoundEvent(DynamicTreesProjectVibrant.location(name)));
    }

    @SubscribeEvent
    public static void onGenFeatureRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<GenFeature> event) {
        DTPVJGenFeatures.register(event.getRegistry());
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
        event.registerType(DynamicTreesProjectVibrant.location("cobweb"), CobwebFruit.TYPE);
    }

    @SubscribeEvent
    public static void registerPodType(final TypeRegistryEvent<Pod> event) {
        event.registerType(DynamicTreesProjectVibrant.location("falling_palm"), FallingPalmPod.TYPE);
    }

    public static final FeatureCanceller PVJ_TREE_CANCELLER = new PVJFeatureCanceller<>(DynamicTreesProjectVibrant.location("tree"), BaseTreeFeatureConfig.class);

    @SubscribeEvent
    public static void onFeatureCancellerRegistry(final com.ferreusveritas.dynamictrees.api.registry.RegistryEvent<FeatureCanceller> event) {
        event.getRegistry().registerAll(PVJ_TREE_CANCELLER);
    }
}
