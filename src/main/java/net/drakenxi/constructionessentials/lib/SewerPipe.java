package net.drakenxi.constructionessentials.lib;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;


import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.drakenxi.constructionessentials.block.SewerPipeBaseBlock;
import net.drakenxi.constructionessentials.block.SewerPipeStraightBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendTowUpBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendTowDownBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendTowSideBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendThreeUpBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendThreeDownBlock;
import net.drakenxi.constructionessentials.block.SewerPipeTThreeUpBlock;
import net.drakenxi.constructionessentials.block.SewerPipeTThreeDownBlock;
import net.drakenxi.constructionessentials.block.SewerPipeTThreeUpDownBlock;
import net.drakenxi.constructionessentials.block.SewerPipeTThreeSideBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendFourSideBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendFourUpBlock;
import net.drakenxi.constructionessentials.block.SewerPipeBendFourDownBlock;
import net.drakenxi.constructionessentials.block.SewerPipeCrossFourBlock;
import net.drakenxi.constructionessentials.block.SewerPipeCrossFiveBlock;
import net.drakenxi.constructionessentials.block.SewerPipeCrossSixBlock;
import org.apache.commons.io.filefilter.IOFileFilter;
import net.minecraft.client.gui.screen.IScreen;

public class SewerPipe extends MultiConnectedBlockAbstract {

	public SewerPipe() {
		this.modelBlockEquivalance = new HashMap<String,Block>();
		this.modelBlockEquivalance.put("base", SewerPipeBaseBlock.block);
		this.modelBlockEquivalance.put("straight", SewerPipeStraightBlock.block);
		this.modelBlockEquivalance.put("bendtowup", SewerPipeBendTowUpBlock.block);
		this.modelBlockEquivalance.put("bendtowdown", SewerPipeBendTowDownBlock.block);
		this.modelBlockEquivalance.put("bendtowside", SewerPipeBendTowSideBlock.block);
		this.modelBlockEquivalance.put("bendthreeup", SewerPipeBendThreeUpBlock.block);
		this.modelBlockEquivalance.put("bendthreedown", SewerPipeBendThreeDownBlock.block);
		this.modelBlockEquivalance.put("tthreeup", SewerPipeTThreeUpBlock.block);
		this.modelBlockEquivalance.put("tthreedown", SewerPipeTThreeDownBlock.block);
		this.modelBlockEquivalance.put("tthreeupdown", SewerPipeTThreeUpDownBlock.block);
		this.modelBlockEquivalance.put("tthreeside", SewerPipeTThreeSideBlock.block);
		this.modelBlockEquivalance.put("bendfourside", SewerPipeBendFourSideBlock.block);
		this.modelBlockEquivalance.put("bendfourup", SewerPipeBendFourUpBlock.block);
		this.modelBlockEquivalance.put("bendfourdown", SewerPipeBendFourDownBlock.block);
		this.modelBlockEquivalance.put("crossfour", SewerPipeCrossFourBlock.block);
		this.modelBlockEquivalance.put("crossfive", SewerPipeCrossFiveBlock.block);
		this.modelBlockEquivalance.put("crosssix", SewerPipeCrossSixBlock.block);
	}

}
