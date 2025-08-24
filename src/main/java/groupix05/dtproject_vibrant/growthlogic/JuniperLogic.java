package groupix05.dtproject_vibrant.growthlogic;

import com.ferreusveritas.dynamictrees.api.TreeHelper;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKitConfiguration;
import com.ferreusveritas.dynamictrees.growthlogic.context.DirectionManipulationContext;
import com.ferreusveritas.dynamictrees.systems.GrowSignal;
import com.ferreusveritas.dynamictrees.util.CoordUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockState;

public class JuniperLogic extends GrowthLogicKit {

    private static final Direction[] HORIZONTALS = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    public JuniperLogic(ResourceLocation registryName) {
        super(registryName);
    }

    @Override
    public int[] populateDirectionProbabilityMap(GrowthLogicKitConfiguration configuration, DirectionManipulationContext context) {
        int[] probMap = context.probMap();
        Direction originDir = context.signal().dir.getOpposite();

        // Apply default chances for each non-origin direction
        for (Direction dir : Direction.values()) {
            if (dir != originDir) {
                BlockPos deltaPos = context.pos().relative(dir);
                // Check probability for surrounding blocks.
                // Typically, Air: 1, Leaves: 2, Branches: 2 + radius
                BlockState deltaBlockState = context.world().getBlockState(deltaPos);
                probMap[dir.get3DDataValue()] += TreeHelper.getTreePart(deltaBlockState)
                        .probabilityForBlock(deltaBlockState, context.world(), deltaPos, context.branch());
            }
        }

        GrowSignal signal = context.signal();
        int deltaY = Math.abs(signal.delta.getY());
        int distFromTrunk = Math.max(Math.abs(signal.delta.getX()), Math.abs(signal.delta.getZ()));
        float horizontalMultiplier = signal.isInTrunk() ? 1F : 1F / distFromTrunk;

        // Increase chance of branching out with height
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            probMap[dir.get3DDataValue()] *= deltaY * horizontalMultiplier;
        }

        if (!signal.isInTrunk()) {
            // Increase chance of going up with distance from trunk
            if (originDir != Direction.UP) {
                probMap[Direction.UP.get3DDataValue()] += distFromTrunk * 2;
            }
            // No chance of going down
            probMap[Direction.DOWN.get3DDataValue()] = 0;
        } else {
            probMap[Direction.UP.get3DDataValue()] *= 2;
        }

        // Scale down other horizontal directions
        for (int i = 2; i < 6; i++) {
            probMap[i] *= 0.5;
        }
        // Scale up direction with bias
        probMap[getDirectionBias(signal.rootPos).get3DDataValue()] *= 8;

        return probMap;
    }

    private static Direction getDirectionBias(BlockPos rootPos) {
        return HORIZONTALS[CoordUtils.coordHashCode(rootPos, 0) % 4];
    }

}
