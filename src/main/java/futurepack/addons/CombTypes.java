package futurepack.addons;

import java.util.HashMap;

import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class CombTypes
{	
	protected static int globalID = 0;
	protected static CombTypes[] idMap = new CombTypes[8];
	
	public static final CombTypes NeonComb = new CombTypes("neon",0x45d0d0);
	public static final CombTypes RetiumComb = new CombTypes("retium",0xff0404);
	public static final CombTypes GlowtitComb = new CombTypes("glowtit", 0xf8aa0d);
	public static final CombTypes BioteriumComb = new CombTypes("bioterium", 0x00f400);
	public static final CombTypes AlutinComb = new CombTypes("alutin", 0xe0e0e0);
	public static final CombTypes MagneticComb = new CombTypes("magnetic", 0x434343);
	
	
	protected HashMap<ItemStack,Float> products = new HashMap<ItemStack,Float>();
	protected int color;
	protected String name;
	protected ItemStack comb;
	protected final int id;
	
	public static void setup()
	{
		ItemStack neon,retium,glowtit,bioterium,alutin,iron,magnet,copper, wax, honey, neonsand,retiumsand,glowtitsand,bioteriumsand,alutinsand;

		wax = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeswax")));
		honey = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:honeyDrop")));
		neonsand = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:neonGranulat")),1,0);
		retiumsand = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:neonGranulat")),1,1);
		glowtitsand = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:neonGranulat")),1,2);
		bioteriumsand = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:neonGranulat")),1,3);
		alutinsand = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:neonGranulat")),1,4);
			
		neon = OreDictionary.getOres("dustNeon").get(0);
		retium = OreDictionary.getOres("dustRetium").get(0);
		glowtit = OreDictionary.getOres("dustGlowtite").get(0);
		bioterium = OreDictionary.getOres("dustBioterium").get(0);
		alutin = OreDictionary.getOres("dustAluminum").get(0);
		iron = OreDictionary.getOres("dustIron").get(0);
		magnet = OreDictionary.getOres("dustMagnetite").get(0);
		copper = OreDictionary.getOres("dustCopper").get(0);
		
		
		NeonComb.addProduct(neon, 0.8F).addProduct(wax, 0.5F).addProduct(honey, 0.1F).addProduct(neonsand, 0.01F);
		RetiumComb.addProduct(retium, 0.8F).addProduct(wax, 0.5F).addProduct(honey, 0.1F).addProduct(retiumsand, 0.01F);
		GlowtitComb.addProduct(glowtit, 0.8F).addProduct(wax, 0.5F).addProduct(honey, 0.1F).addProduct(glowtitsand, 0.01F);
		BioteriumComb.addProduct(bioterium, 0.8F).addProduct(wax, 0.5F).addProduct(honey, 0.1F).addProduct(bioteriumsand, 0.01F);
		AlutinComb.addProduct(alutin, 0.8F).addProduct(wax, 0.5F).addProduct(honey, 0.1F).addProduct(alutinsand, 0.01F);
		MagneticComb.addProduct(iron, 0.8F).addProduct(magnet, 0.4F).addProduct(copper, 0.1F);
		
		for(int i=0;i<globalID;i++)
		{
			ItemStack it = new ItemStack(FPFAItems.specialCombs,1,i);
			CombTypes type = ItemCombs.getType(it);
			type.setup(it);
		}
	}
	
	public CombTypes(String s, int color)
	{
		id = globalID;
		idMap[id]=this;
		globalID++;
		
		name = s;
		this.color = color;
	}
	
	private CombTypes addProduct(ItemStack it, float f)
	{
		products.put(it, f);
		return this;
	}
	
	public void setup(ItemStack comb)
	{
		this.comb=comb;
		RecipeManagers.centrifugeManager.addRecipe(123, comb, products);
	}

	public int getId()
	{
		return id;
	}
}
