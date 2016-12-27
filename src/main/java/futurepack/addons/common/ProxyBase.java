package futurepack.addons.common;

import futurepack.addons.bees.BeeTypes;
import futurepack.addons.bees.BreedingManager;
import futurepack.addons.blocks.FPFABlocks;
import futurepack.addons.crafting.FPFACrafting;
import futurepack.addons.crafting.FPFAForestryCrafting;
import futurepack.addons.crafting.FPFAFuturepackCrafting;
import futurepack.addons.effects.PotionManager;
import futurepack.addons.items.CombTypes;
import futurepack.addons.items.FPFAItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyBase {

	public void preInit(FMLPreInitializationEvent event) {
		FPFABlocks.register();
		FPFAItems.register();		
	}

	public void load(FMLInitializationEvent event) {
		FPFACrafting.setup();
		FPFAForestryCrafting.setup();
		FPFAFuturepackCrafting.setup();
		
		FlowerTypes.registerFlowers();
		BeeTypes.registerBees();	
		PotionManager.register();		
		BreedingManager.registerBreedings();
	}

	public void postInit(FMLPostInitializationEvent event) {
		CombTypes.setup();	
	}

}
