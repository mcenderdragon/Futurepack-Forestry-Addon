package futurepack.addons;

import java.lang.reflect.Method;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.genetics.IIndividual;
import forestry.api.recipes.ISqueezerManager;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid=FPForestryAddon.ID, name="Futurepack intergration for Forestry", version="4.1", dependencies="required-after:fp;required-after:forestry")
public class FPForestryAddon
{
	@Instance(FPForestryAddon.ID)
	public static FPForestryAddon instance;
	
	
	public static final String ID = "fpforestryaddon";
	
	public CreativeTabs tab = new CreativeTabs("tab.fp")
	{		
		@Override
		public Item getTabIconItem()
		{
			return FPFAItems.ironFrame;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Register Items");
		FPFAItems.register();
		FPFABlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{ 		
		System.out.println("Register Forestry Rezipes");
		ISqueezerManager sqee = RecipeManagers.squeezerManager;
		
		Item erse = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:erse"));
		if(erse==null)
		{
			System.err.println("Erse is Null!!!");
			return;
		}
		Item mulch = (Item) Item.REGISTRY.getObject(new ResourceLocation("Forestry:mulch"));
		if(mulch==null)
		{
			System.err.println("Mulch is Null!!!");
			return;
		}
		
		Fluid fluid = FluidRegistry.getFluid("juice");
		if(fluid==null)
		{
			System.err.println("Juice was not found");
			return;
		}
		FluidStack juice = new FluidStack(fluid, 300);
		
		sqee.addRecipe(5*20, new ItemStack[]{new ItemStack(erse)}, juice, new ItemStack(mulch), 10);
		
		fluid = FluidRegistry.getFluid("for.honey");
		if(fluid==null)
		{
			System.err.println("Honey was not found");
			return;
		}
		FluidStack honey = new FluidStack(fluid, 10000);
		ItemStack royal = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:cratedRoyalJelly")));
		ItemStack pollen = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:cratedPollen")));
		ItemStack frame = new ItemStack(FPFAItems.ironFrame);
		
		RecipeManagers.carpenterManager.addRecipe(600, honey, null, new ItemStack(FPFAItems.princessFrame), "RPR","PFP","RPR",
				'R', royal,
				'P', pollen,
				'F', frame);
		
		
		System.out.println("Adding Crafting Recipes");
		addCrafting();
		
		System.out.println("Adding Flowers");
		FlowerTypes.registerFlowers();
		System.out.println("Adding Bees");
		BeeTypes.registerBees();
		
		PotionManager.register();
		
		BreedingManager.registerBreedings();
		
		try
		{
			Method m_addAssemblyRecipe;
			Class c = Class.forName("futurepack.depend.api.RegistryCollection");
			m_addAssemblyRecipe = c.getMethod("addAssemblyRecipe", ItemStack[].class, ItemStack.class);
			
			ItemStack drone = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeDroneGE")));
			ItemStack princess = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("Forestry:beePrincessGE")));
			
			ItemStack chip = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:chip")),1,0);
			ItemStack eisen = new ItemStack(Items.IRON_INGOT);
			IIndividual bee = BeeManager.beeRoot.templateAsIndividual(BeeTypes.Metalic.getChromosomes());
			ItemStack droneOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);	
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{drone,chip,eisen}, droneOut);
			
			ItemStack princessOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);		
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{princess,chip,eisen}, princessOut);
			
			chip = new ItemStack((Item)Item.REGISTRY.getObject(new ResourceLocation("fp:chip")),1,1);
			eisen = OreDictionary.getOres("ingotRetium").get(0);
			bee = BeeManager.beeRoot.templateAsIndividual(BeeTypes.Cybren.getChromosomes());
			droneOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.DRONE);
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{drone,chip,eisen}, droneOut);
			
			princessOut = BeeManager.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS);
			m_addAssemblyRecipe.invoke(null, new ItemStack[]{princess,chip,eisen}, princessOut);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public void initClient(FMLInitializationEvent event)
	{
		ItemColors cols = Minecraft.getMinecraft().getItemColors();
		cols.registerItemColorHandler(new ItemColorizer(), FPFAItems.specialCombs);
		FPFAItems.setupRendering();
		
		
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		CombTypes.setup();
	}
	
	
	
	private void addCrafting()
	{
		Item tools = (Item) Item.REGISTRY.getObject(new ResourceLocation("fp:spaceship"));
		if(tools==null)
		{
			System.err.println("tools is null");
		}
		
		GameRegistry.addRecipe(new ShapedOreRecipe(FPFAItems.ironFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', Items.STRING));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(FPFAItems.neonFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotNeon"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(FPFAItems.retiumFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotRetium"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(FPFAItems.glowtitFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotGlowtit"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(FPFAItems.bioteriumFrame, "SSS","SFS","SSS",
				'S',new ItemStack(tools,1,12),
				'F', "ingotBioterium"));
		
		GameRegistry.addRecipe(new ItemStack(FPFAItems.princessFrame), "DLD", "PPP","DFD",
				'D', Item.REGISTRY.getObject(new ResourceLocation("Forestry:honeydew")),
				'L', Item.REGISTRY.getObject(new ResourceLocation("Forestry:beeLarvaeGE")),
				'P', Item.REGISTRY.getObject(new ResourceLocation("Forestry:propolis")),
				'F', FPFAItems.princessFrame);
		
		
	}

}
