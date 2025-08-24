package groupix05.dtproject_vibrant.cells;

import com.ferreusveritas.dynamictrees.api.cells.CellKit;
import com.ferreusveritas.dynamictrees.api.cells.CellNull;
import com.ferreusveritas.dynamictrees.api.cells.Cell;
import com.ferreusveritas.dynamictrees.api.cells.CellSolver;
import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.cells.*;
import com.ferreusveritas.dynamictrees.util.SimpleVoxmap;
import groupix05.dtproject_vibrant.DynamicTreesProjectVibrant;
import groupix05.dtproject_vibrant.cells.cell.*;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

public class DTPVJCellKits {

    public static void register(final Registry<CellKit> registry) {
        registry.registerAll(PALM, SPARSE, WILLOW, JUNIPER);
    }

    public static final CellKit PALM = new CellKit(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "palm")) {

        private final Cell palmBranch = new Cell() {
            @Override
            public int getValue() {
                return 5;
            }

            @Override
            public int getValueFromSide(Direction side) {
                return side == Direction.UP ? getValue() : 0;
            }

        };

        private final Cell[] palmFrondCells = {
                CellNull.NULL_CELL,
                new PalmFrondCell(1),
                new PalmFrondCell(2),
                new PalmFrondCell(3),
                new PalmFrondCell(4),
                new PalmFrondCell(5),
                new PalmFrondCell(6),
                new PalmFrondCell(7)
        };

        private final CellKits.BasicSolver palmSolver = new CellKits.BasicSolver(new short[]{0x0514, 0x0413, 0x0312, 0x0221});

        @Override
        public Cell getCellForLeaves(int hydro) {
            return palmFrondCells[hydro];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return radius == 3? palmBranch : CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return LeafClusters.PALM;
        }

        @Override
        public CellSolver getCellSolver() {
            return palmSolver;
        }

        @Override
        public int getDefaultHydration() {
            return 4;
        }

    };

    public static final CellKit SPARSE = new CellKit(new ResourceLocation(DynamicTreesProjectVibrant.MOD_ID, "sparse")) {

        private final Cell sparseBranch = new SparseBranchCell();
        private final Cell sparseLeaves = new NormalCell(1);

        private final CellSolver solver = new CellKits.BasicSolver(new short[] {0x0211});

        @Override
        public Cell getCellForLeaves(int hydro) {
            return hydro > 0 ? sparseLeaves : CellNull.NULL_CELL;
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return radius == 1 ? sparseBranch : CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTPVJLeafClusters.SPARSE;
        }

        @Override
        public CellSolver getCellSolver() {
            return solver;
        }

        @Override
        public int getDefaultHydration() {
            return 1;
        }

    };

    public static final CellKit WILLOW = new CellKit(DynamicTreesProjectVibrant.location("willow")) {

        private final Cell branch = new WillowBranchCell();

        private final Cell[] willowLeafCells = {
                CellNull.NULL_CELL,
                new WillowLeafCell(1),
                new WillowLeafCell(2),
                new WillowLeafCell(3),
                new WillowLeafCell(4),
                new WillowLeafCell(5),
                new WillowLeafCell(6),
                new WillowLeafCell(7)
        };

        private final CellKits.BasicSolver solver = new CellKits.BasicSolver(new short[]{0x0817, 0x0726, 0x0625, 0x0714, 0x0614, 0x0514, 0x0413, 0x0312, 0x0211});

        @Override
        public Cell getCellForLeaves(int distance) {
            return this.willowLeafCells[distance];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return radius == 1 ? this.branch : CellNull.NULL_CELL;
        }

        @Override
        public CellSolver getCellSolver() {
            return this.solver;
        }

        // TODO: Willow leaf cluster.
        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTPVJLeafClusters.WILLOW;
        }

        @Override
        public int getDefaultHydration() {
            return 7;
        }
    };

    public static final CellKit JUNIPER = new CellKit(DynamicTreesProjectVibrant.location("juniper")) {

        private final Cell[] normalCells = {
                CellNull.NULL_CELL,
                new NormalCell(1),
                new NormalCell(2),
                new NormalCell(3),
                new NormalCell(4),
                new NormalCell(5),
                new NormalCell(6),
                new NormalCell(7)
        };

        /** Typical branch with hydration 5 */
        private final Cell branchCell = new NormalCell(5);

        private final CellKits.BasicSolver deciduousSolver = new CellKits.BasicSolver(new short[]{0x0513, 0x0322, 0x0311, 0x0211});

        @Override
        public Cell getCellForLeaves(int hydro) {
            return normalCells[hydro];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return radius == 1 ? branchCell : CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTPVJLeafClusters.JUNIPER;
        }

        @Override
        public CellSolver getCellSolver() {
            return deciduousSolver;
        }

        @Override
        public int getDefaultHydration() {
            return 3;
        }

    };

}
