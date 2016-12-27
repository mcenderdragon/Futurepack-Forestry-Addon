package futurepack.addons.common;

import futurepack.addons.bees.BeeSpecies;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=FPForestryAddon.modID, name="Futurepack intergration for Forestry", version="4.1", dependencies="required-after:fp;required-after:forestry")
public class FPForestryAddon
{
	public static final String modID = "fpforestryaddon";
	public static final String modName = "Futurebees";
	public static final String modVersion = "4.1";
	
	public BeeSpecies b = BeeSpecies.CYBERN;
	
	@Instance(FPForestryAddon.modID)
	public static FPForestryAddon instance;
	
	@SidedProxy(modId=modID, clientSide="futurepack.addons.common.ProxyClient", serverSide="futurepack.addons.common.ProxyServer")
	public static ProxyBase proxy;
	
	public static CreativeTabFPFA tab = new CreativeTabFPFA();
	
	private static Item combs = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeCombs"));
	public static Item tools = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:spaceship"));
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {	
		proxy.preInit(event);	
		MinecraftForge.EVENT_BUS.register(instance);	
    }
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.load(event);	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
	
}
