package futurepack.addons.common;

import futurepack.addons.blocks.FPFABlocks;
import futurepack.addons.items.FPFAItems;
import futurepack.addons.items.ItemColorizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyBase {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		//FPFABlocks.register();
		FPFAItems.setupRendering();
	}
	
	@Override
	public void load(FMLInitializationEvent event) {
		super.load(event);
		
		ItemColors cols = Minecraft.getMinecraft().getItemColors();
		cols.registerItemColorHandler(new ItemColorizer(), FPFAItems.specialCombs);
	}

}
