package net.drakenxi.constructionessentials.lib;

import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.Collections;
import net.minecraft.util.Direction;

public class CustomModelFinder {

	private HashMap<String, String[]> modelDirectionTable;
	private HashMap<String, String> invertedModelDirectionTable;
	
	public CustomModelFinder() {
		this.modelDirectionTable = new HashMap<String, String[]>();
		this.modelDirectionTable.put("1100000", new String[] {"UP","base"});
		this.modelDirectionTable.put("1010000", new String[] {"DOWN","base"});
		this.modelDirectionTable.put("1000100", new String[] {"NORTH","base"});
		this.modelDirectionTable.put("1001000", new String[] {"SOUTH","base"});
		this.modelDirectionTable.put("1000010", new String[] {"EAST","base"});
		this.modelDirectionTable.put("1000001", new String[] {"WEST","base"});
		this.modelDirectionTable.put("2110000", new String[] {"UP","straight"});
		this.modelDirectionTable.put("2001100", new String[] {"NORTH","straight"});
		this.modelDirectionTable.put("2000011", new String[] {"EAST","straight"});
		this.modelDirectionTable.put("2011000", new String[] {"NORTH","bendtowup"});
		this.modelDirectionTable.put("2010100", new String[] {"SOUTH","bendtowup"});
		this.modelDirectionTable.put("2010001", new String[] {"EAST","bendtowup"});
		this.modelDirectionTable.put("2010010", new String[] {"WEST","bendtowup"});
		this.modelDirectionTable.put("2101000", new String[] {"NORTH","bendtowdown"});
		this.modelDirectionTable.put("2100100", new String[] {"SOUTH","bendtowdown"});
		this.modelDirectionTable.put("2100001", new String[] {"EAST","bendtowdown"});
		this.modelDirectionTable.put("2100010", new String[] {"WEST","bendtowdown"});
		this.modelDirectionTable.put("2001001", new String[] {"NORTH","bendtowside"});
		this.modelDirectionTable.put("2000110", new String[] {"SOUTH","bendtowside"});
		this.modelDirectionTable.put("2000101", new String[] {"EAST","bendtowside"});
		this.modelDirectionTable.put("2001010", new String[] {"WEST","bendtowside"});
		this.modelDirectionTable.put("3011001", new String[] {"NORTH","bendthreeup"});
		this.modelDirectionTable.put("3010110", new String[] {"SOUTH","bendthreeup"});
		this.modelDirectionTable.put("3010101", new String[] {"EAST","bendthreeup"});
		this.modelDirectionTable.put("3011010", new String[] {"WEST","bendthreeup"});
		this.modelDirectionTable.put("3101001", new String[] {"NORTH","bendthreedown"});
		this.modelDirectionTable.put("3100110", new String[] {"SOUTH","bendthreedown"});
		this.modelDirectionTable.put("3100101", new String[] {"EAST","bendthreedown"});
		this.modelDirectionTable.put("3101010", new String[] {"WEST","bendthreedown"});
		this.modelDirectionTable.put("3010011", new String[] {"NORTH","tthreeup"});
		this.modelDirectionTable.put("3011100", new String[] {"WEST","tthreeup"});
		this.modelDirectionTable.put("3100011", new String[] {"NORTH","tthreedown"});
		this.modelDirectionTable.put("3101100", new String[] {"WEST","tthreedown"});
		this.modelDirectionTable.put("3111000", new String[] {"NORTH","tthreeupdown"});
		this.modelDirectionTable.put("3110100", new String[] {"SOUTH","tthreeupdown"});
		this.modelDirectionTable.put("3110001", new String[] {"EAST","tthreeupdown"});
		this.modelDirectionTable.put("3110010", new String[] {"WEST","tthreeupdown"});
		this.modelDirectionTable.put("3001011", new String[] {"NORTH","tthreeside"});
		this.modelDirectionTable.put("3000111", new String[] {"SOUTH","tthreeside"});
		this.modelDirectionTable.put("3001101", new String[] {"EAST","tthreeside"});
		this.modelDirectionTable.put("3001110", new String[] {"WEST","tthreeside"});
		this.modelDirectionTable.put("4111001", new String[] {"NORTH","bendfourside"});
		this.modelDirectionTable.put("4110110", new String[] {"SOUTH","bendfourside"});
		this.modelDirectionTable.put("4110101", new String[] {"EAST","bendfourside"});
		this.modelDirectionTable.put("4111010", new String[] {"WEST","bendfourside"});
		this.modelDirectionTable.put("4011011", new String[] {"NORTH","bendfourup"});
		this.modelDirectionTable.put("4010111", new String[] {"SOUTH","bendfourup"});
		this.modelDirectionTable.put("4011101", new String[] {"EAST","bendfourup"});
		this.modelDirectionTable.put("4011110", new String[] {"WEST","bendfourup"});
		this.modelDirectionTable.put("4101011", new String[] {"NORTH","bendfourdown"});
		this.modelDirectionTable.put("4100111", new String[] {"SOUTH","bendfourdown"});
		this.modelDirectionTable.put("4101101", new String[] {"EAST","bendfourdown"});
		this.modelDirectionTable.put("4101110", new String[] {"WEST","bendfourdown"});
		this.modelDirectionTable.put("4110011", new String[] {"NORTH","crossfour"});
		this.modelDirectionTable.put("4111100", new String[] {"EAST","crossfour"});
		this.modelDirectionTable.put("5011111", new String[] {"UP","crossfive"});
		this.modelDirectionTable.put("5101111", new String[] {"DOWN","crossfive"});
		this.modelDirectionTable.put("5111011", new String[] {"NORTH","crossfive"});
		this.modelDirectionTable.put("5110111", new String[] {"SOUTH","crossfive"});
		this.modelDirectionTable.put("5111101", new String[] {"EAST","crossfive"});
		this.modelDirectionTable.put("5111110", new String[] {"WEST","crossfive"});
		this.modelDirectionTable.put("6111111", new String[] {"NORTH","crosssix"});

		this.invertedModelDirectionTable = new HashMap<String, String>();
		this.invertedModelDirectionTable.put("upbase", "1100000");
		this.invertedModelDirectionTable.put("downbase", "1010000");
		this.invertedModelDirectionTable.put("northbase", "1000100");
		this.invertedModelDirectionTable.put("southbase", "1001000");
		this.invertedModelDirectionTable.put("eastbase", "1000010");
		this.invertedModelDirectionTable.put("westbase", "1000001");
		this.invertedModelDirectionTable.put("upstraight", "2110000");
		this.invertedModelDirectionTable.put("downstraight", "2110000");
		this.invertedModelDirectionTable.put("northstraight", "2001100");
		this.invertedModelDirectionTable.put("southstraight", "2001100");
		this.invertedModelDirectionTable.put("eaststraight", "2000011");
		this.invertedModelDirectionTable.put("weststraight", "2000011");
		this.invertedModelDirectionTable.put("upbendtowup", "2011000");
		this.invertedModelDirectionTable.put("downbendtowup", "2011000");
		this.invertedModelDirectionTable.put("northbendtowup", "2011000");
		this.invertedModelDirectionTable.put("southbendtowup", "2010100");
		this.invertedModelDirectionTable.put("eastbendtowup", "2010001");
		this.invertedModelDirectionTable.put("westbendtowup", "2010010");
		this.invertedModelDirectionTable.put("upbendtowdown", "2101000");
		this.invertedModelDirectionTable.put("downbendtowdown", "2101000");
		this.invertedModelDirectionTable.put("northbendtowdown", "2101000");
		this.invertedModelDirectionTable.put("southbendtowdown", "2100100");
		this.invertedModelDirectionTable.put("eastbendtowdown", "2100001");
		this.invertedModelDirectionTable.put("westbendtowdown", "2100010");
		this.invertedModelDirectionTable.put("upbendtowside", "2001001");
		this.invertedModelDirectionTable.put("downbendtowside", "2001001");
		this.invertedModelDirectionTable.put("northbendtowside", "2001001");
		this.invertedModelDirectionTable.put("southbendtowside", "2000110");
		this.invertedModelDirectionTable.put("eastbendtowside", "2000101");
		this.invertedModelDirectionTable.put("westbendtowside", "2001010");
		this.invertedModelDirectionTable.put("upbendthreeup", "3011001");
		this.invertedModelDirectionTable.put("southbendthreeup", "3011001");
		this.invertedModelDirectionTable.put("northbendthreeup", "3011001");
		this.invertedModelDirectionTable.put("southbendthreeup", "3010110");
		this.invertedModelDirectionTable.put("eastbendthreeup", "3010101");
		this.invertedModelDirectionTable.put("westbendthreeup", "3011010");
		this.invertedModelDirectionTable.put("upbendthreedown", "3101001");
		this.invertedModelDirectionTable.put("southbendthreedown", "3101001");
		this.invertedModelDirectionTable.put("northbendthreedown", "3101001");
		this.invertedModelDirectionTable.put("southbendthreedown", "3100110");
		this.invertedModelDirectionTable.put("eastbendthreedown", "3100101");
		this.invertedModelDirectionTable.put("westbendthreedown", "3101010");
		this.invertedModelDirectionTable.put("uptthreeup", "3010011");
		this.invertedModelDirectionTable.put("downtthreeup", "3010011");
		this.invertedModelDirectionTable.put("northtthreeup", "3010011");
		this.invertedModelDirectionTable.put("southtthreeup", "3011100");
		this.invertedModelDirectionTable.put("westtthreeup", "3011100");
		this.invertedModelDirectionTable.put("easttthreeup", "3011100");
		this.invertedModelDirectionTable.put("uptthreedown", "3100011");
		this.invertedModelDirectionTable.put("downtthreedown", "3100011");
		this.invertedModelDirectionTable.put("northtthreedown", "3100011");
		this.invertedModelDirectionTable.put("southtthreedown", "3101100");
		this.invertedModelDirectionTable.put("westtthreedown", "3101100");
		this.invertedModelDirectionTable.put("easttthreedown", "3101100");
		this.invertedModelDirectionTable.put("uptthreeupdown", "3011100");
		this.invertedModelDirectionTable.put("downtthreeupdown", "3101100");
		this.invertedModelDirectionTable.put("northtthreeupdown", "3111000");
		this.invertedModelDirectionTable.put("southtthreeupdown", "3110100");
		this.invertedModelDirectionTable.put("easttthreeupdown", "3110001");
		this.invertedModelDirectionTable.put("westtthreeupdown", "3110010");
		this.invertedModelDirectionTable.put("uptthreeside", "3001011");
		this.invertedModelDirectionTable.put("southtthreeside", "3001011");
		this.invertedModelDirectionTable.put("northtthreeside", "3001011");
		this.invertedModelDirectionTable.put("southtthreeside", "3000111");
		this.invertedModelDirectionTable.put("easttthreeside", "3001101");
		this.invertedModelDirectionTable.put("westtthreeside", "3001110");
		this.invertedModelDirectionTable.put("upbendfourside", "4111001");
		this.invertedModelDirectionTable.put("downbendfourside", "4111001");
		this.invertedModelDirectionTable.put("northbendfourside", "4111001");
		this.invertedModelDirectionTable.put("southbendfourside", "4110110");
		this.invertedModelDirectionTable.put("eastbendfourside", "4110101");
		this.invertedModelDirectionTable.put("westbendfourside", "4111010");
		this.invertedModelDirectionTable.put("upbendfourup", "4011011");
		this.invertedModelDirectionTable.put("downbendfourup", "4011011");
		this.invertedModelDirectionTable.put("northbendfourup", "4011011");
		this.invertedModelDirectionTable.put("southbendfourup", "4010111");
		this.invertedModelDirectionTable.put("eastbendfourup", "4011101");
		this.invertedModelDirectionTable.put("westbendfourup", "4011110");
		this.invertedModelDirectionTable.put("upbendfourdown", "4101011");
		this.invertedModelDirectionTable.put("downbendfourdown", "4101011");
		this.invertedModelDirectionTable.put("northbendfourdown", "4101011");
		this.invertedModelDirectionTable.put("southbendfourdown", "4100111");
		this.invertedModelDirectionTable.put("eastbendfourdown", "4101101");
		this.invertedModelDirectionTable.put("westbendfourdown", "4101110");
		this.invertedModelDirectionTable.put("upcrossfour", "4001111");
		this.invertedModelDirectionTable.put("downcrossfour", "4001111");
		this.invertedModelDirectionTable.put("northcrossfour", "4110011");
		this.invertedModelDirectionTable.put("southcrossfour", "4110011");
		this.invertedModelDirectionTable.put("westcrossfour", "4111100");
		this.invertedModelDirectionTable.put("eastcrossfour", "4111100");
		this.invertedModelDirectionTable.put("upcrossfive", "5011111");
		this.invertedModelDirectionTable.put("downcrossfive", "5101111");
		this.invertedModelDirectionTable.put("northcrossfive", "5111011");
		this.invertedModelDirectionTable.put("southcrossfive", "5110111");
		this.invertedModelDirectionTable.put("eastcrossfive", "5111101");
		this.invertedModelDirectionTable.put("westcrossfive", "5111110");
		this.invertedModelDirectionTable.put("upcrosssix", "6111111");
		this.invertedModelDirectionTable.put("downcrosssix", "6111111");
		this.invertedModelDirectionTable.put("northcrosssix", "6111111");
		this.invertedModelDirectionTable.put("southcrosssix", "6111111");
		this.invertedModelDirectionTable.put("eastcrosssix", "6111111");
		this.invertedModelDirectionTable.put("westcrosssix", "6111111");
	}

	public String[] getModelAndDirectionFromCMD(String cmd){

		String[] model = modelDirectionTable.get(cmd);
		if(model != null){
			return model;
		}else{
			return this.modelDirectionTable.get("1010000"); //Retourne celui par defaut
		}
	}

	public String[] getModelAndDirectionFromDirectionHelper(DirectionHelper dh){
		
		String cmd = dh.getCMD();
		String[] model = modelDirectionTable.get(cmd);
		if(model != null){
			return model;
		}else{
			return this.modelDirectionTable.get("1010000"); //Retourne celui par defaut
		}
		
	}

	public String getCMDFromDirectionAndModel(Direction dir, String model){
		return this.invertedModelDirectionTable.get(dir.toString() + model);
	}

}
