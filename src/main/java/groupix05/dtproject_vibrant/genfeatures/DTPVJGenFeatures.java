package groupix05.dtproject_vibrant.genfeatures;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.systems.genfeatures.GenFeature;
import groupix05.dtproject_vibrant.DynamicTreesProjectVibrant;

public class DTPVJGenFeatures {

    public static final GenFeature PALM_FRUIT = new PalmFruitGenFeature(DynamicTreesProjectVibrant.location("palm_fruit"));

    public static void register(final Registry<GenFeature> registry) {
        registry.registerAll(PALM_FRUIT);
    }

}
