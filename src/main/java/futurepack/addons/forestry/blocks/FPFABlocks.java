package futurepack.addons.forestry.blocks;

import futurepack.addons.forestry.common.FPForestryAddon;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FPFABlocks
{
	public final static Block hiveBlock = new BlockHive(HiveMenelaus.hiveMenelaus).setHardness(1F).setResistance(2F).setUnlocalizedName("hive_menelaus");
	
	public static void register()
	{
		GameRegistry.register(hiveBlock, new ResourceLocation(FPForestryAddon.modID, hiveBlock.getUnlocalizedName()));
	}
}
