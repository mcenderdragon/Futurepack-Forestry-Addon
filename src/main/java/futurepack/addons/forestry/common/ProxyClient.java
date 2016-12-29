package futurepack.addons.forestry.common;

import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.apiculture.PluginApiculture;
import forestry.apiculture.genetics.alleles.AlleleBeeSpecies;
import forestry.apiculture.items.ItemBeeGE;
import forestry.core.models.ModelManager;
import futurepack.addons.forestry.bees.BeeSpecies;
import futurepack.addons.forestry.blocks.FPFABlocks;
import futurepack.addons.forestry.items.FPFAItems;
import futurepack.addons.forestry.items.ItemColorizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyBase {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		FPFAItems.setupRendering();
		
		Item[] is = new Item[]{PluginApiculture.items.beeDroneGE, PluginApiculture.items.beeLarvaeGE, PluginApiculture.items.beePrincessGE, PluginApiculture.items.beeQueenGE};
		for(Item item : is)
		{
			BeeSpecies.registerModels(item, ModelManager.getInstance());
		}
	
	}
	
	@Override
	public void load(FMLInitializationEvent event) {
		super.load(event);
		
		ItemColors cols = Minecraft.getMinecraft().getItemColors();
		cols.registerItemColorHandler(new ItemColorizer(), FPFAItems.specialCombs);
	}

}
