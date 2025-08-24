package groupix05.dtproject_vibrant.cells;

import com.ferreusveritas.dynamictrees.util.SimpleVoxmap;
import net.minecraft.util.math.BlockPos;

public class DTPVJLeafClusters {

    public static final SimpleVoxmap SPARSE = new SimpleVoxmap(3, 2, 3, new byte[] {
            0, 1, 0,
            1, 0, 1,
            0, 1, 0,

            0, 0, 0,
            0, 1, 0,
            0, 0, 0
    }).setCenter(new BlockPos(1, 0, 1));

    public static final SimpleVoxmap WILLOW = new SimpleVoxmap(5, 4, 5, new byte[]{
            //Layer 0 (Bottom)
            0, 0, 0, 0, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 0, 0, 0, 0,

            //Layer 1
            0, 1, 1, 1, 0,
            1, 3, 4, 3, 1,
            1, 4, 0, 4, 1,
            1, 3, 4, 3, 1,
            0, 1, 1, 1, 0,

            //Layer 2
            0, 1, 1, 1, 0,
            1, 2, 3, 2, 1,
            1, 3, 4, 3, 1,
            1, 2, 3, 2, 1,
            0, 1, 1, 1, 0,

            //Layer 3(Top)
            0, 0, 0, 0, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 0, 0, 0, 0

    }).setCenter(new BlockPos(2, 1, 2));

    public static final SimpleVoxmap ROUND_CONIFER = new SimpleVoxmap(3, 2, 3, new byte[] {
            1, 2, 1,
            2, 0, 2,
            1, 2, 1,

            0, 1, 0,
            1, 1, 1,
            0, 1, 0
    }).setCenter(new BlockPos(1, 0, 1));

    public static final SimpleVoxmap JUNIPER = new SimpleVoxmap(5, 4, 5, new byte[]{
            //Layer 0 (Bottom)
            0, 0, 0, 0, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 1, 1, 1, 0,
            0, 0, 0, 0, 0,

            //Layer 1
            0, 1, 1, 1, 0,
            1, 2, 3, 2, 1,
            1, 3, 0, 3, 1,
            1, 2, 3, 2, 1,
            0, 1, 1, 1, 0,

            //Layer 2
            0, 0, 1, 0, 0,
            0, 1, 2, 1, 0,
            1, 2, 3, 2, 1,
            0, 1, 2, 1, 0,
            0, 0, 1, 0, 0,

            //Layer 3(Top)
            0, 0, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 1, 1, 1, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 0, 0,

    }).setCenter(new BlockPos(2, 1, 2));

}
