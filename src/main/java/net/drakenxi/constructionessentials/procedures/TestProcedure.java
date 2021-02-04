package net.drakenxi.constructionessentials.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.drakenxi.constructionessentials.ConstructionEssentialsModElements;
import net.drakenxi.constructionessentials.ConstructionEssentialsMod;

import java.util.Map;

@ConstructionEssentialsModElements.ModElement.Tag
public class TestProcedure extends ConstructionEssentialsModElements.ModElement {
	public TestProcedure(ConstructionEssentialsModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency x for procedure Test!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency y for procedure Test!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency z for procedure Test!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency world for procedure Test!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			if (world instanceof World)
				((World) world).notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z),
						((World) world).getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock());
		}
	}
}
