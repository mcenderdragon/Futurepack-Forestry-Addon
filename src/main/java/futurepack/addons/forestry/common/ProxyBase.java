package futurepack.addons.forestry.common;

import futurepack.addons.forestry.bees.BeeSpecies;
import futurepack.addons.forestry.blocks.FPFABlocks;
import futurepack.addons.forestry.crafting.FPFACrafting;
import futurepack.addons.forestry.crafting.FPFAForestryCrafting;
import futurepack.addons.forestry.crafting.FPFAFuturepackCrafting;
import futurepack.addons.forestry.effects.PotionManager;
import futurepack.addons.forestry.items.CombTypes;
import futurepack.addons.forestry.items.FPFAItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyBase {

	public void preInit(FMLPreInitializationEvent event) {
		FPFABlocks.register();
		FPFAItems.register();
		BeeSpecies.setupBees();
	}

	public void load(FMLInitializationEvent event) {
		FPFACrafting.setup();
		FPFAForestryCrafting.setup();
		FPFAFuturepackCrafting.setup();
		
		FlowerTypes.registerFlowers();
		PotionManager.register();
		BeeSpecies.initBees();
		
		
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		CombTypes.setup();	
	}

}
