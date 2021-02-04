package net.drakenxi.constructionessentials.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.drakenxi.constructionessentials.lib.*;

import net.drakenxi.constructionessentials.ConstructionEssentialsModElements;
import net.drakenxi.constructionessentials.ConstructionEssentialsMod;


import java.util.Map;

@ConstructionEssentialsModElements.ModElement.Tag
public class SewerPipeBaseBlockAddedProcedure extends ConstructionEssentialsModElements.ModElement {
	public SewerPipeBaseBlockAddedProcedure(ConstructionEssentialsModElements instance) {
		super(instance, 62);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency x for procedure SewerPipeNeighbourBlockChange!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency y for procedure SewerPipeNeighbourBlockChange!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency z for procedure SewerPipeNeighbourBlockChange!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ConstructionEssentialsMod.LOGGER.warn("Failed to load dependency world for procedure SewerPipeNeighbourBlockChange!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		SewerPipe sewer = new SewerPipe();
		BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
		sewer.setBlockState(world, _bp, 18);
	}

}
