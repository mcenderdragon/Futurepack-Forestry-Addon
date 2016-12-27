package futurepack.addons;

import net.minecraft.block.state.IBlockState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PotionManager
{
	private static final PotionManager instance = new PotionManager();
	
	public static final PotionMagnetism magnetism = (PotionMagnetism) new PotionMagnetism().setPotionName("potion.magnetism");
	
	
	public static void register()
	{
		GameRegistry.register(magnetism, new ResourceLocation(FPForestryAddon.ID, "magnetism"));
		
		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	@SubscribeEvent
	public void onLivingTick(LivingUpdateEvent event)
	{
		PotionEffect eff = event.getEntityLiving().getActivePotionEffect(magnetism);
		if(eff!=null)
		{
			magnetism.performEffect(event.getEntityLiving(), eff.getAmplifier());
		}
	}
	
//	
//	@SubscribeEvent
//	public void onItemUse(PlayerInteractEvent event)
//	{
//		if(event.entityPlayer.isPotionActive(paralyze))
//		{
//			event.setCanceled(true);
//		}
//	}
	
}
