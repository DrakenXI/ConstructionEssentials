package net.drakenxi.constructionessentials.lib;

import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.Property;
import net.minecraft.state.DirectionProperty;
import java.util.ArrayList;

public class DirectionHelper {

	private ArrayList<Direction> directionTable = new ArrayList<Direction>();
	
	public ArrayList<Direction> getDirectionTable() {
		return directionTable;
	}

	public void addDirection(Direction dir) {
		directionTable.add(dir);
	}

	public String getCMD() {
		String result = "" + this.directionTable.size();
		for (Direction dir : Direction.values()) {
			if (this.directionTable.contains(dir)) {
				result = result + "1";
			} else {
				result = result + "0";
			}
		}
		return result;
	}

	public static boolean isConnectedFace(Direction dir, String CMD) {
		switch (dir) {
			case DOWN :
				return ifEqualOne(CMD.charAt(1));
			case  UP :
				return ifEqualOne(CMD.charAt(2));
			case NORTH :
				return ifEqualOne(CMD.charAt(3));
			case SOUTH :
				return ifEqualOne(CMD.charAt(4));
			case WEST :
				return ifEqualOne(CMD.charAt(5));
			case EAST :
				return ifEqualOne(CMD.charAt(6));
		}
		return false;
	}

	public static Direction getDirectionFromString(String ds) {
		switch (ds) {
			case "UP" :
				return Direction.UP;
			case "DOWN" :
				return Direction.DOWN;
			case "NORTH" :
				return Direction.NORTH;
			case "SOUTH" :
				return Direction.SOUTH;
			case "WEST" :
				return Direction.WEST;
			case "EAST" :
				return Direction.EAST;
		}
		return Direction.NORTH;
	}

	public static boolean ifEqualOne(char c) {
		if (c == '1') {
			return true;
		} else {
			return false;
		}
	}

	public static Direction getDirectionOfBlock(IWorld world, BlockPos pos) {
		try {
			BlockState _bs = world.getBlockState(pos);
			DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (property != null)
				return _bs.get(property);
			return Direction.getFacingFromAxisDirection(
					_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")), Direction.AxisDirection.POSITIVE);
		} catch (Exception e) {
			return Direction.NORTH;
		}
	}

}
