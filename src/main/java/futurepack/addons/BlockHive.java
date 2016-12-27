package futurepack.addons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHive extends Block
{

	protected BlockHive(HiveMenelaus hive)
	{
		super(Material.SAND);
//		setBlockName(hive.getName());
//		setBlockTextureName(hive.getName());
		setLightLevel(0.8f);
		setHardness(1.0f);
		setCreativeTab(FPForestryAddon.instance.tab);
		setHarvestLevel("scoop", 0);
	}

//	IIcon top;
//	IIcon side;
//	
//	@Override
//	public void registerBlockIcons(IIconRegister r) 
//	{
//		top = r.registerIcon(FPForestryAddon.ID + ":" +this.getTextureName()+".top");
//		side = r.registerIcon(FPForestryAddon.ID + ":" +this.getTextureName()+".side");
//	}
//	
//	@Override
//	public IIcon getIcon(int side, int meta)
//	{
//		if(side==0 || side ==1)
//			return top;
//		
//		return this.side;
//	}
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return null;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> drops = new ArrayList();
	    
	    Random random = (world instanceof World) ? ((World)world).rand : RANDOM;
	    
	    HiveMenelaus drop = HiveMenelaus.hiveMenelaus;
	    int tries = 0;
		boolean hasPrincess = false;
		
		while ((tries <= 10) && (!hasPrincess))
	    {
			tries++;
	    
			if (random.nextDouble() < drop.getChance(world, pos, fortune))
			{
				IBee bee = drop.getBeeType(world, pos);
				if (random.nextFloat() < drop.getIgnobleChance(world, pos, fortune)) {
					bee.setIsNatural(false);
				}
				ItemStack princess = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);
				drops.add(princess);
				hasPrincess = true;
				break;
			}
	    }
		
	    
		if (random.nextDouble() < drop.getChance(world, pos, fortune))
		{
			IBee bee = drop.getBeeType(world, pos);
	        ItemStack drone = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);
	        drops.add(drone);
		}
	   
		if (random.nextDouble() < drop.getChance(world, pos, fortune))
		{
			drops.addAll(drop.getExtraItems(world, pos, fortune));
		}
	    
	    return drops;
		
		
//		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
//
//
//		HiveMenelaus drop = HiveMenelaus.hiveMenelaus;
//
////		Collections.shuffle(dropList);
//		// Grab a princess
//		
//		while (tries <= 10 && !hasPrincess)
//		{
//			tries++;
//
////			for (IHiveDrop drop : dropList) 
//			{
//				if (random.nextInt(100) < drop.getChance(world, pos, fortune))
//				{
//					ret.add(drop.getPrincess(world, x, y, z, fortune));
//					hasPrincess = true;
//				}
//			}
//		}
//
//		// Grab drones
////		for (IHiveDrop drop : dropList)
//		{
//			if (random.nextInt(100) < drop.getChance(world, x, y, z))
//			{
//				ret.addAll(drop.getDrones(world, x, y, z, fortune));
//			}
//		}
//		// Grab anything else on offer
////		for (IHiveDrop drop : dropList)
//		{
//			if (random.nextInt(100) < drop.getChance(world, x, y, z))
//			{
//				ret.addAll(drop.getAdditional(world, x, y, z, fortune));
//			}
//		}
//
//		return drops;
	}

	// / CREATIVE INVENTORY
	@Override
	public int damageDropped(IBlockState meta)
	{
		return 0;
	}

}
