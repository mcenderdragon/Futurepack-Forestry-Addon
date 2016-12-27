package futurepack.addons.blocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IHiveDrop;
import forestry.api.apiculture.hives.HiveManager;
import forestry.api.apiculture.hives.IHiveDescription;
import forestry.api.apiculture.hives.IHiveGen;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import futurepack.addons.bees.BeeTypes;
import futurepack.addons.common.FPForestryAddon;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class HiveMenelaus implements IHiveDescription, IHiveDrop
{
	public static HiveMenelaus hiveMenelaus = new HiveMenelaus("menelaus",(Block) Block.REGISTRY.getObject(new ResourceLocation("fp:sand")));
	
	private final String name;
	
	
	private Block canStand;
	
	public HiveMenelaus(String name,Block canStand)
	{
		this.name = name;
		this.canStand = canStand;
		HiveManager.hiveRegistry.registerHive(FPForestryAddon.modID + ":" + name, this);
		HiveManager.hiveRegistry.addDrops(FPForestryAddon.modID + ":" + name, this);
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public IHiveGen getHiveGen()
	{
		return HiveManager.genHelper.ground(canStand);
	}

//	@Override
//	public Block getBlock()
//	{
//		return FPFABlocks.hiveBlock;
//	}
//
//	@Override
//	public int getMeta()
//	{
//		return 0;
//	}

	@Override
	public boolean isGoodBiome(Biome biome)
	{
		return biome.getClass().getName().equals("futurepack.common.dim.BiomeMenelaus");
	}

	@Override
	public boolean isGoodHumidity(EnumHumidity humidity)
	{
		return humidity == EnumHumidity.ARID;
	}

	@Override
	public boolean isGoodTemperature(EnumTemperature temperature)
	{
		return EnumTemperature.HOT == temperature;
	}

	@Override
	public float getGenChance()
	{
		return 1.0F;
	}

	@Override
	public IBee getBeeType(IBlockAccess world, BlockPos pos)
	{
		IBee bee = BeeManager.beeRoot.templateAsIndividual(BeeTypes.Menelaus.getChromosomes());
		return bee;
	}

	@Override
	public Collection<ItemStack> getExtraItems(IBlockAccess world, BlockPos pos, int fortune)
	{
		Item combs = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeCombs"));
		return Arrays.asList(new ItemStack(combs,1,7),new ItemStack(combs,1,7));
	}

	@Override
	public double getChance(IBlockAccess world, BlockPos pos, int fortune)
	{
		return 80;
	}

	@Override
	public double getIgnobleChance(IBlockAccess world, BlockPos pos, int fortune)
	{
		return 70;
	}

	@Override
	public IBlockState getBlockState()
	{
		return FPFABlocks.hiveBlock.getDefaultState();
	}

	@Override
	public void postGen(World world, Random rand, BlockPos pos) { }
	
}
