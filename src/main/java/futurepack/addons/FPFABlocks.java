package futurepack.addons;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FPFABlocks
{
	public final static Block hiveBlock = new BlockHive(HiveMenelaus.hiveMenelaus).setHardness(1F).setResistance(2F);
	
	public static void register()
	{
		GameRegistry.register(hiveBlock, new ResourceLocation(FPForestryAddon.ID, hiveBlock.getUnlocalizedName()));
	}
}
