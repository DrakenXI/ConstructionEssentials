package net.drakenxi.constructionessentials.lib;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.Property;
import net.minecraft.state.DirectionProperty;



abstract class MultiConnectedBlockAbstract {
	protected HashMap<String, Block> modelBlockEquivalance;

	public Block getEquivalanceBlockFromModel(String model) {
		return modelBlockEquivalance.get(model);
	}

	public Pair<String, Block> getBlockAndDirection(DirectionHelper dirHelp) {
		CustomModelFinder cf = new CustomModelFinder();
		String[] model = cf.getModelAndDirectionFromDirectionHelper(dirHelp);
		Block bs = this.getEquivalanceBlockFromModel(model[1]);
		return new Pair<String, Block>(model[0], bs); //First : Direction, Second : blockstate
	}

	public Direction getDirection(IWorld world, BlockPos pos) {
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

	/*
	 * Si les bloc autour point dans la direction du bloc tester Ex : si le bloc audessu point vers le bas (DOWN)
	 * 
	 */
	public String getCMDFromNeighbourBlock(IWorld world, BlockPos pos){
		DirectionHelper dh = new DirectionHelper();
		
		if(isConnectable(world, new BlockPos(pos.getX(),pos.getY()+1,pos.getZ()), Direction.DOWN)){
			dh.addDirection(Direction.UP);
		}
		if(isConnectable(world, new BlockPos(pos.getX(),pos.getY()-1,pos.getZ()), Direction.UP)){
			dh.addDirection(Direction.DOWN);
		}
		if(isConnectable(world, new BlockPos(pos.getX(),pos.getY(),pos.getZ()-1), Direction.SOUTH)){
			dh.addDirection(Direction.NORTH);
		}
		if(isConnectable(world, new BlockPos(pos.getX(),pos.getY(),pos.getZ()+1), Direction.NORTH)){
			dh.addDirection(Direction.SOUTH);
		}
		if(isConnectable(world, new BlockPos(pos.getX()+1,pos.getY(),pos.getZ()), Direction.WEST)){
			dh.addDirection(Direction.EAST);
		}
		if(isConnectable(world, new BlockPos(pos.getX()-1,pos.getY(),pos.getZ()), Direction.EAST)){
			dh.addDirection(Direction.WEST);
		}

		String cmd = dh.getCMD();

		return cmd;
	}

	private boolean isConnectable(IWorld world, BlockPos pos, Direction dir){
		DirectionHelper dh = new DirectionHelper();
		CustomModelFinder cf = new CustomModelFinder();
		
		Block b = world.getBlockState(pos).getBlock();

		for(Map.Entry<String, Block> entry : this.modelBlockEquivalance.entrySet()) {
		    String key = entry.getKey();
		    Block value = entry.getValue();
		    
			if (b == value.getDefaultState().getBlock()) { //Si le block appartien à la liste des bloc compatible
				String neightbourCmd = cf.getCMDFromDirectionAndModel(this.getDirection(world, pos), key);
				boolean connected = dh.isConnectedFace(dir,neightbourCmd);
				return connected;
			}
		}
		return false;
	}

	public void setBlockState(IWorld world, BlockPos pos, int flags){
		String cmd = getCMDFromNeighbourBlock(world, pos);
		
		if(cmd.charAt(0) != '0'){ // Si il y a au moins 1 connection
			CustomModelFinder cf = new CustomModelFinder();
			DirectionHelper dh = new DirectionHelper();
			String[] modelDir =  cf.getModelAndDirectionFromCMD(cmd);
			
			BlockState bs = this.getEquivalanceBlockFromModel(modelDir[1]).getDefaultState();
			try{
				BlockState _bs = world.getBlockState(pos); // Récupération de l'état actuell
				if(bs.getBlock() != _bs.getBlock()){
					world.setBlockState(pos, bs, flags); //On place le bon block
				}
			}catch(Exception e){
				
			}
			

			Direction dir = dh.getDirectionFromString(modelDir[0]);
			
			try { // on esssais de le tourner
				BlockState _bs = world.getBlockState(pos);
				if(DirectionHelper.getDirectionOfBlock(world, pos) != dir){
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(pos, _bs.with(_property, dir), flags);
					} else {
						world.setBlockState(pos,
								_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), dir.getAxis()), flags);
					}

				}
			} catch (Exception e) {
			}	
		}

	}

	public boolean isSameBlockType(Block b){
		for(Map.Entry<String, Block> entry : this.modelBlockEquivalance.entrySet()) {
		    String key = entry.getKey();
		    Block value = entry.getValue();
		    
			if (b == value.getDefaultState().getBlock() || b == Blocks.AIR.getDefaultState().getBlock()) { //Si le block appartien à la liste des bloc compatible
				return true;
			}
		}
		return false;
	}

}
