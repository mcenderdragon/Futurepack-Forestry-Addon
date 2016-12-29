package futurepack.addons.forestry.common;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.FlowerManager;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleFlowers;
import forestry.api.genetics.ICheckPollinatable;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IIndividual;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class FlowerTypes
{
	public static IAlleleFlowers Kristals;
	public static IAlleleFlowers Erze;
	
	public static void registerFlowers()
	{
		Kristals = AlleleManager.alleleFactory.createFlowers(FPForestryAddon.modID, "kristals", "kristals", new IFlowerProvider()
		{
			
			
			{
				Block Cristal = (Block) Block.REGISTRY.getObject(new ResourceLocation("fp:cristall"));
				FlowerManager.flowerRegistry.registerAcceptableFlower(Cristal, getFlowerType());
			}
			
			
//			private ArrayList<IFlower> list;
//			
//			@Override
//			public boolean isAcceptedPollinatable(World world, IPollinatable pollinatable)
//			{
//				return false;
//			}
			
//			@Override
//			public boolean isAcceptedFlower(World world, IIndividual individual, int x, int y, int z)
//			{
//				Block b = world.getBlock(x, y, z);
//				return b == Cristal;
//			}
//			
//			@Override
//			public boolean growFlower(World world, IIndividual individual, int x, int y, int z)
//			{
//				return false;
//			}
//			
//			@Override
//			public Set<IFlower> getFlowers()
//			{
//				if(list==null)
//				{
//					list = new ArrayList();
//					for(int i=0;i<16;i++)
//					{
//						list.add(new Flower(Cristal, i));
//					}
//				}
//				return Sets.newConcurrentHashSet(list);
//			}
			
			@Override
			public String getDescription()
			{
				return "Cristals";
			}

			@Override
			public String getFlowerType()
			{
				return "cristals";
			}

			@Override
			public boolean isAcceptedPollinatable(World world, ICheckPollinatable pollinatable)
			{
				return false;
			}

			@Override
			public ItemStack[] affectProducts(World world, IIndividual individual, BlockPos pos, ItemStack[] products)
			{
				return products;
			}

		}, true, EnumBeeChromosome.FLOWER_PROVIDER);
		AlleleManager.alleleRegistry.registerAllele(Kristals, EnumBeeChromosome.FLOWER_PROVIDER);
		
		Erze = AlleleManager.alleleFactory.createFlowers(FPForestryAddon.modID, "ores", "allores", new IFlowerProvider()
		{
			{
				for(String s : OreDictionary.getOreNames())
				{
					if(s.toLowerCase().startsWith("ore"))
					{
						for(ItemStack it : OreDictionary.getOres(s))
						{
							Block bl = Block.getBlockFromItem(it.getItem());
							if(bl!=null)
							{
								FlowerManager.flowerRegistry.registerAcceptableFlower(bl, getFlowerType());
							}			
						}				
					}
				}
			}
			
			@Override
			public boolean isAcceptedPollinatable(World world, ICheckPollinatable pollinatable)
			{
				return false;
			}
				
			@Override
			public String getDescription()
			{
				return "Ores";
			}

			@Override
			public String getFlowerType()
			{
				return "ores";
			}

			@Override
			public ItemStack[] affectProducts(World world, IIndividual individual, BlockPos pos, ItemStack[] products)
			{
				return products;
			}
			
		}, false, EnumBeeChromosome.FLOWER_PROVIDER);
		AlleleManager.alleleRegistry.registerAllele(Erze, EnumBeeChromosome.FLOWER_PROVIDER);
	}
	
//	private static class Flower implements IFlower
//	{
//		private Block bl;
//		private int meta;
//		private double weigth;
//		
//		public Flower(Block b, int m) 
//		{
//			bl=b;
//			meta=m;
//		}
//		
//		@Override
//		public int compareTo(IFlower t)
//		{
//			return (int) (t.getWeight() - this.getWeight());
//		}
//
//		@Override
//		public Block getBlock()
//		{
//			return bl;
//		}
//
//		@Override
//		public int getMeta()
//		{
//			return meta;
//		}
//
//		@Override
//		public double getWeight()
//		{
//			return weigth;
//		}
//
//		@Override
//		public void setWeight(double weight)
//		{
//			this.weigth = weight;
//		}
//
//		@Override
//		public boolean isPlantable()
//		{
//			return true;
//		}
//		
//	}
}
